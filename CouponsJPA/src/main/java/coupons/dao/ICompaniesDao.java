package coupons.dao;

import org.springframework.data.repository.CrudRepository;

import coupons.beans.Company;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
public interface ICompaniesDao extends CrudRepository<Company, Long> {

	/**
	 * @param name Receive a name
	 * @return This function return true if company exists
	 */
	public boolean existsByName(String name);

}