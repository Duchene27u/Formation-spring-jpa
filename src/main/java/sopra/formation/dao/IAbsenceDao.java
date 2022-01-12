package sopra.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Absence;

public interface IAbsenceDao extends JpaRepository<Absence, Long> {



}
