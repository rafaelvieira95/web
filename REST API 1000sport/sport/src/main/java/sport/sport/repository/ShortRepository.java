package sport.sport.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sport.sport.model.Short;

public interface ShortRepository extends JpaRepository<Short, Integer> {

	@Query("from Short where id_user = ?1")
	Set <Short> getShortsByUser(Integer id);
	
	Set <Short> findByTitleIgnoreCaseContaining(String name);
	
}
