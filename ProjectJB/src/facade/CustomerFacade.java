package facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbdao.ConnectionPool;
import dbdao.CouponsDBDAO;
import dbdao.CustomerDBDAO;
import dbdao.CustomersVsCouponsDBDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Coupon;
import javaBeans.Customer;

public class CustomerFacade extends ClientFacade {

	private int customerID;
	private ConnectionPool connection = ConnectionPool.getInstance();

	public CustomerFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			this.customerID = customer.getOneCustomerByEmailAndPassword(email, password).getId();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	boolean login(String email, String password) {
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			if (customer.isCustomerExists(email, password))
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public void purchaseCoupon(Coupon coupon) throws Exception {

		int couponID = coupon.getId();
		CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
		customersVsCoupons.checkIfCustomerBought(customerID, couponID);
		CouponsDBDAO newcoupon = new CouponsDBDAO();
		newcoupon.addCouponPurchase(customerID, couponID);
	}

	public ArrayList<Coupon> getCustomerCoupons() throws Exception {
		CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
		return customersVsCoupons.getCustomerCouponByCustomerID(customerID);
	}

	public ArrayList<Coupon> getCustomerCoupons(Category category) throws Exception {

		return null;
	}

	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws Exception {

		return null;
	}

	public Customer getCustomerDetails() {
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			return customer.getOneCustomer(customerID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}