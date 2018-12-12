package Project2;

import java.util.Date;

public class Program {
	public static String USERNAME = "root";
	public static String PASSWORD = null;

	public final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final static String Driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {

		ConnectionPool.getInstance();
		checkAllWork();

	}

	private static void checkAllWork() {
		try {
			Class.forName(Driver);

			Companies companies = new Companies();
			Customers customers = new Customers();
			Categories categories = new Categories();
			Coupons coupons = new Coupons();
			CustomersVsCoupons customersVsCoupons = new CustomersVsCoupons();
//			companies.drop();
//			customers.drop();
//			categories.drop();
//			coupons.drop();
//			customersVsCoupons.drop();
			companies.create();
			customers.create();
			categories.create();
			coupons.create();
			customersVsCoupons.create();

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

			// Coupons -> need to fix if

//			Coupons.insert(2, 2, "title", "free text", new Date(), new Date(), 3, 30F, "dont have");
//		    Coupons.insert(2, 2, "title", "free text", new Date(), new Date(), 3, 30, "dont have");
//		    Coupons.insert(2, 2, "title", "free text", new Date(), new Date(), 3, 30, "dont have");
//		    Coupons.update(2, 2, "title2 cahnge", "free text", new Date(), new Date(), 800, 800, "dont have", 1);
//		    Coupons.delete(2);
//			Coupons.showAll();

			// CustomersVsCoupons

//			CustomersVsCoupons.insert(1, 3);
//			CustomersVsCoupons.insert(1, 4);
//			CustomersVsCoupons.insert(1, 5);
//			CustomersVsCoupons.update(9, 10, 1, 3);
//			CustomersVsCoupons.delete(9, 3);
//			CustomersVsCoupons.showAll();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
