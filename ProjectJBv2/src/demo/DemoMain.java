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
import test.RefreshDataBase;

public class DemoMain {

	private static CustomerController customer = null;
	private static PurchaseController purchaseController = null;
	private static CompanyController CompanyController = null;
	private static CouponController couponController = null;

	public static void main(String[] args) {

		RefreshDataBase refreshDataBase = new RefreshDataBase();
		refreshDataBase.refreshDB();
		Date endDate = new Date();
		endDate.setYear(2020);

		try {
			customer = new CustomerController();
			purchaseController = new PurchaseController();
			CompanyController = new CompanyController();
			couponController = new CouponController();
			Customer c1 = new Customer("omer", "marh", "ww@gmai.com", "1sSd");
			c1.setUser(new User("x", "x", ClientType.Customer, null));
			customer.createCustomer(c1);
			Customer c2 = new Customer("omerr", "marhs", "wsw@gmai.com", "1sSd");
			c2.setUser(new User("x1", "x1", ClientType.Customer, null));
			customer.createCustomer(c2);

			customer.deleteCustomer(1);
			System.out.println(customer.getAllCustomer());
			purchaseController.purchaseCoupon(2, 1, 2);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

		try {
			CompanyController.createCompany(new Company("usacompany", "s.com", "123"));
			Coupon coupon1 = new Coupon(1, Category.Electricity, "title", "description", new Date(), endDate, 10, 50.8,
					"ss");
			System.out.println("-----------------------------------------");
			couponController.createCoupon(coupon1);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
