package sport.sport.controller;


import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sport.sport.model.User;
import sport.sport.repository.UserRepository;
import static sport.sport.util.FileOperator.*;

@RestController
@CrossOrigin
@RequestMapping(path="/api/users")
public class UserService {

	@Autowired
	private UserRepository users;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Set <User>> getAllUsers() {
		
		return new ResponseEntity<Set<User>>(new LinkedHashSet<>(users.findAll()),HttpStatus.OK);
		
	}
		
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		
		Optional<User> user =  users.findById(id);
		
		if(user.isPresent()) {
			return new ResponseEntity<User>(user.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {

		return user != null ? new ResponseEntity<User>(users.save(user),HttpStatus.OK):
			                  new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	
    @RequestMapping(value="{id}",method=RequestMethod.PUT)
	public ResponseEntity <User> updateUser(@PathVariable("id") Integer id,@RequestBody User user) {
	    
    	Optional <User> userUpdate = users.findById(id);
    	
    	if(userUpdate.isPresent()) {
    		
    	userUpdate.get().setSocietyReason(user.getSocietyReason());
    	userUpdate.get().setNameFantasy(user.getNameFantasy());
    	userUpdate.get().setCnpj(user.getCnpj());
    	
    	userUpdate.get().setName(user.getName());
    	userUpdate.get().setSurname(user.getSurname());
    	userUpdate.get().setCpf(user.getCpf());
    	
    	userUpdate.get().setState(user.getState());
    	userUpdate.get().setCity(user.getCity());
    	userUpdate.get().setNeighborhood(user.getNeighborhood());
    	userUpdate.get().setStreet(user.getStreet());
    	userUpdate.get().setCep(user.getCep());
    	userUpdate.get().setNumber(user.getNumber());
    	
    	userUpdate.get().setNameUser(user.getNameUser());
    	userUpdate.get().setEmail(user.getEmail());
    	userUpdate.get().setPassword(user.getPassword());
    	
    	return new ResponseEntity<User>(users.save(userUpdate.get()),HttpStatus.OK);
    }
    	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
}
	
	@RequestMapping(value="{id}",method= RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
		  	   
		   if(users.existsById(id)) {
			   
			   users.deleteById(id);
			   deleteAllFilesByUser(id);

			   return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		   }else
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
