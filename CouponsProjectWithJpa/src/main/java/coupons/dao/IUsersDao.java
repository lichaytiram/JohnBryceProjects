package coupons.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import coupons.beans.User;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
@Repository
public interface IUsersDao extends CrudRepository<User, Long> {

	public boolean existsByUserName(String userName);

	public User findByUserNameAndPassword(String userName, String password);

}
