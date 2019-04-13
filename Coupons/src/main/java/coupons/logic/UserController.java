package coupons.logic;

import java.util.List;

import org.springframework.stereotype.Controller;

import coupons.beans.User;
import coupons.dao.IUsersDao;
import coupons.dao.UsersDao;
import coupons.enums.ClientType;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.ValidationUtils;

/**
 * This class manage the all function for user facade
 * 
 * @author Lichay
 */
@Controller
public class UserController {

	private IUsersDao usersDao;

	/**
	 * This function instantiate all references
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public UserController() {

		usersDao = new UsersDao();

	}

	/**
	 * @param user Receive an user
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createUser(User user) throws ApplicationException {

		if (user == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		ValidationUtils.isValidName(user.getUserName());
		ValidationUtils.isValidPassword(user.getPassword());
		ValidationUtils.isValidType(user.getType());

		if (usersDao.isUserExist(user.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_ALREADY_EXISTS.getMessage());

		return usersDao.createUser(user);

	}

	/**
	 * @param userId Receive an user id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteUser(long userId) throws ApplicationException {

		ValidationUtils.isValidId(userId);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS.getMessage());

		usersDao.deleteUser(userId);

	}

	/**
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteUserByCompanyId(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!usersDao.isUserExistByCompanyId(companyId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS.getMessage());

		usersDao.deleteUserByCompanyId(companyId);

	}

	/**
	 * @param userName Receive an user name
	 * @param password Receive a password
	 * @param userId   Receive an user id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateUser(String userName, String password, long userId) throws ApplicationException {

		ValidationUtils.isValidId(userId);
		ValidationUtils.isValidName(userName);
		ValidationUtils.isValidPassword(password);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS.getMessage());

		if (usersDao.isUserExist(userName))
			throw new ApplicationException(ErrorType.USER_IS_ALREADY_EXISTS.getMessage());

		usersDao.updateUser(userName, password, userId);

	}

	/**
	 * @return This function return an user list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<User> getAllUsers() throws ApplicationException {

		return usersDao.getAllUsers();

	}

	/**
	 * @param userName Receive an user name
	 * @param password Receive a password
	 * @return This function return a client type
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public ClientType login(String userName, String password) throws ApplicationException {

		ValidationUtils.isValidName(userName);
		ValidationUtils.isValidPassword(password);

		if (!usersDao.isUserExist(userName))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS.getMessage());

		return usersDao.login(userName, password);

	}

}
