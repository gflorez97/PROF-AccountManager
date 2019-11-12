package es.upm.grise.profundizacion.AccountManager.dataAccess;

public class Order {

	// Represents the order's total amount
	// Other details (e.g.: items) are not included for simplicity
	private Double amount;
	private boolean valid;
	private boolean processed;
	
	// Constructor
	public Order(Double amount, boolean valid, boolean processed) {
		this.amount = amount;
		this.valid = valid;
		this.processed = processed;
	}
	
	// Setters & Getters

	public Double getAmount() {
		return amount;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setInvalid() {
		valid = false;
	}
	
	public boolean wasProcessed() {
		return processed;
	}
	
	public void setProcessed() {
		processed = true;
	}
	
}
