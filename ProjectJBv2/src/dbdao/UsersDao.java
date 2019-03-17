package dbdao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import utils.JdbcUtils;

public class UsersDao {

	public void createUser(User user) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO users (USER_NAME,PASSWORD,TYPE,COMPANY_ID) VALUES ( ? , ? , ? , ? )");
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getType().name());
			preparedStatement.setBigDecimal(4,
					(user.getCompanyId() == null) ? null : BigDecimal.valueOf(user.getCompanyId()));
			preparedStatement.executeUpdate();
			
			System.out.println("insert users has succeed");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	public boolean login(String user, String password) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT USER_NAME , PASSWORD FROM users WHERE USER_NAME = ? AND PASSWORD = ? ");
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();

			if (result.next()) {
				System.out.println("logic has successed");
				return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, result);
		}
		return false;
	}

}
