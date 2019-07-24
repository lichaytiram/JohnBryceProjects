package coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import coupons.entities.Purchase;
import coupons.enums.Category;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
@Repository
public interface IPurchasesDao extends CrudRepository<Purchase, Long> {

	/**
	 * @param customerId Receive a customer id
	 * @return This function return all purchase
	 */
	public List<Purchase> findByCustomerId(long customerId);

	/**
	 * @param customerId Receive a customer id
	 * @param category   Receive a category
	 * @return This function return list of purchase by some values
	 */
	public List<Purchase> findByCustomerIdAndCouponCategory(long customerId, Category category);

	/**
	 * @param customerId Receive a customer id
	 * @param maxPrice   Receive a map price
	 * @return This function return list of purchase by some values
	 */
	public List<Purchase> findByCustomerIdAndCouponPriceLessThanEqual(long customerId, double maxPrice);

}
