package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;

public interface IFiliereDao extends JpaRepository<Filiere, Long> {

	@Query("select f from filiere f where f.salle.adresse.ville = :name")
	List<Filiere> findAllWhereCityName(@Param("name") String name);
	
	@Query("select distinct f from Filiere f left join fetch f.cours where f.id = :id")
	Filiere findByIdWithSalleReferentCours(@Param("id") Long id);
}
