package sport.sport.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sport.sport.model.Ball;


public interface BallRepository extends JpaRepository<Ball, Integer> {

	@Query("from Ball where id_user = ?1")
	Set <Ball> getBallsByUser(Integer id);
	
	Set <Ball> findByTitleIgnoreCaseContaining(String name);
	
}
