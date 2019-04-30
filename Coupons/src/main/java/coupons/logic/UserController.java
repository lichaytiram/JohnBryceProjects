package coupons.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import coupons.beans.Login;
import coupons.beans.User;
import coupons.beans.UserDataToClient;
import coupons.beans.UserDataToMap;
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

	@Autowired
	private ICacheManager cacheManager;

	private IUsersDao usersDao;

	/**
	 * This function instantiate all references
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public UserController() throws ApplicationException {

		usersDao = new UsersDao();

	}

	/**
	 * @param user Receive an user
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createUser(User user) throws ApplicationException {

		if (user == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		ValidationUtils.isValidName(user.getUserName());
		ValidationUtils.isValidPassword(user.getPassword());
		ValidationUtils.isValidType(user.getType());

		if (usersDao.isUserExist(user.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_ALREADY_EXISTS,
					ErrorType.USER_IS_ALREADY_EXISTS.getMessage(), false);

		return usersDao.createUser(user);

	}

	/**
	 * @param userId Receive an user id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteUser(long userId) throws ApplicationException {

		ValidationUtils.isValidId(userId);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		usersDao.deleteUser(userId);

	}

	/**
	 * @param userName Receive an user name
	 * @param password Receive a password
	 * @param userId   Receive an user id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateUser(User user) throws ApplicationException {

		if (user == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		ValidationUtils.isValidId(user.getId());
		ValidationUtils.isValidName(user.getUserName());
		ValidationUtils.isValidPassword(user.getPassword());

		if (!usersDao.isUserExist(user.getId()))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		if (usersDao.isUserExist(user.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_ALREADY_EXISTS,
					ErrorType.USER_IS_ALREADY_EXISTS.getMessage(), false);

		usersDao.updateUser(user.getUserName(), user.getPassword(), user.getId());

	}

	/**
	 * @param userId Receive an user id
	 * @return This function return an user
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public User getUser(long userId) throws ApplicationException {

		ValidationUtils.isValidId(userId);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		return usersDao.getUser(userId);

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
	public UserDataToClient login(Login login) throws ApplicationException {

		if (login == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		ValidationUtils.isValidName(login.getUserName());
		ValidationUtils.isValidPassword(login.getPassword());

		if (!usersDao.isUserExist(login.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		ClientType clientType = usersDao.login(login.getUserName(), login.getPassword());
		int token = generateEncryptedToken(login.getUserName());

		UserDataToMap userDataToMap = generateUserDataToMap(login.getUserName());
		UserDataToClient userDataToClient = generateUserDataToClient(clientType, token);

		cacheManager.put(token, userDataToMap);

		return userDataToClient;

	}

	// function

	private int generateEncryptedToken(String userName) {

		int additionEncrypt = (int) (Math.random() * 100000) + 1;

		String token = "never FinD ThisEncrypt-coDe()" + additionEncrypt + "%G" + userName + "-/@by@` ";

		return token.hashCode();

	}

	private UserDataToMap generateUserDataToMap(String userName) throws ApplicationException {

		UserDataToMap userData = new UserDataToMap();

		userData = usersDao.getUserDataToMap(userName);

		return userData;

	}

	private UserDataToClient generateUserDataToClient(ClientType clientType, int token) throws ApplicationException {

		UserDataToClient userData = new UserDataToClient();

		userData.setClientType(clientType);
		userData.setToken(token);

		return userData;

	}

}
