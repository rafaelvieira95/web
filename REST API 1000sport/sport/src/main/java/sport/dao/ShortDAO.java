package sport.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import sport.connection.DatabaseFactory;
import sport.model.Boot;
import sport.model.Short;
import static sport.util.SavePicture.*;

public class ShortDAO {

	private static Connection con = DatabaseFactory.getConnection();
	
	public static Short addShort(int idUser, String title,String brand,String model,
			                     String chooseGender, String chooseSize,double price,
			                     InputStream pic0, InputStream pic1, InputStream pic2, InputStream pic3) {
		
		   
		String sql = "INSERT INTO short(id_user,title,brand,model,choosegender,choosesize,price) VALUES (?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, idUser);
			stmt.setString(2, title);
			stmt.setString(3, brand);
			stmt.setString(4, model);
			stmt.setString(5, chooseGender);
			stmt.setString(6, chooseSize);
			stmt.setDouble(7, price);
			
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
				
				
				return new Short(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
						         rs.getString("model"),rs.getString("choosegender"),rs.getString("choosesize"),rs.getDouble("price"));
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			
        throw new RuntimeException(e);
        
		}
		
		return null;
	}
	
     public static Short updateShort(int id,String title,String brand,String model,
                                     String chooseGender, String chooseSize,double price,
                                     InputStream pic0, InputStream pic1, InputStream pic2, InputStream pic3) {
		
    	 
    	 String sql = "UPDATE short SET title=?,brand=?,model=?,choosegender=?,choosesize=?,price=? WHERE id=?";
    	 
    	 try {
    		 
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			

			stmt.setString(1, title);
			stmt.setString(2, brand);
			stmt.setString(3, model);
			stmt.setString(4, chooseGender);
			stmt.setString(5, chooseSize);
			stmt.setDouble(6, price);
			stmt.setInt(7, id);
			
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
				
				
				return new Short(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
						         rs.getString("model"),rs.getString("choosegender"),rs.getString("choosesize"),rs.getDouble("price"));
							
			}
			
			rs.close();
			
		} catch (SQLException e) {
			
			 throw new RuntimeException(e);
			 
		}
    	
		return null;
	}
     
     public static Short getShort(int id) {
 		
    
    	 try {
    		 
			PreparedStatement stmt = con.prepareStatement("SELECT *FROM short WHERE id=?", Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, id);
			
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
			
				return new Short(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
				         rs.getString("model"),rs.getString("choosegender"),rs.getString("choosesize"),rs.getDouble("price"));
			}
			
			rs.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
    	 	 
 		return null;
 	}
     
    public static Set<Short> getShortsByUser(int id){
    	 
    	 Set<Short> allShortsByUser = new LinkedHashSet<>();
    	 
    	 try {
    		 
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM short WHERE id_user=?");
			
			stmt.setInt(1, id);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				  
				Short shorts = new Short(rs.getInt("id"),rs.getInt("id_user"), rs.getString("title"),rs.getString("brand"),
						rs.getString("model"), rs.getString("choosegender"), rs.getString("choosesize"),rs.getDouble("price"));
				
				allShortsByUser.add(shorts);
	
			}
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
    	 
    	 return allShortsByUser;
     }
     
     
     public static void deleteShort(int id) {
 		
    	 try {

 			PreparedStatement stmt = con.prepareStatement("DELETE FROM short WHERE id=?",
 					     Statement.RETURN_GENERATED_KEYS);
 			
 			stmt.setInt(1, id);
 			stmt.executeUpdate();

 		} catch (SQLException e) {

 			throw new RuntimeException(e);

 	 }
 	} 
	
     public static Set <Short> getAllShorts() {
 		
    	 Set <Short> allShorts = new LinkedHashSet<>();
   		
   		try {
   			
   			PreparedStatement stmt = con.prepareStatement("SELECT * FROM short ORDER BY id",Statement.RETURN_GENERATED_KEYS);
   	
   			stmt.executeQuery();
   			
   			ResultSet rs = stmt.getResultSet();
   			
   			while(rs.next()) {
   				
   				Short shorts = new Short(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
				              rs.getString("model"),rs.getString("choosegender"),rs.getString("choosesize"),rs.getDouble("price"));
   				
   				allShorts.add(shorts);
   	
   			}
   			
   			rs.close();
   			
   		} catch (SQLException e) {
   			
   			 throw new RuntimeException(e);
   		}
    	 
    	 
 		return allShorts;
 	}
	
	
}
