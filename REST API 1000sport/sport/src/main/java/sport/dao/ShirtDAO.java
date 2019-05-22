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
import sport.model.*;
import static sport.util.SavePicture.*;

public class ShirtDAO {

	private static Connection con = DatabaseFactory.getConnection();
	
	public static Shirt addShirt(int idUser,String title, String brand,
			                     String club, String season,String version, 
			                     String occasion, boolean gk,double price,
			                     InputStream pic0,InputStream pic1,InputStream pic2,InputStream pic3) {
		
		String sql = "INSERT INTO shirt(id_user,title,brand,club,season,version,occasion,gk,price) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1,idUser);
			stmt.setString(2, title);
			stmt.setString(3, brand);
			stmt.setString(4, club);
			stmt.setString(5, season);
			stmt.setString(6, version);
			stmt.setString(7, occasion);
			stmt.setBoolean(8, gk);
			stmt.setDouble(9, price);
			
			stmt.executeUpdate();
		
			ResultSet rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
			
				if(pic0 != null)
					uploadFile(pic0,rs.getInt("id") ,rs.getInt("id_user"),0);
				
				if(pic1 != null)
					uploadFile(pic1,rs.getInt("id"), rs.getInt("id_user"),1);
				
				if(pic2 != null)
					uploadFile(pic2,rs.getInt("id"), rs.getInt("id_user"),2);
				
				if(pic3 != null)
					uploadFile(pic3,rs.getInt("id"), rs.getInt("id_user"),3);
				
				return new Shirt(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),rs.getString("club"),
						         rs.getString("season"),rs.getString("version"),rs.getString("occasion"),
						         rs.getBoolean("gk"),rs.getDouble("price"));
			 }
			
			rs.close();
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
	
	public static Shirt updateShirt(int id,String title, String brand,
			                         String club, String season,String version, 
			                         String occasion, boolean gk,double price,
			                         InputStream pic0,InputStream pic1,InputStream pic2,InputStream pic3) {
		
		String sql = "UPDATE shirt SET title=?,brand=?,club=?,season=?,version=?,occasion=?,gk=?,price=? WHERE id=?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, title);
			stmt.setString(2, brand);
			stmt.setString(3, club);
			stmt.setString(4, season);
			stmt.setString(5, version);
			stmt.setString(6, occasion);
			stmt.setBoolean(7, gk);
			stmt.setDouble(8, price);
			stmt.setInt(9, id);
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
						
				if(pic0 != null)
					uploadFile(pic0,id,rs.getInt("id_user"), 0);
				
				if(pic1 != null)
					uploadFile(pic1,id,rs.getInt("id_user"), 1);
				
				if(pic2 != null)
				    uploadFile(pic2,id,rs.getInt("id_user"), 2);
				
				if(pic3 != null)
					uploadFile(pic3,id,rs.getInt("id_user"), 3);
					
				return new Shirt(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),rs.getString("club"),
				         rs.getString("season"),rs.getString("version"),rs.getString("occasion"),
				         rs.getBoolean("gk"),rs.getDouble("price"));
			}
			
			rs.close();
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
			
		}
		
		return null;
	}
	
	public static Shirt getShirt(int id){
		
		try {
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM shirt WHERE id=?",Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, id);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				
				return new Shirt(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),rs.getString("club"),
						         rs.getString("season"),rs.getString("version"),rs.getString("occasion"),
						         rs.getBoolean("gk"),rs.getDouble("price"));
			 }
			
			rs.close();
					
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
	}
		
		return null;	
 }
	
	public static Set<Shirt> getShirtsByUser(int id){
		
		Set<Shirt> myShirts = new LinkedHashSet<>();
		
		try {
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM shirt WHERE id_user=?",Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, id);
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				
				Shirt s = new Shirt(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),rs.getString("club"),
						         rs.getString("season"),rs.getString("version"),rs.getString("occasion"),
						         rs.getBoolean("gk"),rs.getDouble("price"));
				myShirts.add(s);
			 }
			
			rs.close();
					
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
	}
		
		return myShirts;	
 }
	
	public static void deleteShirt(int id) {
		
			try {
				
				PreparedStatement stmt = con.prepareStatement("DELETE FROM shirt WHERE id=?",Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, id);
				stmt.executeUpdate();
			
			} catch (SQLException e) {
				
				throw new RuntimeException(e);
			
			}	
	}
	

	public static Set <Shirt> getAllShirts(){
		
		
		Set<Shirt> allShirts = new LinkedHashSet<>();
		
		try {
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM shirt ORDER BY id", Statement.RETURN_GENERATED_KEYS);
			
			stmt.executeQuery();
			
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				
				Shirt shirt = new Shirt(rs.getInt("id"),rs.getInt("id_user"),rs.getString("title"),rs.getString("brand"),rs.getString("club"),
				         rs.getString("season"),rs.getString("version"),rs.getString("occasion"),
				         rs.getBoolean("gk"),rs.getDouble("price"));
				
				allShirts.add(shirt);
	
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allShirts;	
	}
	
}
