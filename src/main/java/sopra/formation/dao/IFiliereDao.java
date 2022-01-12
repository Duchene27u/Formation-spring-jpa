package sopra.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Filiere;

public interface IFiliereDao extends JpaRepository<Filiere, Long> {

}
