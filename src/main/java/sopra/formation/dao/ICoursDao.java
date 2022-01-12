package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Cours;

public interface ICoursDao extends JpaRepository<Cours, Long> {

	@Query("select c from Cours c join c.filiere f join c.matiere join c.formateur where f.id=:id")
	List<Cours> findByFiliereWithInfos(@Param("id") Long id);
}
