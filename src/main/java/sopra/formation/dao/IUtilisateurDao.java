package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Formateur;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {

	@Query("select distinct s from Stagiaire s left join fetch s.cursus") 
	List<Stagiaire> findStagiaireWithCursus();

	@Query("select distinct f from Formateur f left join fetch f.cours where f.nom = :nom and f.prenom = :prenom ")
	List<Formateur> findFormateurByNomPrenomWithCours(@Param("nom") String nom, @Param("prenom") String prenom);

}
