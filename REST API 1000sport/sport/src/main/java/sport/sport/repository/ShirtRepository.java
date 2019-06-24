package sport.sport.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sport.sport.model.Shirt;

public interface ShirtRepository extends JpaRepository<Shirt, Integer> {

	@Query("from Shirt where id_user = ?1")
	Set <Shirt> getShirtsByUser(Integer id);
	
	Set <Shirt> findByTitleIgnoreCaseContaining(String name);
	
}
