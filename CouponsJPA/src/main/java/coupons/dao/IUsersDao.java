package coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import coupons.beans.User;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
public interface IUsersDao extends CrudRepository<User, Long> {

	public boolean existsByUserName(String userName);

	public User findByUserNameAndPassword(String userName, String password);

//	/**
//	 * @param user Receive an user
//	 * @return This function return an id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public long createUser(User user) throws ApplicationException;
//
//	/**
//	 * @param userId Receive an user id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void deleteUser(long userId) throws ApplicationException;
//
//	/**
//	 * @param companyId Receive a company id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void deleteUserByCompanyId(long companyId) throws ApplicationException;
//
//	/**
//	 * @param userName Receive an user name
//	 * @param password Receive a password
//	 * @param userId   Receive an user id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void updateUser(String userName, String password, long userId) throws ApplicationException;
//
//	/**
//	 * @param userId Receive an user id
//	 * @return This function return an user name
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public String getUserName(long userId) throws ApplicationException;
//
//	/**
//	 * @param userId Receive an user id
//	 * @return This function return an user
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public User getUser(long userId) throws ApplicationException;
//
//	/**
//	 * @param userName Receive a user name
//	 * @param password Receive a password
//	 * @return This function return an userDataMap
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public UserDataMap login(String userName, String password) throws ApplicationException;
//
//	/**
//	 * @return This function return an user list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<User> getAllUsers() throws ApplicationException;
//
//	/**
//	 * @param companyId Receive a company id
//	 * @return This function return true if user exists
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public boolean isUserExistByCompanyId(long companyId) throws ApplicationException;
//
//	/**
//	 * @param userName Receive am user name
//	 * @return This function return true if user exists
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public boolean isUserExist(String userName) throws ApplicationException;
//
//	/**
//	 * @param userId Receive an user id
//	 * @return This function return true if user exists
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public boolean isUserExist(long userId) throws ApplicationException;

}
