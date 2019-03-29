package logic;

import java.util.List;

import beans.User;
import dao.UsersDao;
import enums.ClientType;
import exception.ApplicationException;

public class UserController {

	private UsersDao usersDao;

	UserController() {
		usersDao = new UsersDao();
	}

	public long createUser(User user) throws ApplicationException {

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
