package coupons.program;

import java.util.Date;

import coupons.beans.Company;
import coupons.beans.Coupon;
import coupons.beans.Customer;
import coupons.beans.Purchase;
import coupons.beans.User;
import coupons.daily.job.MyTimer;
import coupons.enums.Category;
import coupons.enums.ClientType;
import coupons.exception.ApplicationException;
import coupons.logic.CompanyController;
import coupons.logic.CouponController;
import coupons.logic.CustomerController;
import coupons.logic.PurchaseController;
import coupons.logic.UserController;
import coupons.test.RefreshDataBase;

/**
 * This class implements all function in this program
 * 
 * @author Lichay
 *
 */
public class Test {

	/**
	 * This function implement all method for this project
	 */
	public static void testAll() {

		// controller
		CustomerController customerController = null;
		PurchaseController purchaseController = null;
		CompanyController companyController = null;
		CouponController couponController = null;
		UserController userController = null;

		RefreshDataBase refreshDataBase = null;

		// set end date
		Date endDate = new Date();
		endDate.setTime(1600000000000L);

		try {

			MyTimer.createTimer();

			// instantiate controllers
			customerController = new CustomerController();
			purchaseController = new PurchaseController();
			companyController = new CompanyController();
			couponController = new CouponController();
			userController = new UserController();

			// refresh data base
			refreshDataBase = new RefreshDataBase();
			refreshDataBase.refreshDB();

			// bean
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
			Coupon coupon2 = new Coupon(2, Category.Paintball, "title2", "description2", new Date(), endDate, 10, 100.3,
					"image.com");
			Coupon coupon3 = new Coupon(1, Category.Vacation, "title3", "description3", new Date(), endDate, 10, 20.7,
					"image.com");
			User user3 = new User("user3", "passwordP1", ClientType.Company, 1L);
			User user4 = new User("user4", "passwordP1", ClientType.Company, 2L);
			User user5 = new User("user5", "passwordP1", ClientType.Company, 2L);
			User user6 = new User("user6", "passwordP1", ClientType.Administrator, null);

			Purchase purchase1 = new Purchase(5, 1, 4);
			Purchase purchase2 = new Purchase(5, 1, 4);
			Purchase purchase3 = new Purchase(5, 1, 1);
			Purchase purchase4 = new Purchase(5, 3, 2);
			Purchase purchase5 = new Purchase(6, 2, 2);
			Purchase purchase6 = new Purchase(6, 3, 1);
//			Purchase purchase7 = new Purchase(5, 3, 1);

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
			purchaseController.purchaseCoupon(purchase1);
			purchaseController.purchaseCoupon(purchase2);
			purchaseController.purchaseCoupon(purchase3);
			purchaseController.purchaseCoupon(purchase4);
			purchaseController.purchaseCoupon(purchase5);
			purchaseController.purchaseCoupon(purchase6);

			// update
//			companyController.updateCompany(new Company(1, "newName", "0770466845", "email@com.com"));
//			userController.updateUser("user33", "passwordX5", 6);
//			customer1.setFirstName("newFirst"); // update customer1
//			System.out.println(customer1.getUser());
//			customer1.setUser(new User(5, "username18", "ddS3", ClientType.Customer, null)); // fix it for update
//			customerController.updateCustomer(customer1);
//			couponController.updateCoupon( // update coupon 2
//					new Coupon(2, 2, Category.Vacation, "title8", "description", new Date(), endDate, 15, 30, "ss.co"));

			// read all
//			System.out.println(companyController.getAllCompany());
//			System.out.println(userController.getAllUsers());
//			System.out.println(customerController.getAllCustomer());
//			System.out.println(couponController.getAllCoupon());
//			System.out.println(purchaseController.getAllPurchase());

			// read one
//			System.out.println(companyController.getCompany(1));
//			System.out.println(customerController.getCustomer(5));
//			System.out.println(couponController.getCoupon(1));
//			System.out.println("The amount is: " + purchaseController.getPurchaseAmount(5));
//			System.out.println("The amount is: " + purchaseController.getCustomerPurchase(6));

			// read specific
//			System.out.println(couponController.getCompanyCouponsByCompanyId(2));
//			System.out.println(couponController.getCompanyCouponsByCategory(2, Category.Vacation));
//			System.out.println(couponController.getCompanyCouponsByMaxPrice(2, 33));
//			System.out.println(couponController.getCustomerCouponByCustomerId(5));
//			System.out.println(couponController.getCustomerCouponsByCategory(5, Category.Comics));
//			System.out.println(couponController.getCustomerCouponsByCategory(5, Category.Food));
//			System.out.println(couponController.getCustomerCouponsByMaxPrice(5, 50.6));

			// delete
//			purchaseController.deletePurchase(5, 3);
//			purchaseController.deletePurchase(2);
//			userController.deleteUser(1);
//			customerController.deleteCustomer(6);
//
//			purchaseController.purchaseCoupon(purchase7);
//
//			companyController.deleteCompany(2);
//
//			couponController.deleteCoupon(3, 1);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}