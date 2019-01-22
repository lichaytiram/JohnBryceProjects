package dbdao;

import java.util.Date;

import javaBeans.Category;
import javaBeans.Company;
import javaBeans.Coupon;
import javaBeans.Customer;

public class Program {
	private final static String Driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {

		ConnectionPool.getInstance();
		checkAllWork();

	}

	private static void checkAllWork() {
		try {
			Class.forName(Driver);

			CompaniesDBDAO companies = new CompaniesDBDAO();
			CustomerDBDAO customers = new CustomerDBDAO();
			CategoriesDBDAO categories = new CategoriesDBDAO();
			CouponsDBDAO coupons = new CouponsDBDAO();
			CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
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

			// Companies
//			Company company1 = new Company(1, "31Sd", "sd@g.m", "compyomer");
//			Company company2 = new Company(2, "31Sd", "s1d@g.m", "ggf");
//			Company company3 = new Company(8, "31Sd", "s2d@g.m", "ggt");
//			companies.insert(company1);
//			companies.insert(company2);
//			companies.insert(company3);
//			companies.delete(2);
//			companies.update(company3, 1);
//			System.out.println(companies.getOneCompany(1));
//			System.out.println(companies.isCompanyExists("s2d@g.m", "31Sd"));
//			companies.showAll();

			// Customers
//			Customer customer1 = new Customer(5, "sdS23x0", "dsd@gmail.com", "dod", "pp");
//			Customer customer2 = new Customer(2, "sdS23x1", "dsxd@gmail.com", "dod", "p1p");
//			Customer customer3 = new Customer(4, "sdS23x2", "dsd@gmail.com", "dod", "p2p");
//			customers.insert(customer1);
//			customers.insert(customer2);
//			customers.insert(customer3);
//			customers.update(customer1, 3);
//			customers.delete(2);
//			System.out.println(customers.getOneCustomer(2));
//			System.out.println(customers.isCustomerExists("dsxd@gmail.com", "sdS23x1"));
//			customers.showAll();

			// Categories
//			categories.insert("od");
//			categories.insert("od");
//			categories.insert("od");
//			categories.insert("od");
//			categories.update("pds", 2);
//			categories.delete(3);
//			categories.showAll();

			// Coupons 
			Coupon coupons1 = new Coupon(1, Category.Food, "bestCoupon", "for all", new Date(), new Date(), 0, 2.3,
					"ismg.txt");
			Coupon coupons2 = new Coupon(1, Category.Electricity, "bestCoupon", "for all", new Date(), new Date(), 0,
					2.3, "ismg.txt");
			Coupon coupons3 = new Coupon(1, Category.Weaponsý, "bestCoupon", "for all", new Date(), new Date(), 0, 2.3,
					"ismg.txt");
			coupons.insert(coupons1);
			coupons.insert(coupons2);
			coupons.insert(coupons3);
//			coupons.update(coupons2, 1);
//			coupons.delete(2);
			System.out.println(coupons.getOneCoupon(1));
//			coupons.addCouponhase(8, 45);
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
