package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.model.Cours;

public interface ICoursDao extends JpaRepository<Cours, Long> {

	@Query("select c from Cours c join c.matiere cm where cm.duree != c.duree")
	List<Cours> findAllCoursDureeSup();
	}