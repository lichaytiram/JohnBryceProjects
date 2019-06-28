package coupons.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import coupons.beans.Coupon;
import coupons.enums.Category;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
@Repository
public interface ICouponsDao extends CrudRepository<Coupon, Long> {

	public boolean existsByCompanyIdAndTitle(long companyId, String title);

	public boolean existsByIdAndCompanyId(long couponId, long companyId);

	public List<Coupon> findByCompanyId(long companyId);

	public List<Coupon> findByCompanyIdAndCategory(long companyId, Category category);

	public List<Coupon> findByCompanyIdAndPriceLessThanEqual(long companyId, double maxPrice);

//	@Query("SELECT c , p.id , p.amount , c.title , c.description , c.category , c.companyId , c.startDate , c.endDate , c.image FROM Purchase p JOIN Coupon c ON c.id = p.couponId WHERE CUSTOMER_ID = :customer_id")
//	@Query("SELECT c , p.id , p.amount FROM Purchase p JOIN Coupon c ON c.id = p.couponId WHERE CUSTOMER_ID = :customer_id")
//	public List<Coupon> findByPurchasesCustomerId(@Param("customer_id") long customerId);
	public List<Coupon> findByPurchasesCustomerId(long customerId);

	public List<Coupon> findByPurchasesCustomerIdAndCategory(long customerId, Category category);

	public List<Coupon> findByPurchasesCustomerIdAndPriceLessThanEqual(long customerId, double maxPrice);

	@Query("SELECT CASE WHEN (COUNT(c) > 0) THEN TRUE ELSE FALSE END FROM Coupon c WHERE c.id = :coupon_id AND endDate > CURDATE()")
	public boolean isCouponValid(@Param("coupon_id") long couponId);

	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon c WHERE endDate < CURDATE()")
	public void deleteExpiredCoupon();

}
