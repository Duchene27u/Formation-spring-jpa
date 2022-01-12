package sopra.formation.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.formation.config.ApplicationConfig;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Filiere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
//@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestJunit4WithSpring {

	@Autowired
	private IFiliereDao filiereDao;
	
	@Autowired
	private IUtilisateur utilisateurDao;

	@Test
	public void filiere() {

		int nbStartFiliere = filiereDao.findAll().size();

		Filiere filiere = new Filiere();
		filiere.setDateDebut(LocalDate.of(2021, Month.NOVEMBER, 29));
		filiere.setDuree(45);
		filiere.setDispositif(Dispositif.CPRO);

		filiere = filiereDao.save(filiere);

		Filiere filiereBis = new Filiere();
		filiereBis.setDateDebut(LocalDate.of(2021, Month.DECEMBER, 16));
		filiereBis.setDuree(57);
		filiereBis.setDispositif(Dispositif.POEI);

		filiereBis = filiereDao.save(filiereBis);

		filiere = filiereDao.findById(filiere.getId()).get();

		Assert.assertEquals(0, filiere.getVersion());
		Assert.assertEquals(LocalDate.of(2021, Month.NOVEMBER, 29), filiere.getDateDebut());
		Assert.assertEquals(45, filiere.getDuree());
		Assert.assertEquals(Dispositif.CPRO, filiere.getDispositif());

		filiere.setDateDebut(LocalDate.of(2021, Month.DECEMBER, 6));
		filiere.setDuree(57);
		filiere.setDispositif(Dispositif.POEI);

		filiere = filiereDao.save(filiere);

		filiere = filiereDao.findById(filiere.getId()).get();

		Assert.assertEquals(1, filiere.getVersion());
		Assert.assertEquals(LocalDate.of(2021, Month.DECEMBER, 6), filiere.getDateDebut());
		Assert.assertEquals(57, filiere.getDuree());
		Assert.assertEquals(Dispositif.POEI, filiere.getDispositif());

		int nbEndFiliere = filiereDao.findAll().size();

		Assert.assertEquals(2, nbEndFiliere - nbStartFiliere);

		filiereDao.deleteById(filiere.getId());

		Optional<Filiere> optFiliere = filiereDao.findById(filiere.getId());

		if (optFiliere.isPresent()) {
			Assert.fail("Erreur Suppression Filiere");
		}


		filiereDao.delete(filiereBis);
		

		optFiliere = filiereDao.findById(filiereBis.getId());

		Assert.assertTrue(optFiliere.isEmpty());

	}

	@Test
	public void mAtiere() {

	}
}
