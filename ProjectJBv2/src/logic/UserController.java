package logic;

import java.util.List;

import beans.User;
import dao.UsersDao;
import enums.ClientType;
import exception.ApplicationException;
import utils.IdUtils;
import utils.NameUtils;
import utils.PasswordUtils;

public class UserController {

	private UsersDao usersDao;

	public UserController() {
		usersDao = new UsersDao();
	}

	public long createUser(User user) throws ApplicationException {

		if (user == null)
			throw new ApplicationException("Have a problem\n" + "This user is empty!");

		NameUtils.isValidName(user.getUserName());
		PasswordUtils.isValidPassword(user.getPassword());

		if (usersDao.isUserExist(user.getUserName()))
			throw new ApplicationException("Have a problem\n" + "This user name already exist!");

		// return id from this user
		return usersDao.createUser(user);

	}

	public void deleteUser(long userId) throws ApplicationException {

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException("Have a problem\n" + "This user id isn't exist!");

		usersDao.deleteUser(userId);

	}

	public void deleteUserByCompanyId(long companyId) throws ApplicationException {

		if (!usersDao.isUserExistByCompanyId(companyId))
			throw new ApplicationException("Have a problem\n" + "This company id isn't exist!");
		usersDao.deleteUserByCompanyId(companyId);

	}

	public void updateUser(String userName, String password, long userId) throws ApplicationException {

		IdUtils.isValidId(userId);
		NameUtils.isValidName(userName);
		PasswordUtils.isValidPassword(password);

		if (!usersDao.isUserExist(userId))
			throw new ApplicationException("Have a problem\n" + "This id isn't exist!");

		if (usersDao.isUserExist(userName))
			throw new ApplicationException("Have a problem\n" + "This user name already exist!");

		usersDao.updateUser(userName, password, userId);

	}

	public List<User> getAllUsers() throws ApplicationException {

		return usersDao.getAllUsers();

	}

	public ClientType login(String userName, String password) throws ApplicationException {

		if (usersDao.isUserExist(userName))
			return usersDao.login(userName, password);

		throw new ApplicationException("Have a problem\n" + "This user isn't exist!");
	}

}
