package logic;

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

	public ClientType login(String userName, String password) throws ApplicationException {

		if (usersDao.isUserExist(userName, password))
			return usersDao.login(userName, password);

		throw new ApplicationException("Have a problem\n" + "This user isn't exist!");
	}
}
