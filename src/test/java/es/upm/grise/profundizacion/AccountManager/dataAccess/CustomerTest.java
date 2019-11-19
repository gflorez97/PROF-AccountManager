package es.upm.grise.profundizacion.AccountManager.dataAccess;

import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void elClienteSeCreaCorrectamente() {
		
		int ID = 1;
		double BALANCE = 200.0;
		Vector<Order> VECTOR = null;
		
		//Customer customer = new Customer(ID, BALANCE, VECTOR);
		Customer customer = new Customer();
		
		
		//Si no existiera un getter del id, no podría hacerse la prueba
		assertEquals(ID, customer.getId());
	}
}
