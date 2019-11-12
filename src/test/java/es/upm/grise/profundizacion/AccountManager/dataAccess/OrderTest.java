package es.upm.grise.profundizacion.AccountManager.dataAccess;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void elObjetoSeCreaCorrectamente() {
		
		double AMOUNT = 100.0;
		boolean VALID = true;
		boolean PROCESSED = false;
		
		Order order = new Order(AMOUNT, VALID, PROCESSED);
		
		assertEquals(AMOUNT, order.getAmount(), 0.01);
		assertTrue(order.isValid());
		assertFalse(order.wasProcessed());
	}

}
