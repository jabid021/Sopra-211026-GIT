package test.jupiter;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import exception.CheckLongException;
import service.PersonnageService;

@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class) // remplace @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
class PersonnageTest {

	@Autowired
	private PersonnageService personnageService;

	@Test
	@Disabled
	void testCreation() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSuppression() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBy() {
		assertThrows(CheckLongException.class, () -> personnageService.getBy(null));
	}

	@Test
	@Disabled
	void testGetByIdWithQuetes() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetByIdWithInventaire() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetByIdWithInventaireAndQuetes() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetAll() {
		fail("Not yet implemented");
	}

}
