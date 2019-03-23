package logic;

import java.util.ArrayList;

import beans.Customer;
import dao.CustomerDao;
import dao.PurchasesDao;
import exception.ApplicationException;

/**
 * This class manage the all function for customer facade
 * 
 * @author Lichay
 */
public class CustomerController {

	private CustomerDao customerDao;
	private PurchasesDao purchasesDao;

	public CustomerController() throws ApplicationException {
		customerDao = new CustomerDao();
		purchasesDao = new PurchasesDao();
	}

	public void createCustomer(Customer customer) throws ApplicationException {
		if (customerDao.isCustomerExists(customer.getEmail(), customer.getPassword())) {
			throw new ApplicationException("Have a problem:\n" + "This customer exist!");
		}
		customerDao.createCustomer(customer);

	}

	public void deleteCustomer(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId)) {
			return;
		}

		purchasesDao.refundCouponByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);

	}

	public void updateCustomer(Customer customer) throws ApplicationException {

		if (customerDao.isCustomerExists(customer.getId())) {
			if (customerDao.isCustomerExists(customer.getEmail(), customer.getPassword())) {
				throw new ApplicationException("Have a problem:\n" + "This customer does exist");
			}
			customerDao.updateCustomer(customer);
		} else {
			throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");
		}
	}

	public ArrayList<Customer> getAllCustomer() throws ApplicationException {
		return customerDao.getAllCustomer();
	}

	public Customer getCustomer(long customerId) throws ApplicationException {
		if (customerDao.isCustomerExists(customerId)) {
			return customerDao.getCustomer(customerId);
		}

		throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");
	}

	public Customer getCustomerByEmailAndPassword(String email, String password) throws ApplicationException {
		if (customerDao.isCustomerExists(email, password)) {
			return customerDao.getCustomerByEmailAndPassword(email, password);
		}

		throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");
	}

//	/**
//	 * @param coupon Receive a coupon and add to data base as purchase if valid by
//	 *               some parameters
//	 * @throws Exception Can throw an exception
//	 */
//	public void purchaseCoupon(Coupon coupon) throws Exception {
//		long couponID = coupon.getId();
//		CustomersVsCouponsDao customersVsCoupons = new CustomersVsCouponsDao();
//		customersVsCoupons.checkIfCustomerBought(customerID, couponID);
//		CouponsDao newcoupon = new CouponsDao();
//		newcoupon.addCouponPurchase(customerID, couponID);
//	}
//
//	/**
//	 * @return This function return all coupons from that login customer
//	 * @throws Exception Can throw an exception
//	 */
//	public ArrayList<Coupon> getCustomerCoupons() throws Exception {
//		PurchasesDao customersVsCoupons = new PurchasesDao();
//		return customersVsCoupons.getCustomerCouponByCustomerId(customerID);
//	}
//
//	/**
//	 * @param category Receive a category
//	 * @return This function return all coupons by the same category that bought
//	 *         from this customer that login
//	 * @throws Exception Can throw an exception
//	 */
//	public ArrayList<Coupon> getCustomerCoupons(Category category) throws Exception {
//		PurchasesDao customersVsCoupons = new PurchasesDao();
//		return customersVsCoupons.getCustomerCouponByCategory(customerID, category);
//	}
//
//	/**
//	 * @param maxPrice Receive a max price
//	 * @return This function return all coupons that price lower then max price from
//	 *         coustomer login
//	 * @throws Exception Can throw an exception
//	 */
//	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws Exception {
//		PurchasesDao customersVsCoupons = new PurchasesDao();
//		return customersVsCoupons.getCustomerCouponByMaxPrice(customerID, maxPrice);
//	}
//
//	/**
//	 * @return This function return the customer that login
//	 */
//	public Customer getCustomerDetails() {
//		CustomerDao customer = new CustomerDao();
//		try {
//			return customer.getCustomer(customerID);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return null;
//
//	}

}