package logic;

import java.util.List;

import beans.User;
import dao.UsersDao;
import enums.ClientType;
import enums.ErrorType;
import exception.ApplicationException;
import utils.ValidationUtils;

public class UserController {

	private UsersDao usersDao;

	public UserController() {

		usersDao = new UsersDao();

	}

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

	public void deleteUser(long userId) throws ApplicationException {

		ValidationUtils.isValidId(userId);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS.getMessage());

		usersDao.deleteUser(userId);

	}

	public void deleteUserByCompanyId(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!usersDao.isUserExistByCompanyId(companyId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS.getMessage());

		usersDao.deleteUserByCompanyId(companyId);

	}

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

	public List<User> getAllUsers() throws ApplicationException {

		return usersDao.getAllUsers();

	}

	public ClientType login(String userName, String password) throws ApplicationException {

		ValidationUtils.isValidName(userName);
		ValidationUtils.isValidPassword(password);

		if (!usersDao.isUserExist(userName))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS.getMessage());

		return usersDao.login(userName, password);

	}

}
