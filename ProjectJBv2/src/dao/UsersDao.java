package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import enums.ClientType;
import enums.ProblemsException;
import exception.ApplicationException;
import utils.JdbcUtils;

public class UsersDao {

	public long createUser(User user) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO users (USER_NAME,PASSWORD,TYPE,COMPANY_ID) VALUES ( ? , ? , ? , ? )",
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement(preparedStatement, user.getUserName(), user.getPassword());
			preparedStatement.setString(3, user.getType().name());
			preparedStatement.setBigDecimal(4,
					(user.getCompanyId() == null) ? null : BigDecimal.valueOf(user.getCompanyId()));
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				System.out.println("insert users has succeed");
				return resultSet.getLong(1);
			}
			throw new ApplicationException(ProblemsException.problem.getName() + "Failed to create user id");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

	}

	public ClientType login(String userName, String password) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT USER_NAME , PASSWORD FROM users WHERE USER_NAME = ? AND PASSWORD = ? ");
			preparedStatement(preparedStatement, userName, password);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("login has successed");
				return ClientType.valueOf(resultSet.getString("TYPE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		throw new ApplicationException(ProblemsException.problem.getName() + "Login isn't success");
	}

	public boolean isUserExist(String userName, String password) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT USER_NAME , PASSWORD FROM users WHERE USER_NAME = ? AND PASSWORD = ? ");
			preparedStatement(preparedStatement, userName, password);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}

	public boolean isUserExist(String userName) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT USER_NAME , PASSWORD FROM users WHERE USER_NAME = ? ");
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}

	// extract

	private PreparedStatement preparedStatement(PreparedStatement preparedStatement, String user, String password)
			throws ApplicationException {

		try {
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		}
		return preparedStatement;
	}

}
