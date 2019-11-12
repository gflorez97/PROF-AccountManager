package es.upm.grise.profundizacion.AccountManager.dataAccess;

public class Util {
	// Checks that the order's amount has 2 decimal digits only
		public static boolean checkOrderAttributes(Order order) {
			if((order.getAmount()*100) > Math.floor(order.getAmount()*100))
				return false;
			else
				return true;
		}
}
