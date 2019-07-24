package coupons.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import coupons.entities.User;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
@Repository
public interface IUsersDao extends CrudRepository<User, Long> {

	/**
	 * @param userName Receive an user name
	 * @return This function return true if user name exists
	 */
	public boolean existsByUserName(String userName);

	/**
	 * @param userName Receive an user name
	 * @param password Receive an password
	 * @return This function return true if user exists
	 */
	public User findByUserNameAndPassword(String userName, String password);

}
