package es.upm.grise.profundizacion.AccountManager.dataAccess;

import java.util.Vector;

public class CustomerDouble extends Customer {
	
	int CUSTOMER_ID = 1;
	double BALANCE = 550.5;
	
	@Override
	public Double getBalance() {
		return BALANCE;
	}

	@Override
	public int getId() {
		return CUSTOMER_ID;
	}

}
