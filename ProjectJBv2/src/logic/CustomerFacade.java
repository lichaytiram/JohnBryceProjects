package logic;

import java.util.ArrayList;

import beans.Category;
import beans.Coupon;
import beans.Customer;
//import dbdao.CouponsDao;
import dbdao.CustomerDao;
import dbdao.PurchasesDao;
import exception.ExceptionName;

/**
 * This class manage the all function for client facade
 * 
 * @author Lichay
 */
public class CustomerFacade extends ClientFacade {

	private long customerID;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password and check if login succeed
	 * @throws ExceptionName Can throw an exception by name
	 */
	public CustomerFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CustomerDao customer = new CustomerDao();
		try {
			this.customerID = customer.getCustomerByEmailAndPassword(email, password).getId();
			System.out.println("you are login: " + customerID);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Constructor for customer facade
	 */
	public CustomerFacade() {
		super();
	}

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return true if login succeed
	 */
	@Override
	boolean login(String email, String password) {
		CustomerDao customer = new CustomerDao();
		try {
			if (customer.isCustomerExists(email, password))
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * @param coupon Receive a coupon and add to data base as purchase if valid by
	 *               some parameters
	 * @throws Exception Can throw an exception
	 */
	public void purchaseCoupon(Coupon coupon) throws Exception {
//		long couponID = coupon.getId();
//		CustomersVsCouponsDao customersVsCoupons = new CustomersVsCouponsDao();
//		customersVsCoupons.checkIfCustomerBought(customerID, couponID);
//		CouponsDao newcoupon = new CouponsDao();
//		newcoupon.addCouponPurchase(customerID, couponID);
	}

	/**
	 * @return This function return all coupons from that login customer
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCoupons() throws Exception {
		PurchasesDao customersVsCoupons = new PurchasesDao();
		return customersVsCoupons.getCustomerCouponByCustomerID(customerID);
	}

	/**
	 * @param category Receive a category
	 * @return This function return all coupons by the same category that bought
	 *         from this customer that login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCoupons(Category category) throws Exception {
		PurchasesDao customersVsCoupons = new PurchasesDao();
		return customersVsCoupons.getCustomerCouponByCategory(customerID, category);
	}

	/**
	 * @param maxPrice Receive a max price
	 * @return This function return all coupons that price lower then max price from
	 *         coustomer login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws Exception {
		PurchasesDao customersVsCoupons = new PurchasesDao();
		return customersVsCoupons.getCustomerCouponByMaxPrice(customerID, maxPrice);
	}

	/**
	 * @return This function return the customer that login
	 */
	public Customer getCustomerDetails() {
		CustomerDao customer = new CustomerDao();
		try {
			return customer.getCustomer(customerID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}