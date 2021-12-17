package test.jupiter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import exception.PersonnageException;
import model.Personnage;
import model.Race;
import repository.PersonnageRepository;

@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class) // remplace @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
class PersonnageRepoTest {

	@Autowired
	private PersonnageRepository personnageRepo;

	@Test
	void test() {
		assertNotNull(personnageRepo);
	}

	@Test
	public void testInsert() {
		Personnage personnage = new Personnage("perso test", 1000, Race.Nain, false);
		personnageRepo.save(personnage);
		assertNotNull(personnage.getId());
		assertTrue(personnageRepo.findById(personnage.getId()).isPresent());
	}

	@Test
	public void testPersonnageException() {
		assertThrows(PersonnageException.class,
				() -> personnageRepo.findById(10000L).orElseThrow(PersonnageException::new));
	}

	@Test
	@Disabled("probleme avec le perso")
	public void testDataPersonnage() {
		Personnage p = new Personnage("perso test", 1000, Race.Nain, false);
		personnageRepo.save(p);
		final Personnage personnage = personnageRepo.findById(p.getId()).get();
		// @formatter:off	
		assertAll("controle des donnees du personnage inseré", 
						() -> assertEquals("perso test", personnage.getNom()),
						() -> assertEquals(1000, personnage.getPv()), 
						() -> assertEquals(Race.Nain, personnage.getRace()),
						() -> assertFalse(personnage.isVivant()));	
		// @formatter:on
	}

	@BeforeAll // remplace BeforeClass
	public static void setup() {
		System.out.println("beforeAll");
	}

	@BeforeEach
	public void init() {
		System.out.println("test");
	}

	@AfterAll
	public static void end() {
		System.out.println("afterAll");
	}

	@AfterEach
	public void endTest() {
		System.out.println("endTest");
	}

}
