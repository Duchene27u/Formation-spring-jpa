package sopra.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Salle;

public interface ISalleDao extends JpaRepository<Salle, Long> {

}
