package es.upm.grise.profundizacion.AccountManager.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

final public class DataAccessSingleton {
	private static Vector <Customer> customers;
	private static DataAccessSingleton instance;

	// Singleton access method
	public static DataAccessSingleton getInstance() {
		if (instance != null)
			return instance;
		else {
			instance = new DataAccessSingleton();
			return instance;
		}	
	}

	private DataAccessSingleton() {
		try {
			customers = DataAccessSingleton.databaseLoader();
		} catch (Exception e) {
			// Recovery code. Do not care about it.					
			e.printStackTrace();
		}
	}

	// Returns a customer by id
	public Customer getCustomer(int id) {
		for(Customer customer:customers) {
			if(customer.getId() == id)
				return customer;
		}
		return null;
	}

	// We will not use a real database. This method simulates that data are loaded
	// into the container class DataAccess. As there is no database, there are no updates
	final private static Vector <Customer> databaseLoader() {
		Vector <Customer> customers = new Vector <Customer>();
		Connection connection = null;

		try {
			// Create DB connection
			String url = "jdbc:sqlite:resources/customers.db";
			connection = DriverManager.getConnection(url);

			// Read from the CUSTOMERS table
			String queryCustomer = "SELECT * FROM CUSTOMERS";
			Statement statementCustomer = connection.createStatement();
			ResultSet resultSetCustomer = statementCustomer.executeQuery(queryCustomer);

			while (resultSetCustomer.next()) {

				Vector <Order> orders = new Vector <Order>();
				Customer customer = null;
				Order order = null;
				
				int id = resultSetCustomer.getInt("ID");
				double balance = resultSetCustomer.getDouble("BALANCE");


				// Read from the ORDERS table
				String queryOrder = "SELECT * FROM ORDERS WHERE CUSTOMER_ID = " + Integer.toString(id);
				Statement statementOrder = connection.createStatement();
				ResultSet resultSetOrder = statementOrder.executeQuery(queryOrder);

				while (resultSetOrder.next()) {

					double amount = resultSetOrder.getDouble("AMOUNT");
					int valid = resultSetOrder.getInt("VALID");
					int processed = resultSetOrder.getInt("PROCESSED");

					order = new Order(amount, 
							valid == 1 ? true : false, 
									processed == 1 ? true : false);
					
					orders.add(order);

				}
				
				customer = new Customer(id, balance, orders);
				customers.add(customer);

			}

			connection.close();

		} catch (Exception e) {
			// Do not care...
			e.printStackTrace();
		}

		return customers;
	}

}
