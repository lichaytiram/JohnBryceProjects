package dao;

import java.util.ArrayList;

import javaBeans.Category;
import javaBeans.Coupon;

/**
 * This interface will implement by class couponsDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICouponsDAO extends IMainDAO {

	/**
	 * @param c Receive a coupon and insert to data base
	 * @throws Exception Can throw an exception
	 */
	void insert(Coupon c) throws Exception;

	/**
	 * @param couponID Receive a coupon id and delete from data base
	 * @throws Exception Can throw an exception
	 */
	void delete(int couponID) throws Exception;

	/**
	 * @param c Receive a coupon and update
	 * @throws Exception Can throw an exception
	 */
	void update(Coupon c) throws Exception;

	/**
	 * @param couponID  Receive a coupon id
	 * @param companyID Receive a company id and delete coupon if coupon belongs to
	 *                  that company
	 * @throws Exception Can throw an exception
	 */
	public void delete(int couponID, int companyID) throws Exception;

	/**
	 * @return This function retrn all coupons
	 * @throws Exception Can throw an exception
	 */
	ArrayList<Coupon> getAllCoupon() throws Exception;

	/**
	 * @param couponID Receive a coupon id
	 * @return This function return coupon by his id
	 * @throws Exception Can throw an exception
	 */
	Coupon getOneCoupon(int couponID) throws Exception;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and add to list purchase (in customer
	 *                   vs coupons)
	 * @throws Exception Can throw an exception
	 */
	void addCouponPurchase(int customerId, int couponId) throws Exception;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and delete it from list purchase (in
	 *                   customer vs coupons)
	 * @throws Exception Can throw an exception
	 */
	void deleteCouponPurchase(int customerId, int couponId) throws Exception;

	/**
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCouponsByID(int companyID) throws Exception;

	/**
	 * @param maxPrice  Receive a max price
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id and max price
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, int companyID) throws Exception;

	/**
	 * @param category  Receive a category
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id and his category
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category, int companyID) throws Exception;

	/**
	 * @return This function return all id for expired coupons
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Integer> getAllexpiredCouponsById() throws Exception;

}
