package sopra.formation.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.config.ApplicationConfig;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IUtilisateurDao;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Filiere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
//@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestJunit4 {

	@Autowired
	private IUtilisateurDao personneDao;

	@Test
	public void formateur() {

		int nbStartFiliere = personneDao.findAll().size();
		
	}

}
