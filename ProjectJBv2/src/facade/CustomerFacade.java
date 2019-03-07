package facade;

import java.util.ArrayList;

import beans.Category;
import beans.Coupon;
import beans.Customer;
import dbdao.CouponsDBDAO;
import dbdao.CustomerDBDAO;
import dbdao.CustomersVsCouponsDBDAO;
import exception.ExceptionName;

/**
 * This class manage the all function for client facade
 * 
 * @author Lichay
 */
public class CustomerFacade extends ClientFacade {

	private int customerID;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password and check if login succeed
	 * @throws ExceptionName Can throw an exception by name
	 */
	public CustomerFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			this.customerID = customer.getOneCustomerByEmailAndPassword(email, password).getId();
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
		CustomerDBDAO customer = new CustomerDBDAO();
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
		int couponID = coupon.getId();
		CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
		customersVsCoupons.checkIfCustomerBought(customerID, couponID);
		CouponsDBDAO newcoupon = new CouponsDBDAO();
		newcoupon.addCouponPurchase(customerID, couponID);
	}

	/**
	 * @return This function return all coupons from that login customer
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCoupons() throws Exception {
		CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
		return customersVsCoupons.getCustomerCouponByCustomerID(customerID);
	}

	/**
	 * @param category Receive a category
	 * @return This function return all coupons by the same category that bought
	 *         from this customer that login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCoupons(Category category) throws Exception {
		CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
		return customersVsCoupons.getCustomerCouponByCategory(customerID, category);
	}

	/**
	 * @param maxPrice Receive a max price
	 * @return This function return all coupons that price lower then max price from
	 *         coustomer login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws Exception {
		CustomersVsCouponsDBDAO customersVsCoupons = new CustomersVsCouponsDBDAO();
		return customersVsCoupons.getCustomerCouponByMaxPrice(customerID, maxPrice);
	}

	/**
	 * @return This function return the customer that login
	 */
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