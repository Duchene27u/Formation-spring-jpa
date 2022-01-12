package sopra.formation.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Formateur;
import sopra.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {

	Formateur findByEmail(String email);
	
	@Query("select f from Formateur f where f.email = :mail")
	Formateur findByMail2(@Param("mail") String email);
	
	@Query("select f from Formateur f join f.absences fa join fa.competences fac where fac.matiere.nom =:nomMatiere and fa.date<startDate and fa.date>endDate ")
	List<Formateur> findTrainerAvailable(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endate,@Param("nomMatiere") String nomMatiere);
	
	@Query("select f from Formateur f join f.competences comp join comp.matiere mat join fetch mat.cours")
	List<Formateur> findAllTrainerWithCoursAndMatiere();
}
