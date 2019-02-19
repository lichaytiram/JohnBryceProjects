package program;

import java.util.ArrayList;
import java.util.Date;

import dbdao.CategoriesDBDAO;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import dbdao.CustomerDBDAO;
import dbdao.CustomersVsCouponsDBDAO;
import exception.ExceptionName;
import facade.AdminFacade;
import facade.ClientType;
import facade.CompanyFacade;
import facade.CustomerFacade;
import facade.LoginManager;
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
		refreshDB();
		Date startDate = new Date();

		LoginManager manager = LoginManager.getInstance();
		Company company1 = null;
		Company company2 = null;
		Company company3 = null;
		Customer customer1 = null;
		Customer customer2 = null;
		Customer customer3 = null;
		Customer customer4 = null;
		Coupon coupons1 = null;
		Coupon coupons2 = null;
		Coupon coupons3 = null;
		Coupon coupons4 = null;
		try {
//			new Company(password, email, name);
			company1 = new Company("12aA34", "ss@gmail.com", "USAcom");
			company2 = new Company("12aA3x23x4xx", "sss@gmail.com", "USxAcom");
			company3 = new Company("ppx1X", "gg@gmail.com", "armys");

//			new Customer(password, email, firstName, lastName);
			customer1 = new Customer("ddooR2", "omer@gmail.com", "omer", "thzion");
			customer2 = new Customer("dopX3", "amir@gmail.com", "amir", "davi");
			customer3 = new Customer("eeoo123P", "efi@gmail.com", "efi", "ahme");
			customer4 = new Customer("FH44d", "shira@walla.com", "shira", "azur");

//			new Coupon(companyId, category, title, description, startDate, endDate, amount, price, image);
			coupons1 = new Coupon(1, Category.Food, "bestCoupon", "for all", startDate, new Date(), 0, 50, "ismg.txt");
			coupons2 = new Coupon(1, Category.Paintballý, "PB", "anyone can buy this", startDate, new Date(), 0, 30.5,
					"http.txt");
			coupons3 = new Coupon(3, Category.Weaponsý, "kids", "weapon kids!", startDate, new Date(), 0, 100.35,
					"ismg.txt");
			coupons4 = new Coupon(2, 3, Category.Paintballý, "PB", "anyone can buy this", startDate, new Date(), 0,
					20.5, "http.txt"); // with id

		} catch (ExceptionName e) {
			System.out.println(e);
		}
		AdminFacade admin = null;
		try {
			admin = (AdminFacade) manager.login("admin@admin.com", "admin", ClientType.Administrator);

			System.out.println(admin.getAllCompanies());
			admin.addCompany(company1);
			admin.addCompany(company2);
			admin.addCompany(company3);
			System.out.println(admin.getAllCompanies());
			System.out.println(admin.getAllCustomer());
			admin.addCustomer(customer1);
			admin.addCustomer(customer2);
			admin.addCustomer(customer2);
			System.out.println(admin.getAllCustomer());
		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			admin.addCustomer(customer3);
			admin.addCustomer(customer4);
			System.out.println(admin.getAllCustomer());
			admin.updateCustomer(customer3);
		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		CompanyFacade company = null;

		try {
			admin.deleteCustomer(5);
			System.out.println(admin.getOneCompany(2));
			System.out.println(admin.getOneCustomer(3));
			company = (CompanyFacade) manager.login("emails", "passwordnope", ClientType.Company);
		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			company = (CompanyFacade) manager.login("gg@gmail.com", "ppx1X", ClientType.Company);
			company.addCoupon(coupons1);
			company.addCoupon(coupons2);
			company.addCoupon(coupons3);
			System.out.println(company.getCompanyDetails());
			System.out.println(company.getCompanyCoupons());
			company.updateCoupon(coupons4);
			System.out.println(company.getCompanyCoupons());
			System.out.println(company.getCompanyCoupons(30));
			System.out.println(company.getCompanyCoupons(Category.Weaponsý));
			company.addCoupon(coupons3);
		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			company.deleteCoupon(2);
			System.out.println(company.getCompanyCoupons());
			admin.updateCompany(company3);

		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

//		manager.login("emails", "passwordnope", ClientType.Company);
		CustomerFacade customer = null;
		try {
			customer = (CustomerFacade) manager.login("emails", "passwordnope", ClientType.Customer);

		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			customer = (CustomerFacade) manager.login("omer@gmail.com", "ddooR2", ClientType.Customer);
			System.out.println(customer.getCustomerCoupons());
			customer.purchaseCoupon(coupons1);

		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {

//			// Companies
//			Company company1 = new Company("31Sd", "sd@g.m", "compyomer0");
//			Company company2 = new Company("31Sd", "s1d@g.m", "ggf1");
//			Company company3 = new Company("31Sd", "s2d@g.m", "ggt2");
//			companies.insert(company1);
//			companies.insert(company2);
//			companies.insert(company3);
////			companies.insert(company3);
////			companies.update(company3);
//			companies.delete(2);
////			System.out.println(companies.getOneCompany(1));
////			System.out.println(companies.isCompanyExists("s2d@g.m", "31Sd"));
//			ArrayList<Company> companyList = companies.getAllCompany();
//			System.out.println(companyList);
//
//			// Customers
//			Customer customer1 = new Customer(5, "sdS23x0", "dsd@gmail.com", "dod", "pp");
//			Customer customer2 = new Customer(2, "sdS23x1", "dsxd@gmail.com", "dod", "p1p");
//			Customer customer3 = new Customer(4, "sdS23x2", "dsxcccd@gmail.com", "dod", "p2p");
//			customers.insert(customer1);
//			customers.insert(customer2);
//			customers.insert(customer3);
////			customers.insert(customer3);
////			customers.update(customer1);
////			customers.delete(1);
////			System.out.println(customers.getOneCustomer(2));
////			System.out.println(customers.isCustomerExists("dsxcccd@gmail.com", "sdS23x2"));
////			System.out.println(customers.getOneCustomerByEmailAndPassword("dsd@gmail.com", "sdS23x2"));
//			ArrayList<Customer> customersList = customers.getAllCustomer();
//			System.out.println(customersList);
//
//			// Categories
////			categories.insert("od");
////			categories.insert("od");
////			categories.insert("od");
////			categories.insert("od");
////			categories.update("pds", 2);
////			categories.delete(3);
////			categories.showAll();
//
//			// Coupons
//			Date date = new Date();
//			Coupon coupons2 = new Coupon(1, Category.Paintballý, "bestCouponx", "for all", date, new Date(), 0, 2.3,
//					"ismg.txt");
//			Coupon coupons1 = new Coupon(1, Category.Food, "bestCoupon", "for all", date, new Date(), 0, 2.3,
//					"ismg.txt");
//			Coupon coupons3 = new Coupon(3, Category.Weaponsý, "bestCoupon", "for all", date, new Date(), 0, 2.3,
//					"ismg.txt");
//			coupons.insert(coupons1);
//			coupons.insert(coupons2);
//			coupons.insert(coupons3);
////			coupons.insert(coupons3);
////			coupons.update(coupons3);
////			coupons.delete(2);
////			System.out.println(coupons.getOneCoupon(1));
////			coupons.addCouponPurchase(8, 45);
////			ArrayList<Coupon> couponList = coupons.getAllCoupon();
////			System.out.println(couponList);
//
//			// CustomersVsCoupons
//
//			customersVsCoupons.insert(1, 1);
//			customersVsCoupons.insert(2, 2);
//			customersVsCoupons.insert(2, 3);
////			customersVsCoupons.checkIfCustomerBought(2, 2);
////			System.out.println(customersVsCoupons.getCustomerCouponByCustomerID(2));
////			customersVsCoupons.insert(1, 5);
////			customersVsCoupons.update(9, 10, 1, 3);
////			customersVsCoupons.delete(9, 3);
//			customersVsCoupons.showAll();
//
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void refreshDB() {

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
			System.out.println("refresh DataBase end! (delete all DB)");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
