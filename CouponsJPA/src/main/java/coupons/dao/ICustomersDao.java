package coupons.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import coupons.beans.Customer;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
@Repository
public interface ICustomersDao extends CrudRepository<Customer, Long> {

}