package es.upm.grise.profundizacion.AccountManager.dataAccess;

import java.util.Vector;

public class DataAccessSingletonDouble extends DataAccessSingleton {

	DataAccessSingletonDouble() {
		Customer CUSTOMER = new CustomerDouble();
		customers = new Vector<Customer>();
		customers.add(CUSTOMER);
	}

}
