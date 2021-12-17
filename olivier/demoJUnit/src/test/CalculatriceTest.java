package test;

import static org.junit.Assert.*;


import org.junit.Test;

import demoJUnit.Calculatrice;

public class CalculatriceTest {

	@Test
	public void test() {
		Calculatrice calculatrice = new Calculatrice();
		assertEquals(2, calculatrice.addition(2, 2), 0);
		assertEquals(2, calculatrice.addition(1, 1), 0);
	
	}

	@Test
	public void test2() {
		// un test bidon
	}

}
