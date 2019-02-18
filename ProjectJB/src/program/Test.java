package program;

import java.util.ArrayList;
import java.util.Date;

import dbdao.CategoriesDBDAO;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import dbdao.CustomerDBDAO;
import dbdao.CustomersVsCouponsDBDAO;
import javaBeans.Category;
import javaBeans.Company;
import javaBeans.Coupon;
import javaBeans.Customer;

public class Test {
	private final static String Driver = "com.mysql.cj.jdbc.Driver";

	public static void testAll() {
		try {
			Class.forName(Driver);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		try {
			CompaniesDBDAO companies = new CompaniesDBDAO();
			CustomerDBDAO customers = new CustomerDBDAO();
			CategoriesDBDAO categories = new CategoriesDBDAO();
			CouponsDBDAO coupons = new CouponsDBDAO();
			CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
			customersVsCoupons.drop();
			coupons.drop();
			companies.drop();
			customers.drop();
			categories.drop();
			companies.create();
			customers.create();
			categories.create();
			coupons.create();
			customersVsCoupons.create();

			// Companies
			Company company1 = new Company("31Sd", "sd@g.m", "compyomer0");
			Company company2 = new Company("31Sd", "s1d@g.m", "ggf1");
			Company company3 = new Company("31Sd", "s2d@g.m", "ggt2");
			companies.insert(company1);
			companies.insert(company2);
			companies.insert(company3);
//			companies.insert(company3);
//			companies.update(company3);
			companies.delete(2);
//			System.out.println(companies.getOneCompany(1));
//			System.out.println(companies.isCompanyExists("s2d@g.m", "31Sd"));
			ArrayList<Company> companyList = companies.getAllCompany();
			System.out.println(companyList);

			// Customers
			Customer customer1 = new Customer(5, "sdS23x0", "dsd@gmail.com", "dod", "pp");
			Customer customer2 = new Customer(2, "sdS23x1", "dsxd@gmail.com", "dod", "p1p");
			Customer customer3 = new Customer(4, "sdS23x2", "dsxcccd@gmail.com", "dod", "p2p");
			customers.insert(customer1);
			customers.insert(customer2);
			customers.insert(customer3);
//			customers.insert(customer3);
//			customers.update(customer1);
//			customers.delete(1);
//			System.out.println(customers.getOneCustomer(2));
//			System.out.println(customers.isCustomerExists("dsxcccd@gmail.com", "sdS23x2"));
//			System.out.println(customers.getOneCustomerByEmailAndPassword("dsd@gmail.com", "sdS23x2"));
			ArrayList<Customer> customersList = customers.getAllCustomer();
			System.out.println(customersList);

			// Categories
//			categories.insert("od");
//			categories.insert("od");
//			categories.insert("od");
//			categories.insert("od");
//			categories.update("pds", 2);
//			categories.delete(3);
//			categories.showAll();

			// Coupons
			Date date = new Date();
			Coupon coupons2 = new Coupon(1, Category.Paintballý, "bestCouponx", "for all", date, new Date(), 0, 2.3,
					"ismg.txt");
			Coupon coupons1 = new Coupon(1, Category.Food, "bestCoupon", "for all", date, new Date(), 0, 2.3,
					"ismg.txt");
			Coupon coupons3 = new Coupon(3, Category.Weaponsý, "bestCoupon", "for all", date, new Date(), 0, 2.3,
					"ismg.txt");
			coupons.insert(coupons1);
			coupons.insert(coupons2);
			coupons.insert(coupons3);
//			coupons.insert(coupons3);
//			coupons.update(coupons3);
//			coupons.delete(2);
//			System.out.println(coupons.getOneCoupon(1));
//			coupons.addCouponPurchase(8, 45);
//			ArrayList<Coupon> couponList = coupons.getAllCoupon();
//			System.out.println(couponList);

			// CustomersVsCoupons

			customersVsCoupons.insert(1, 1);
			customersVsCoupons.insert(2, 2);
			customersVsCoupons.insert(2, 3);
//			customersVsCoupons.checkIfCustomerBought(2, 2);
//			System.out.println(customersVsCoupons.getCustomerCouponByCustomerID(2));
//			customersVsCoupons.insert(1, 5);
//			customersVsCoupons.update(9, 10, 1, 3);
//			customersVsCoupons.delete(9, 3);
			customersVsCoupons.showAll();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
