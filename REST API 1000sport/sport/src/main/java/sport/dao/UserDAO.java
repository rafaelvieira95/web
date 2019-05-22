package sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import sport.connection.DatabaseFactory;
import sport.model.*;

public class UserDAO {

	private static Connection con = DatabaseFactory.getConnection();
	
	public static User addUser(User user){
		
		try {
			
			String sql = "INSERT INTO users(namefantasy,societyreason,cnpj,name,surname,cpf,city,state,street,neighborhood,cep,number,nameuser,email,password)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, user.nameFantasy);
			stmt.setString(2, user.societyReason);
			stmt.setString(3, user.cnpj);
			
			stmt.setString(4, user.name);
			stmt.setString(5, user.surname);
			stmt.setString(6, user.cpf);
			
			stmt.setString(7, user.city);
			stmt.setString(8, user.state);
			stmt.setString(9, user.street);
			stmt.setString(10, user.neighborhood);
			stmt.setString(11, user.cep);
			stmt.setInt(12,user.number);
			
			stmt.setString(13, user.nameUser);
			stmt.setString(14, user.email);
			stmt.setString(15, user.password);
			
	        stmt.executeUpdate();
	        
	        ResultSet rs = stmt.getGeneratedKeys();
	        
	        
	        while(rs.next()) {
	        	
	        return new UserBuilder().nameFantasy(rs.getString("nameuser")).societyReason(rs.getString("societyreason")).
	        		   cnpj(rs.getString("cnpj")).name(rs.getString("name")).surname(rs.getString("surname")).
	        		   cpf(rs.getString("cpf")).city(rs.getString("city")).state(rs.getString("state")).
					   street(rs.getString("street")).neighborhood(rs.getString("neighborhood")).cep(rs.getString("cep")).
					   number(rs.getInt("number")).nameUser(rs.getString("nameuser")).email(rs.getString("email")).
					   password(rs.getString("password")).builder();
	        }
	        
	        rs.close();
	        
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
	public static User updateUser(int id,User user) {
			
		String sql = "UPDATE users SET namefantasy=?,societyreason=?,cnpj=?,name=?,surname=?,cpf=?,"
				+ "city=?,state=?,street=?,neighborhood=?,cep=?,number=?,nameuser=?,email=?,password=? WHERE id=?";
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, user.nameFantasy);
			stmt.setString(2, user.societyReason);
			stmt.setString(3, user.cnpj);
			stmt.setString(4, user.name);
			stmt.setString(5, user.surname);
			stmt.setString(6, user.cpf);
			stmt.setString(7, user.city);
			stmt.setString(8, user.state);
			stmt.setString(9, user.street);
			stmt.setString(10, user.neighborhood);
			stmt.setString(11, user.cep);
			stmt.setInt(12,user.number);
			stmt.setString(13, user.nameUser);
			stmt.setString(14, user.email);
			stmt.setString(15, user.password);
			stmt.setInt(16, id);
			
			stmt.executeUpdate();
			
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				
				 return new UserBuilder().nameFantasy(rs.getString("namefantasy")).societyReason(rs.getString("societyreason")).
						   cnpj(rs.getString("cnpj")).name(rs.getString("name")).surname(rs.getString("surname")).
						   cpf(rs.getString("cpf")).city("city").state("state").street("street").
						   neighborhood(rs.getString("neighborhood")).cep(rs.getString("cep")).number(rs.getInt("number")).
						   nameUser(rs.getString("nameuser")).email(rs.getString("email")).password(rs.getString("password")).builder();
			}
			
			rs.close();
			
		 } catch (SQLException e) {
		   throw new RuntimeException(e);
		}
			
		return null;
	}
	
	public static void deleteUser(int id) {
		
		try {
		
			PreparedStatement stmt = con.prepareStatement("DELETE FROM users WHERE id =?");
		    
			stmt.setInt(1, id);
		    stmt.executeUpdate();
	  
		} catch (SQLException e) {
			
	     	throw new RuntimeException(e);
		}
		
	}
	
	
	public static User getUserByEmail(String email) {
		
		
		String sql ="SELECT * FROM users WHERE email=?";
		
		try {
		
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    stmt.setString(1, email);
		    stmt.executeQuery();
		    
		    ResultSet rs = stmt.getResultSet();
		    
		    while(rs.next()) {
		   
		    	return new User(rs.getInt("id"),rs.getString("email"),rs.getString("password"));
		    }
		
		    rs.close();
		    
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
         return null;
	}
	
	public static User getUser(int id) {
			
		try {
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE id=?",Statement.RETURN_GENERATED_KEYS);
			
	        stmt.setInt(1, id);
			stmt.executeQuery();        
			
	        ResultSet rs = stmt.getResultSet();
			
	        while(rs.next()) {
	        	
	        	return new UserBuilder().id(rs.getInt("id")).nameFantasy(rs.getString("namefantasy")).
	        			   societyReason(rs.getString("societyreason")).cnpj(rs.getString("cnpj")).name(rs.getString("name")).
	        			   surname(rs.getString("surname")).cpf(rs.getString("cpf")).city(rs.getString("city")).
	        			   state(rs.getString("state")).street(rs.getString("street")).neighborhood(rs.getString("neighborhood")).
						   cep(rs.getString("cep")).number(rs.getInt("number")).nameUser(rs.getString("nameuser")).
						   email(rs.getString("email")).password(rs.getString("password")).builder();
	        }
	        
	        rs.close();
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
	
		return null;
		
	}
	
	public static Set <User> getAllUsers() {
		
		Set<User> allUsers = new LinkedHashSet<>();
		
		try {
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM users ORDER BY id",Statement.RETURN_GENERATED_KEYS);
	       
			stmt.executeQuery();  
	       
	        ResultSet rs = stmt.getResultSet();
			
	        while(rs.next()) {
	        	
	        	User user = new UserBuilder().id(rs.getInt("id")).nameFantasy(rs.getString("namefantasy")).
	        			   societyReason(rs.getString("societyreason")).cnpj(rs.getString("cnpj")).name(rs.getString("name")).
	        			   surname(rs.getString("surname")).cpf(rs.getString("cpf")).city(rs.getString("city")).
	        			   state(rs.getString("state")).street(rs.getString("street")).neighborhood(rs.getString("neighborhood")).
	        			   cep(rs.getString("cep")).number(rs.getInt("number")).nameUser(rs.getString("nameuser")).
						   email(rs.getString("email")).password(rs.getString("password")).builder();
	        	
	        	allUsers.add(user);
	        }
	        
	        rs.close();
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
		
		return allUsers;
	}
	
	
}
