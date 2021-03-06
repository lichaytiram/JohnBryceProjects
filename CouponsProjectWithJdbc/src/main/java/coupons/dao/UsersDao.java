package coupons.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import coupons.beans.User;
import coupons.beans.UserDataMap;
import coupons.enums.ClientType;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.JdbcUtils;

/**
 * This class create a connection with data base
 * 
 * @author Lichay
 *
 */
@Repository
public class UsersDao implements IUsersDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long createUser(User user) throws ApplicationException {

		BigDecimal bigDecimal = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO users (USER_NAME,PASSWORD,TYPE,COMPANY_ID) VALUES ( ? , ? , ? , ? )",
					PreparedStatement.RETURN_GENERATED_KEYS);

			// call to private function that prepared the statement
			preparedStatement(preparedStatement, user.getUserName(), user.getPassword());
			preparedStatement.setString(3, user.getType().name());

			// check if user is a company or else.
			// if user isn't get company id he stay null
			if (user.getCompanyId() != null) {

				// save the digit of company
				bigDecimal = BigDecimal.valueOf(user.getCompanyId());
			}

			// BigDecimal is a class that can contain digit or null
			preparedStatement.setBigDecimal(4, bigDecimal);

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {

				return resultSet.getLong(1);
			}

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true);

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUser(long userId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM users WHERE ID = ?");
			preparedStatement.setLong(1, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserByCompanyId(long companyId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM users WHERE COMPANY_ID = ?");
			preparedStatement.setLong(1, companyId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(String userName, String password, long userId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("UPDATE users SET USER_NAME= ? , PASSWORD=? WHERE ID= ?");

			// call to private function that prepared the statement
			preparedStatement(preparedStatement, userName, password);
			preparedStatement.setLong(3, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUserName(long userId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT USER_NAME FROM users WHERE ID = ?");
			preparedStatement.setLong(1, userId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return resultSet.getString("USER_NAME");
			}

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true);

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUser(long userId) throws ApplicationException {

		Long companyId = null;
		ClientType clientType = null;
		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE ID = ?");
			preparedStatement.setLong(1, userId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				companyId = null;

				// check if user is a company or else.
				// if user isn't get company id he will stay null
				if (resultSet.getLong("COMPANY_ID") != 0) {

					companyId = resultSet.getLong("COMPANY_ID");
				}

				// change type to client type
				clientType = ClientType.valueOf(resultSet.getString("TYPE"));

				user = new User(resultSet.getLong("ID"), resultSet.getString("USER_NAME"),
						resultSet.getString("PASSWORD"), clientType, companyId);

			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
		return user;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDataMap login(String userName, String password) throws ApplicationException {

		long id;
		Long companyId = null;
		ClientType clientType = null;
		UserDataMap userDataToMap = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT ID , COMPANY_ID , TYPE FROM users WHERE USER_NAME = ? AND PASSWORD = ?");

			// call to private function that prepared the statement
			preparedStatement(preparedStatement, userName, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				id = resultSet.getLong("ID");

				// check if user is a company or else.
				// if user isn't get company id he will stay null
				if (resultSet.getLong("COMPANY_ID") != 0) {

					companyId = resultSet.getLong("COMPANY_ID");
				}

				// change type to client type
				clientType = ClientType.valueOf(resultSet.getString("TYPE"));

				userDataToMap = new UserDataMap(id, companyId, clientType);

				return userDataToMap;

			}

			throw new ApplicationException(ErrorType.LOGIN_FAILED, ErrorType.LOGIN_FAILED.getMessage(), true);

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() throws ApplicationException {

		Long companyId = null;
		ClientType clientType = null;
		User user = null;
		List<User> list = new ArrayList<User>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM users");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				companyId = null;

				// check if user is a company or else.
				// if user isn't get company id he stay null
				if (resultSet.getLong("COMPANY_ID") != 0) {

					companyId = resultSet.getLong("COMPANY_ID");
				}

				// change type to client type
				clientType = ClientType.valueOf(resultSet.getString("TYPE"));

				user = new User(resultSet.getLong("ID"), resultSet.getString("USER_NAME"),
						resultSet.getString("PASSWORD"), clientType, companyId);

				list.add(user);

			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
		return list;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserExistByCompanyId(long companyId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT COMPANY_ID FROM users WHERE COMPANY_ID = ?");
			preparedStatement.setLong(1, companyId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserExist(String userName) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT USER_NAME FROM users WHERE USER_NAME = ?");
			preparedStatement.setString(1, userName);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserExist(long userId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT ID FROM users WHERE ID = ?");
			preparedStatement.setLong(1, userId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;

	}

	// extract

	private PreparedStatement preparedStatement(PreparedStatement preparedStatement, String userName, String password)
			throws ApplicationException {

		try {
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		}
		return preparedStatement;

	}

}
