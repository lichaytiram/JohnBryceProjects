package coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import coupons.beans.Purchase;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
@Repository
public interface IPurchasesDao extends CrudRepository<Purchase, Long> {

	public List<Purchase> findByCustomerId(long customerId);

}
