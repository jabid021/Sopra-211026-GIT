package test;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import exception.PersonnageException;
import model.Personnage;
import model.Race;
import repository.PersonnageRepository;

@Transactional
@Rollback(true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestPersonnageRepoAvecSpringTest {

	@Autowired
	PersonnageRepository personnageRepo;

	@Test
	public void test() {
		assertNotNull(personnageRepo);
	}

	@Test
	public void testInsert() {
		Personnage personnage = new Personnage("perso test", 1000, Race.Nain, false);
		personnageRepo.save(personnage);
		assertNotNull(personnage.getId());
		assertTrue(personnageRepo.findById(personnage.getId()).isPresent());
	}

	@Test(expected = PersonnageException.class)
	public void testPersonnageException() {
		personnageRepo.findById(10000L).orElseThrow(PersonnageException::new);
	}

}
