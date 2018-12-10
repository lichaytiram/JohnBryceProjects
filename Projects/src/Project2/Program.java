package Project2;

import java.util.Date;

public class Program {
	public static String USERNAME = "root";
	public static String PASSWORD = null;

	public final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final static String Driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		try {
			Class.forName(Driver);

//			Companies.drop();
//			Customers.drop();
//			Categories.drop();
//			Coupons.drop();
//			CustomersVsCoupons.drop();
			Companies.create();
			Customers.create();
			Categories.create();
			Coupons.create();
			CustomersVsCoupons.create();

//			// Companies
//			Companies.insert("omer", "Sss", "s232s");
//			Companies.insert("omsr", "Sss", "s232s");
//			Companies.insert("omsr", "Sss", "s232s");
//			Companies.delete(2);
//			Companies.update("os", "s3", "234", 42);
//			Companies.showAll();

			// Customers
//			Customers.insert("sss1", "omshe", "com", "sdsd123");
//			Customers.insert("sss2", "omshe", "com", "sdsd123");
//			Customers.insert("sss3", "omshe", "com", "sdsd123");
//			Customers.update("lol", "omshe", "com", "sdsd123" ,1);
//			Customers.delete(2);
//			Customers.showAll();

			// Categories
//			Categories.insert("od");
//			Categories.insert("od");
//			Categories.insert("od");
//			Categories.insert("od");
//			Categories.update("pds", 2);
//			Categories.delete(3);
//			Categories.showAll();

			// Coupons

			Coupons.insert("title", "free text", new Date(), new Date(), 3, 30, "dont have");
			Coupons.insert("title", "free text", new Date(), new Date(), 3, 30, "dont have");
			Coupons.insert("title", "free text", new Date(), new Date(), 3, 30, "dont have");
			Coupons.update("title2 cahnge", "free text", new Date(), new Date(), 800, 800, "dont have", 1);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
