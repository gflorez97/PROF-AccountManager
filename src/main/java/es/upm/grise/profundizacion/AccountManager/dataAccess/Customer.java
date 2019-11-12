package es.upm.grise.profundizacion.AccountManager.dataAccess;

import java.util.Vector;

public class Customer {
	
	// Customer id
	private int id;

	// Represents the customer balance. It may be either positive or negative
	private Double balance;
	
	// Customer's orders
	private Vector <Order> orders;
	
	// When the customer is created, all orders are stored in the orders vector (object aggregation)
	Customer(int id, Double balance, Vector<Order> orders) {
		this.id = id;
		this.balance = balance;
		this.orders = orders;
	}

	public void updateBalance() {
		Double total = 0.0;

		for (Order order: orders) {
			if (!order.wasProcessed()) {
				if (order.isValid()) {
					if(checkOrderAttributes(order)) {
						total += order.getAmount();
						order.setProcessed();	
					} else {
						order.setInvalid();
					}
				}
			}
		}
		balance -= total;
	}
		
	// Checks that the order's amount has 2 decimal digits only
	private boolean checkOrderAttributes(Order order) {
		if((order.getAmount()*100) > Math.floor(order.getAmount()*100))
			return false;
		else
			return true;
	}

	// Setters & Getters
	
	public Double getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}
	
}
