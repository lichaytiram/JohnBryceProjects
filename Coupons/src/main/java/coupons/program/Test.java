package coupons.program;

import java.util.Date;

import coupons.beans.Company;
import coupons.beans.Coupon;
import coupons.beans.Customer;
import coupons.beans.User;
import coupons.daily.job.MyTimer;
import coupons.enums.Category;
import coupons.enums.ClientType;
import coupons.exception.ApplicationException;
import coupons.logic.CompanyController;
import coupons.logic.CouponController;
import coupons.logic.CustomerController;
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

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}
