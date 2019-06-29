package coupons.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import coupons.beans.Company;
import coupons.beans.Login;
import coupons.beans.Name;
import coupons.beans.User;
import coupons.beans.UserDataClient;
import coupons.beans.UserDataMap;
import coupons.dao.ICompaniesDao;
import coupons.dao.IUsersDao;
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
	@Autowired
	private IUsersDao usersDao;
	@Autowired
	private ICompaniesDao companiesDao;

	/**
	 * @param user     Receive an user
	 * @param userData Receive an userData
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
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

		// check validation for create company
		if (user.getType().name().equals("Company")) {

			Long companyId = user.getCompany().getId();

			ValidationUtils.isValidCompanyId(companyId);

			if (!companiesDao.existsById(companyId))
				throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
						ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

			Company company = companiesDao.findById(user.getCompany().getId()).get();

			user.setCompany(company);

			// check validation for create customer || administrator
		} else if (user.getCompany() != null && user.getCompany().getId() != 0) {

			throw new ApplicationException(ErrorType.INVALID_COMPANY_ID, ErrorType.INVALID_COMPANY_ID.getMessage(),
					false);

		}

		if (usersDao.existsByUserName(user.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_ALREADY_EXISTS,
					ErrorType.USER_IS_ALREADY_EXISTS.getMessage(), false);

		return usersDao.save(user).getId();

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

		if (!usersDao.existsById(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		usersDao.deleteById(userId);

	}

	/**
	 * @param user     Receive an user
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
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

		if (!usersDao.existsById(user.getId()))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		if (usersDao.existsByUserName(user.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_ALREADY_EXISTS,
					ErrorType.USER_IS_ALREADY_EXISTS.getMessage(), false);

		// receive user from data base ( only user name and password valid to update )
		User myUser = usersDao.findById(user.getId()).get();

		myUser.setUserName(user.getUserName());
		myUser.setPassword(user.getPassword());

		usersDao.save(myUser);

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

		if (!usersDao.existsById(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		// receive user name
		String name = usersDao.findById(userId).get().getUserName();

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

		if (!usersDao.existsById(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		return usersDao.findById(userId).get();

	}

	/**
	 * @param userData Receive an userData
	 * @return This function return an user list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<User> getAllUsers(UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		List<User> users = new ArrayList<User>();

		usersDao.findAll().forEach(users::add);

		return users;

	}

	/**
	 * @param login Receive a login (contain user name and password)
	 * @return This function return a client type
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = true, timeout = 6)
	public UserDataClient login(Login login) throws ApplicationException {

		if (login == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		ValidationUtils.isValidName(login.getUserName());
		ValidationUtils.isValidPassword(login.getPassword());

		if (!usersDao.existsByUserName(login.getUserName()))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		User user = usersDao.findByUserNameAndPassword(login.getUserName(), login.getPassword());

		if (user == null)
			throw new ApplicationException(ErrorType.LOGIN_FAILED, ErrorType.LOGIN_FAILED.getMessage(), true);

		Long companyId = null;

		if (user.getCompany() != null)
			companyId = user.getCompany().getId();

		UserDataMap userDataMap = new UserDataMap(user.getId(), companyId, user.getType());

		int token = generateEncryptedToken(login.getUserName());

		// create user data to client
		UserDataClient userDataToClient = generateUserDataToClient(userDataMap.getId(), userDataMap.getCompanyId(),
				userDataMap.getClientType(), token);

		cacheManager.put(token, userDataMap);

		return userDataToClient;

	}

	// function

	private int generateEncryptedToken(String userName) {

		int additionEncrypt = (int) (Math.random() * 100000) + 1;

		String token = "never FinD ThisEncrypt-coDe()" + additionEncrypt + "%G" + userName + "-/@by@` ";

		return token.hashCode();

	}

	private UserDataClient generateUserDataToClient(long id, Long companyId, ClientType clientType, int token)
			throws ApplicationException {

		UserDataClient userData = new UserDataClient();

		userData.setId(id);
		userData.setCompanyId(companyId);
		userData.setClientType(clientType);
		userData.setToken(token);

		return userData;

	}

}
