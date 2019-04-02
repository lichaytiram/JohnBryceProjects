package demo;

import java.util.Date;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import beans.User;
import enums.Category;
import enums.ClientType;
import exception.ApplicationException;
import logic.CompanyController;
import logic.CouponController;
import logic.CustomerController;
import logic.PurchaseController;
import logic.UserController;
import test.RefreshDataBase;

public class DemoMain {

	private static CustomerController customerController = null;
	private static PurchaseController purchaseController = null;
	private static CompanyController companyController = null;
	private static CouponController couponController = null;
	private static UserController userController = null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		RefreshDataBase refreshDataBase = new RefreshDataBase();
		refreshDataBase.refreshDB();
		Date endDate = new Date();
		endDate.setYear(120);

		try {
			customerController = new CustomerController();
			purchaseController = new PurchaseController();
			companyController = new CompanyController();
			couponController = new CouponController();
			userController = new UserController();

			Customer customer1 = new Customer("moshe", "david", "0504755320", "gw@gmail.com");
			User user1 = new User("username1", "123Xx", ClientType.Customer, null);
			customer1.setUser(user1);
			Customer customer2 = new Customer("tom", "tor", "0527466077", "tor.tor@gmail.com");
			User user2 = new User("username2", "123Xx", ClientType.Customer, null);
			customer2.setUser(user2);
			Company company1 = new Company("s.o.s", "0544444565", "company@company.com");
			Company company2 = new Company("companyX", "0504233689", "XX@company.com");
			Coupon coupon1 = new Coupon(2, Category.Food, "title1", "description1", new Date(), endDate, 10, 50.7,
					"image.com");
			Coupon coupon2 = new Coupon(2, Category.Museum, "title2", "description2", new Date(), endDate, 10, 100.3,
					"image.com");
			Coupon coupon3 = new Coupon(1, Category.Iceland, "title3", "description3", new Date(), endDate, 10, 20.7,
					"image.com");
			User user3 = new User("user3", "passwordP1", ClientType.Company, 1L);
			User user4 = new User("user4", "passwordP1", ClientType.Company, 2L);
			User user5 = new User("user5", "passwordP1", ClientType.Company, 2L);
			User user6 = new User("user6", "passwordP1", ClientType.Administrator, null);

			// create
			companyController.createCompany(company1);
			companyController.createCompany(company2);
			userController.createUser(user3);
			userController.createUser(user4);
			userController.createUser(user5);
			userController.createUser(user6);
			customerController.createCustomer(customer1);
			customerController.createCustomer(customer2);
			couponController.createCoupon(coupon1);
			couponController.createCoupon(coupon2);
			couponController.createCoupon(coupon3);
			purchaseController.purchaseCoupon(5, 1, 4);
			purchaseController.purchaseCoupon(5, 1, 4);
			purchaseController.purchaseCoupon(5, 1, 1);
			purchaseController.purchaseCoupon(5, 3, 2);
			purchaseController.purchaseCoupon(6, 2, 2);
			purchaseController.purchaseCoupon(6, 3, 1);

			// update
			companyController.updateCompany(new Company(1, "newName", "0770466845", "email@com.com"));
			userController.updateUser("user33", "passwordX5", 5);
			customer1.setFirstName("newFirst"); // update customer1
			System.out.println(customer1.getUser());
			customerController.updateCustomer(customer1);
			couponController.updateCoupon( // update coupon 2
					new Coupon(2, 2, Category.Iceland, "title", "description", new Date(), endDate, 15, 30, "ss.co"));

			// read all
			System.out.println(companyController.getAllCompany());
			System.out.println(userController.getAllUsers());
			System.out.println(customerController.getAllCustomer());
			System.out.println(couponController.getAllCoupon());
			System.out.println(purchaseController.getAllPurchase());

			// read one
			System.out.println(companyController.getCompany(1));
			System.out.println(customerController.getCustomer(5));
			System.out.println(couponController.getCoupon(1));
			System.out.println("The amount is: " + purchaseController.getPurchaseAmount(5));
			System.out.println("----------------------------------------");
			System.out.println("The amount is: " + purchaseController.getCustomerPurchase(6));
			System.out.println("----------------------------------------");

			// read specific
			System.out.println(couponController.getCustomerCouponByCustomerId(5));
			System.out.println(couponController.getCustomerCouponsByCategory(5, Category.Comics));
			System.out.println(couponController.getCustomerCouponsByCategory(5, Category.Food));
			System.out.println(couponController.getCustomerCouponsByMaxPrice(5, 50.6));

			// delete
			purchaseController.deletePurchase(5, 3);
			purchaseController.deletePurchase(2);
			userController.deleteUser(1);
			customerController.deleteCustomer(6);

			purchaseController.purchaseCoupon(5, 3, 1);

			companyController.deleteCompany(2);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
