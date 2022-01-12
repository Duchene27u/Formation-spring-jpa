package sopra.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {

}
