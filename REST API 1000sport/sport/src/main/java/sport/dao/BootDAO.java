package sport.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;
import static sport.util.SavePicture.*;

import sport.connection.DatabaseFactory;
import sport.model.Boot;

public class BootDAO {

	private static Connection con = DatabaseFactory.getConnection();
	
	public static Boot addBoot(int idUser, String title,String brand,String model,
			                   String bootsGender,int bootSize,String version,boolean field,double price,
			                   InputStream pic0, InputStream pic1, InputStream pic2, InputStream pic3) {
		
		String sql ="INSERT INTO boot(id_user,title,brand,model,bootsgender,bootsize,version,field,price) VALUES (?,?,?,?,?,?,?,?,?)";        
			
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, idUser);
			stmt.setString(2, title);
			stmt.setString(3, brand);
			stmt.setString(4, model);
			stmt.setString(5, bootsGender);
			stmt.setInt(6, bootSize);
			stmt.setString(7, version);
			stmt.setBoolean(8, field);
			stmt.setDouble(9, price);
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				
				if(pic0 != null)
					uploadFile(pic0, rs.getInt("id"), rs.getInt("id_user"), 0);
				
				if(pic1 != null)
					uploadFile(pic1, rs.getInt("id"), rs.getInt("id_user"), 1);
				
				if(pic2 != null)
					uploadFile(pic2, rs.getInt("id"), rs.getInt("id_user"), 2);
				
				if(pic3 != null)
					uploadFile(pic3, rs.getInt("id"), rs.getInt("id_user"), 3);
				
				
				return new Boot(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
						         rs.getString("model"),rs.getString("bootsgender"),rs.getInt("bootsize"),rs.getString("version"),
						         rs.getBoolean("field"),rs.getDouble("price")); 
						
		}
			
			rs.close();
			
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
     public static Boot updateBoot(int id,String title,String brand,String model,
             String bootsGender,int bootSize,String version,boolean field,double price,
             InputStream pic0, InputStream pic1, InputStream pic2, InputStream pic3) {
		
    	 
    	 String sql = "UPDATE boot SET title=?,brand=?,model=?,bootsgender=?,version=?,field=?,price=? WHERE id=?";
    	 
    	 try {
    		 
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, title);
			stmt.setString(2, brand);
			stmt.setString(3, model);
			stmt.setString(4, bootsGender);
			stmt.setInt(5, bootSize);
			stmt.setString(6, version);
			stmt.setBoolean(7, field);
			stmt.setDouble(8, price);
			stmt.setInt(9, id);
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
		   while(rs.next()) {
	
			   if(pic0 != null)
					uploadFile(pic0, rs.getInt("id"), rs.getInt("id_user"), 0);
				
				if(pic1 != null)
					uploadFile(pic1, rs.getInt("id"), rs.getInt("id_user"), 1);
				
				if(pic2 != null)
					uploadFile(pic2, rs.getInt("id"), rs.getInt("id_user"), 2);
				
				if(pic3 != null)
					uploadFile(pic3, rs.getInt("id"), rs.getInt("id_user"), 3);
				
				
				return new Boot(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
						         rs.getString("model"),rs.getString("bootsgender"),rs.getInt("bootsize"),rs.getString("version"),
						         rs.getBoolean("field"),rs.getDouble("price")); 
			   
		   }
		   
		   rs.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
    	 
		return null;
	}
     
     
     public static Boot getBoot(int id) {
 		
    	 String sql = "SELECT *FROM boot WHERE id=?";
    	 
    	 try {
		
    		 PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
    		 stmt.setInt(1, id);
    		 
    		 stmt.executeQuery();
    		 
    		 ResultSet rs = stmt.getResultSet();
    		 
    		 while(rs.next()) {
    			 
    			 return new Boot(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
				         rs.getString("model"),rs.getString("bootsgender"),rs.getInt("bootsize"),rs.getString("version"),
				         rs.getBoolean("field"),rs.getDouble("price")); 
    		 }
    		 
    		 rs.close();
    		 
    	 } catch (SQLException e) {
		
			throw new RuntimeException(e);
			
		}
    	 
    
 		return null;
 	}
     
     
    public static Set<Boot> getBootsByUser(int id){
    	 
    	 Set<Boot> allBootsByUser = new LinkedHashSet<>();
    	 
    	 try {
    		 
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM boot WHERE id_user=?");
			
			stmt.setInt(1, id);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				  
				Boot ball = new Boot(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
						rs.getString("model"),rs.getString("bootsgender"),
						rs.getInt("bootsize"),rs.getString("version"),rs.getBoolean("field"),rs.getDouble("price"));
				
				allBootsByUser.add(ball);
	
			}
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
    	 
    	 return allBootsByUser;
     }
     
    
    
     public static void deleteBoot(int id) {
 		
    	
    		try {

    			PreparedStatement stmt = con.prepareStatement("DELETE FROM boot WHERE id=?",
    					Statement.RETURN_GENERATED_KEYS);
    			stmt.setInt(1, id);
    			stmt.executeUpdate();

    		} catch (SQLException e) {

    			throw new RuntimeException(e);

    	 }
 	} 
     
     public static Set<Boot> getAllBoots() {
 		
    	 Set <Boot> allBoots = new LinkedHashSet<>();
  		
  		
  		try {
  			
  			PreparedStatement stmt = con.prepareStatement("SELECT * FROM boot ORDER BY id",Statement.RETURN_GENERATED_KEYS);
  	
  			stmt.executeQuery();
  			
  			ResultSet rs = stmt.getResultSet();
  			
  			while(rs.next()) {
  				
  				Boot boot = new Boot(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
				         rs.getString("model"),rs.getString("bootsgender"),rs.getInt("bootsize"),rs.getString("version"),
				         rs.getBoolean("field"),rs.getDouble("price")); 
  				
  				allBoots.add(boot);
  	
  			}
  			
  			rs.close();
  			
  		} catch (SQLException e) {
  			
  			 throw new RuntimeException(e);
  		}
    	 
    	 
 		return allBoots;
 	}
	
}
