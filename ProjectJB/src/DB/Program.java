package DB;

import java.util.Date;

public class Program {
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
			companies.drop();
			customers.drop();
			categories.drop();
			coupons.drop();
			customersVsCoupons.drop();
			companies.create();
			customers.create();
			categories.create();
			coupons.create();
			customersVsCoupons.create();

//			// Companies
//			companies.insert("omer", "Sss", "s232s");
//			companies.insert("omsr", "Sss", "s232s");
//			companies.insert("omsr", "Sss", "s232s");
//			companies.delete(2);
//			companies.update("os", "s3", "234", 42);
//			companies.showAll();

			// Customers
//			customers.insert("sss1", "omshe", "com", "sdsd123");
//			customers.insert("sss2", "omshe", "com", "sdsd123");
//			customers.insert("sss3", "omshe", "com", "sdsd123");
//			customers.update("lol", "omshe", "com", "sdsd123" ,1);
//			customers.delete(2);
//			customers.showAll();

			// Categories
//			categories.insert("od");
//			categories.insert("od");
//			categories.insert("od");
//			categories.insert("od");
//			categories.update("pds", 2);
//			categories.delete(3);
//			categories.showAll();

			// Coupons -> need to fix if

//			coupons.insert(2, 2, "title", "free text", new Date(), new Date(), 3, 30F, "dont have");
//		    coupons.insert(2, 2, "title", "free text", new Date(), new Date(), 3, 30, "dont have");
//		    coupons.insert(2, 2, "title", "free text", new Date(), new Date(), 3, 30, "dont have");
//		    coupons.update(2, 2, "title2 cahnge", "free text", new Date(), new Date(), 800, 800, "dont have", 1);
//		    coupons.delete(2);
//			coupons.showAll();

			// CustomersVsCoupons

//			customersVsCoupons.insert(1, 3);
//			customersVsCoupons.insert(1, 4);
//			customersVsCoupons.insert(1, 5);
//			customersVsCoupons.update(9, 10, 1, 3);
//			customersVsCoupons.delete(9, 3);
//			customersVsCoupons.showAll();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
