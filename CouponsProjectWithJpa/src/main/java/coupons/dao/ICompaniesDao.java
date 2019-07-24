package coupons.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import coupons.entities.Company;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
@Repository
public interface ICompaniesDao extends CrudRepository<Company, Long> {

	/**
	 * @param name Receive a name
	 * @return This function return true if company exists
	 */
	public boolean existsByName(String name);

}
