package sport.sport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sport.sport.model.User;
import sport.sport.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping(path="/api/login")
public class Login {

	@Autowired
	private UserRepository login;
	
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<User> singIn(String email,String password){
	  
          User user = login.getUserByEmail(email);
         
          if(user != null) {
        	  
        	  if(password.equals(user.getPassword())) {
        		  return new ResponseEntity<User>(user,HttpStatus.OK); 
        	  
        	  }else{
        		 return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);  
        	  }
        	  
          }else {
       
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
         }
  }
	
}
