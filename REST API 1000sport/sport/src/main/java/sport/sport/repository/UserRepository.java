package sport.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sport.sport.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User where email= ?1")
	User getUserByEmail(String email);
	
	
}
