package dao;

import java.util.List;

import beans.User;
import enums.ClientType;
import exception.ApplicationException;

public interface IUsersDao {

	public long createUser(User user) throws ApplicationException;

	public void deleteUser(long userId) throws ApplicationException;

	public void deleteUserByCompanyId(long companyId) throws ApplicationException;

	public User getUser(long userId) throws ApplicationException;

	public List<User> getAllUsers() throws ApplicationException;

	public void updateUser(String userName, String password, long userId) throws ApplicationException;

	public ClientType login(String userName, String password) throws ApplicationException;

	public boolean isUserExistByCompanyId(long companyId) throws ApplicationException;

	public boolean isUserExist(String userName) throws ApplicationException;

	public boolean isUserExist(long userId) throws ApplicationException;

}
