package es.upm.grise.profundizacion.AccountManager.dataAccess;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataAccessSingletonTest {
	
	int CUSTOMER_ID = 1;
	double BALANCE = 550.5;

	//Este test no sirve para unit testing, ver apuntes 6 y 7
	/* @Test
	public void comprobarQueRecuperoElClienteCorrecto() {
		DataAccessSingleton da = DataAccessSingleton.getInstance();
		Customer customer = da.getCustomer(CUSTOMER_ID);
		assertEquals(CUSTOMER_ID, customer.getId());
		assertEquals(BALANCE, customer.getBalance(),0.01);
		
	} */

	@Test
	public void comprobarQueRecuperoElClienteCorrecto() {
		DataAccessSingleton da = DataAccessSingletonDouble.getInstance();
		Customer customer = da.getCustomer(CUSTOMER_ID);
		assertEquals(CUSTOMER_ID, customer.getId());
		assertEquals(BALANCE, customer.getBalance(),0.01);
	}
	
}
