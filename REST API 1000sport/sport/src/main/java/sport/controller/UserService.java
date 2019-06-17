package sport.controller;


import java.util.Set;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sport.dao.UserDAO;
import sport.model.User;


@Path("users")
public class UserService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Set <User> getAllUsers() {
		return UserDAO.getAllUsers();
	}
		
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User getUser(@PathParam("id") int id) {
		return UserDAO.getUser(id);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public User addUser(User user) {
		return UserDAO.addUser(user);
	}
	
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User updateUser(@PathParam("id") int id,User user) {
		return UserDAO.updateUser(id, user);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public void deleteUser(@PathParam("id") int id) {
		UserDAO.deleteUser(id);
	}
	
}
