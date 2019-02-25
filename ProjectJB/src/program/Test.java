package program;

import java.util.Date;

import dailyJob.Job;
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

/**
 * This class implements all function in this program
 * 
 * @author Lichay
 *
 */
public class Test {
	private final static String Driver = "com.mysql.cj.jdbc.Driver";
	public static CompaniesDBDAO companies = new CompaniesDBDAO();
	public static CustomerDBDAO customers = new CustomerDBDAO();
	public static CategoriesDBDAO categories = new CategoriesDBDAO();
	public static CouponsDBDAO coupons = new CouponsDBDAO();
	public static CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();

	/**
	 * This function implement all method for this class
	 */
	@SuppressWarnings("deprecation")
	public static void testAll() {
		try {
			Class.forName(Driver);
		} catch (Exception e) {
			System.out.println(e);
		}
		refreshDB();
		dailyJob.Job j = new Job();
		Thread dailyJob = new Thread(j, "daily Job");
		dailyJob.start();

		Date startDate = new Date();
		Date endDate = new Date();
		endDate.setYear(startDate.getYear() + 1);

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
		Coupon coupons5 = null;
		Coupon coupons6 = null;

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
			coupons1 = new Coupon(1, Category.Food, "bestCoupon", "for all", startDate, endDate, 0, 50, "ismg.txt");
			coupons2 = new Coupon(1, Category.Paintballý, "PB", "anyone can buy this", startDate, endDate, 0, 30.5,
					"http.txt");
			coupons3 = new Coupon(3, Category.Weaponsý, "kids", "weapon kids!", startDate, endDate, 2, 100.35,
					"ismg.txt");
			coupons4 = new Coupon(2, 3, Category.Paintballý, "PB", "anyone can buy this", startDate, endDate, 8, 20.5,
					"http.txt"); // with id

			coupons5 = new Coupon(3, Category.Electricity, "ee", "close to free", startDate, endDate, 12, 60,
					"http.txt"); // with id
			coupons6 = new Coupon(2, Category.Weaponsý, "kids", "weapon kids!", startDate, endDate, 2, 100.35,
					"ismg.txt");

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
			customer.purchaseCoupon(coupons.getOneCoupon(3));
			System.out.println(customer.getCustomerCoupons());
			System.out.println(customer.getCustomerDetails());
			company.deleteCoupon(1);

		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			customer.purchaseCoupon(coupons.getOneCoupon(3));
		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(customer.getCustomerCoupons());
			company.addCoupon(coupons5);
			customer.purchaseCoupon(coupons.getOneCoupon(4));
			System.out.println(customer.getCustomerCoupons());
			System.out.println(customer.getCustomerCoupons(Category.Electricity));
			System.out.println(customer.getCustomerCoupons(70));
			customer.purchaseCoupon(coupons.getOneCoupon(4));
		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			company = (CompanyFacade) manager.login("sss@gmail.com", "12aA3x23x4xx", ClientType.Company);
			company.addCoupon(coupons6);
			customer.purchaseCoupon(coupons.getOneCoupon(5));
			admin = (AdminFacade) manager.login("admin@admin.com", "adminn", ClientType.Administrator);

		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			admin = (AdminFacade) manager.login("admin@admin.com", "admin", ClientType.Administrator);
			System.out.println(admin.getAllCompanies());
			admin.deleteCompany(3);
			System.out.println(admin.getAllCompanies());
			customer = (CustomerFacade) manager.login("omer@gmail.com", "ddooR2", ClientType.Customer);
			System.out.println(customer.getCustomerDetails());
			customer = (CustomerFacade) manager.login("amir@gmail.com", "dopX3", ClientType.Customer);
			System.out.println(customer.getCustomerDetails());

		} catch (ExceptionName e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * This function refresh all DataBase info
	 */
	public static void refreshDB() {

		try {

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
