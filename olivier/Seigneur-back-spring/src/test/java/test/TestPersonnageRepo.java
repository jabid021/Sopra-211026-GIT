package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import model.Personnage;
import repository.PersonnageRepository;

public class TestPersonnageRepo {

	private static AnnotationConfigApplicationContext ctx;
	private PersonnageRepository personnageRepo;

	@BeforeClass
	public static void methodeExecutee1FoisAvantLesTests() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterClass
	public static void execution1FoisApresLesTests() {
		ctx.close();
	}

	@Before
	public void execution1FoisAvantCHAQUETest() {
		personnageRepo = ctx.getBean(PersonnageRepository.class);
	}

	@After
	public void execution1FoisApresChaqueTest() {

	}

	@Test
	public void personneRepositoryOk() {
		assertNotNull(personnageRepo);
	}

	@Test
	public void testFindByIdWithQuetesAndInventaire() {
		Personnage personnage = personnageRepo.findByIdWithInventaireAndQuetes(100L).get();
		assertNotNull(personnage.getQuetes());
		assertNotNull(personnage.getInventaire());
	}

}
