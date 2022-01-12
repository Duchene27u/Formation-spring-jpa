package sopra.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Cours;

public interface ICoursDao extends JpaRepository<Cours, Long> {

}
