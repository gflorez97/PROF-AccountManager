package es.upm.grise.profundizacion.AccountManager.factories;

import es.upm.grise.profundizacion.AccountManager.dataAccess.Customer;
import es.upm.grise.profundizacion.AccountManager.dataAccess.DataAccessSingleton;
import es.upm.grise.profundizacion.AccountManager.exceptions.NonExistingCustomer;

final public class CustomerFactory {

	public static void updateCustomerBalance(int id) throws NonExistingCustomer {
		Customer customer = DataAccessSingleton.getInstance().getCustomer(id);
		if (customer == null)
			throw new NonExistingCustomer();
		else
			customer.updateBalance();
	}
	
}
