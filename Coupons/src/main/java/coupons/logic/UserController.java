package coupons.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import coupons.beans.Login;
import coupons.beans.Name;
import coupons.beans.User;
import coupons.beans.UserDataClient;
import coupons.beans.UserDataMap;
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
	 * @param user     Receive an user
	 * @param userData Receive an userData
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createUser(User user, UserDataMap userData) throws ApplicationException {

		if (user == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Administrator")) {
			if (!user.getType().name().equals("Customer"))
				throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		}

		ValidationUtils.isValidName(user.getUserName());
		ValidationUtils.isValidPassword(user.getPassword());
		ValidationUtils.isValidType(user.getType());

		if (usersDao.isUserExist(user.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_ALREADY_EXISTS,
					ErrorType.USER_IS_ALREADY_EXISTS.getMessage(), false);

		return usersDao.createUser(user);

	}

	/**
	 * @param userId   Receive an user id
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteUser(long userId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator")) {
			if (userId != userData.getId())
				throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		}

		ValidationUtils.isValidId(userId);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		usersDao.deleteUser(userId);

	}

	/**
	 * @param user     Receive an user
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateUser(User user, UserDataMap userData) throws ApplicationException {

		if (user == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Administrator")) {
			if (user.getId() != userData.getId())
				throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		}

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
	 * @param userId   Receive an user id
	 * @param userData Receive an userData
	 * @return This function return an user name
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Name getUserName(long userId, UserDataMap userDataMap) throws ApplicationException {

		if (userDataMap.getId() != userId)
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(userId);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		String name = usersDao.getUserName(userId);

		Name myName = new Name(name);

		return myName;

	}

	/**
	 * @param userId   Receive an user id
	 * @param userData Receive an userData
	 * @return This function return an user
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public User getUser(long userId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator")) {
			if (userId != userData.getId())
				throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		}

		ValidationUtils.isValidId(userId);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		return usersDao.getUser(userId);

	}

	/**
	 * @param userData Receive an userData
	 * @return This function return an user list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<User> getAllUsers(UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		return usersDao.getAllUsers();

	}

	/**
	 * @param login Receive a login (contain user name and password)
	 * @return This function return a client type
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public UserDataClient login(Login login) throws ApplicationException {

		if (login == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		ValidationUtils.isValidName(login.getUserName());
		ValidationUtils.isValidPassword(login.getPassword());

		if (!usersDao.isUserExist(login.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		UserDataMap userDataMap = usersDao.login(login.getUserName(), login.getPassword());
		int token = generateEncryptedToken(login.getUserName());

		UserDataClient userDataToClient = generateUserDataToClient(userDataMap.getId(), userDataMap.getClientType(),
				token);

		cacheManager.put(token, userDataMap);
		return userDataToClient;

	}

	// function

	private int generateEncryptedToken(String userName) {

		int additionEncrypt = (int) (Math.random() * 100000) + 1;

		String token = "never FinD ThisEncrypt-coDe()" + additionEncrypt + "%G" + userName + "-/@by@` ";

		return token.hashCode();

	}

	private UserDataClient generateUserDataToClient(long id, ClientType clientType, int token)
			throws ApplicationException {

		UserDataClient userData = new UserDataClient();

		userData.setId(id);
		userData.setClientType(clientType);
		userData.setToken(token);

		return userData;

	}

}
