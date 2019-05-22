package sport.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;

import sport.connection.DatabaseFactory;
import sport.model.Ball;
import static sport.util.SavePicture.*;

public class BallDAO {

	private static Connection con = DatabaseFactory.getConnection();
	
	public static Ball addBall(int idUser,String title,String brand,String model,String year,boolean field,double price,
			                     InputStream pic0, InputStream pic1, InputStream pic2, InputStream pic3) {
		
		String sql= "INSERT INTO ball(id_user,title,brand,model,year,field,price) VALUES (?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, idUser);
			stmt.setString(2, title);
			stmt.setString(3, brand);
			stmt.setString(4, model);
			stmt.setString(5, year);
			stmt.setBoolean(6, field);
			stmt.setDouble(7, price);
			
			stmt.executeUpdate();
		
			ResultSet rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				
				if(pic0 != null)
					uploadFile(pic0, rs.getInt("id"), idUser, 0);
				if(pic1 != null)
					uploadFile(pic1, rs.getInt("id"), idUser, 1);
				if(pic2 != null)
					uploadFile(pic2, rs.getInt("id"), idUser, 2);
				if(pic3 != null)
					uploadFile(pic3, rs.getInt("id"), idUser, 3);
						
				return new Ball(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
						        rs.getString("model"),rs.getString("year"),rs.getBoolean("field"),rs.getDouble("price"));
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
	
     public static Ball updateBall(int id,String title,String brand,String model,String year,boolean field,double price,
             InputStream pic0, InputStream pic1, InputStream pic2, InputStream pic3) {
		 
    	 String sql = "UPDATE ball SET title=?,brand=?,model=?,year=?,field=?,price=? WHERE id=?";
    	 
    		try {
    			
    			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    			
    	
    			stmt.setString(1, title);
    			stmt.setString(2, brand);
    			stmt.setString(3, model);
    			stmt.setString(4, year);
    			stmt.setBoolean(5, field);
    			stmt.setDouble(6, price);
    			stmt.setInt(7, id);
    			
    			stmt.executeUpdate();
    		
    			ResultSet rs = stmt.getGeneratedKeys();
    			
    			while(rs.next()) {
    				
    				if(pic0 != null)
    					uploadFile(pic0, rs.getInt("id"),rs.getInt("id_user"), 0);
    				if(pic1 != null)
    					uploadFile(pic1, rs.getInt("id"),rs.getInt("id_user"), 1);
    				if(pic2 != null)
    					uploadFile(pic2, rs.getInt("id"),rs.getInt("id_user"), 2);
    				if(pic3 != null)
    					uploadFile(pic3, rs.getInt("id"),rs.getInt("id_user"), 3);
    						
    				return new Ball(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
    						        rs.getString("model"),rs.getString("year"),rs.getBoolean("field"),rs.getDouble("price"));
    				
    			}
    			
    			rs.close();
    			
    		} catch (SQLException e) {
    			throw new RuntimeException(e);
    		}
    	 
		return null;
	}
     
     
     public static Ball getBall(int id) {
 		
    	 try {
		
    		 PreparedStatement stmt = con.prepareStatement("SELECT * FROM ball WHERE id=?",Statement.RETURN_GENERATED_KEYS);
    		 
    		 stmt.setInt(1, id);
    		 stmt.executeQuery();
    		
    		 ResultSet rs = stmt.getResultSet();
    		 
    		 while(rs.next()) {
    			 
    			 return new Ball(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
					             rs.getString("model"),rs.getString("year"),rs.getBoolean("field"),rs.getDouble("price"));
    		
    		 }
    		 
    		 rs.close();
    		
    	 } catch (SQLException e) {
		
			throw new RuntimeException(e);
			
		}
    	 
 		return null;
 	}
     
     
     public static Set<Ball> getBallsByUser(int id){
    	 
    	 Set<Ball> allBallsByUser = new LinkedHashSet<>();
    	 
    	 try {
    		 
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM ball WHERE id_user=?");
			
			stmt.setInt(1, id);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				
				Ball ball = new Ball(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
						    rs.getString("model"),rs.getString("year"),rs.getBoolean("field"),rs.getDouble("price"));
				
				allBallsByUser.add(ball);
	
			}
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
    	 
    	 return allBallsByUser;
     }
     
     public static void deleteBall(int id) {

		try {

			PreparedStatement stmt = con.prepareStatement("DELETE FROM ball WHERE id=?",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		}

 	} 
	
     public static Set<Ball> getAllBalls() {
 		
    	 Set <Ball> allBalls = new LinkedHashSet<>();
 		
 		
 		try {
 			
 			PreparedStatement stmt = con.prepareStatement("SELECT * FROM ball ORDER BY id", Statement.RETURN_GENERATED_KEYS);
 			
 			stmt.executeQuery();
 			
 			ResultSet rs = stmt.getResultSet();
 			
 			while(rs.next()) {
 				
 				Ball ball = new Ball(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),
			             rs.getString("model"),rs.getString("year"),rs.getBoolean("field"),rs.getDouble("price"));
 				
 				allBalls.add(ball);
 	
 			}
 			
 			rs.close();
 			
 		} catch (SQLException e) {
 			
 			 throw new RuntimeException(e);
 		}
    	 
    	 
 		return allBalls;
 	}
	
}
