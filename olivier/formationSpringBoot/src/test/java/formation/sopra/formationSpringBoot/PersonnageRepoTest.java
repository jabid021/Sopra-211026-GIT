package formation.sopra.formationSpringBoot;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import formation.sopra.formationSpringBoot.exception.PersonnageException;
import formation.sopra.formationSpringBoot.model.Personnage;
import formation.sopra.formationSpringBoot.model.Race;
import formation.sopra.formationSpringBoot.repository.PersonnageRepository;

@SpringBootTest
@Transactional
@Rollback(true)
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
