package sport.sport.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sport.sport.model.Boot;

public interface BootRepository extends JpaRepository<Boot, Integer> {

	@Query("from Boot where id_user = ?1")
	Set <Boot> getBootsByUser(Integer id);
	
	Set <Boot> findByTitleIgnoreCaseContaining(String name);
}
