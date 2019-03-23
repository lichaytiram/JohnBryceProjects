package program;

import java.util.Date;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import daily.job.Job;
import dao.CompaniesDao;
import dao.CouponsDao;
import dao.CustomerDao;
import dao.PurchasesDao;
import enums.Category;
import enums.ClientType;
import exception.ApplicationException;
import logic.AdminFacade;
import logic.CompanyController;
import logic.CustomerController;
import logic.LoginManager;
import test.RefreshDataBase;

/**
 * This class implements all function in this program
 * 
 * @author Lichay
 *
 */
public class Test {
	private final static String Driver = "com.mysql.cj.jdbc.Driver";
	public static CompaniesDao companies = new CompaniesDao();
	public static CustomerDao customers = new CustomerDao();
	public static CouponsDao coupons = new CouponsDao();
	public static PurchasesDao customersVsCoupons = new PurchasesDao();

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

		RefreshDataBase refreshDataBase = new RefreshDataBase();
		refreshDataBase.refreshDB();

		daily.job.Job j = new Job();
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
			coupons3 = new Coupon(3, Category.Weapon, "kids", "weapon kids!", startDate, endDate, 2, 100.35,
					"ismg.txt");
			coupons4 = new Coupon(2, 3, Category.Paintballý, "PB", "anyone can buy this", startDate, endDate, 8, 20.5,
					"http.txt"); // with id

			coupons5 = new Coupon(3, Category.Electricity, "ee", "close to free", startDate, endDate, 12, 60,
					"http.txt"); // with id
			coupons6 = new Coupon(2, Category.Weapon, "kids", "weapon kids!", startDate, endDate, 2, 100.35,
					"ismg.txt");

		} catch (ApplicationException e) {
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
		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			admin.addCustomer(customer3);
			admin.addCustomer(customer4);
			System.out.println(admin.getAllCustomer());
			admin.updateCustomer(customer3);
		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		CompanyController company = null;

		try {
			admin.deleteCustomer(5);
			System.out.println(admin.getOneCompany(2));
			System.out.println(admin.getOneCustomer(3));
			company = (CompanyController) manager.login("emails", "passwordnope", ClientType.Company);
		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			company = (CompanyController) manager.login("gg@gmail.com", "ppx1X", ClientType.Company);
			company.addCoupon(coupons1);
			company.addCoupon(coupons2);
			company.addCoupon(coupons3);

			System.out.println(company.getCompanyDetails());
			System.out.println(company.getCompanyCoupons());
			company.updateCoupon(coupons4);
			System.out.println(company.getCompanyCoupons());
			System.out.println(company.getCompanyCoupons(30));
			System.out.println(company.getCompanyCoupons(Category.Weapon));
			company.addCoupon(coupons3);
		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			company.deleteCoupon(2);
			System.out.println(company.getCompanyCoupons());
			admin.updateCompany(company3);

		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		CustomerController customer = null;
		try {
			customer = (CustomerController) manager.login("emails", "passwordnope", ClientType.Customer);

		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			customer = (CustomerController) manager.login("omer@gmail.com", "ddooR2", ClientType.Customer);
			System.out.println(customer.getCustomerCoupons());
			customer.purchaseCoupon(coupons.getCoupon(3));
			System.out.println(customer.getCustomerCoupons());
			System.out.println(customer.getCustomerDetails());
			company.deleteCoupon(1);

		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			customer.purchaseCoupon(coupons.getCoupon(3));
		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(customer.getCustomerCoupons());
			company.addCoupon(coupons5);
			customer.purchaseCoupon(coupons.getCoupon(4));
			System.out.println(customer.getCustomerCoupons());
			System.out.println(customer.getCustomerCoupons(Category.Electricity));
			System.out.println(customer.getCustomerCoupons(70));
			customer.purchaseCoupon(coupons.getCoupon(4));
		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			company = (CompanyController) manager.login("sss@gmail.com", "12aA3x23x4xx", ClientType.Company);
			company.addCoupon(coupons6);
			customer.purchaseCoupon(coupons.getCoupon(5));
			admin = (AdminFacade) manager.login("admin@admin.com", "adminn", ClientType.Administrator);

		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			admin = (AdminFacade) manager.login("admin@admin.com", "admin", ClientType.Administrator);
			System.out.println(admin.getAllCompanies());
			admin.deleteCompany(3);
			System.out.println(admin.getAllCompanies());
			customer = (CustomerController) manager.login("omer@gmail.com", "ddooR2", ClientType.Customer);
			System.out.println(customer.getCustomerDetails());
			customer = (CustomerController) manager.login("amir@gmail.com", "dopX3", ClientType.Customer);
			System.out.println(customer.getCustomerDetails());

		} catch (ApplicationException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
