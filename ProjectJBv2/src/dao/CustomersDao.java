package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import beans.Category;
//import beans.Company;
//import beans.Coupon;
import beans.Customer;
import enums.ErrorType;
import exception.ApplicationException;
import utils.JdbcUtils;

/**
 * This class create a connection with data base ( with name customers )
 * 
 * @author Lichay
 *
 */
public class CustomersDao implements ICustomersDao {

	@Override
	public long createCustomer(Customer customer) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO customers (FIRST_NAME,LAST_NAME,PHONE_NUMBER,EMAIL,ID) VALUES ( ? , ? , ? , ? , ? )");

			extractPreparedStatement(preparedStatement, customer.getFirstName(), customer.getLastName(),
					customer.getPhoneNumber(), customer.getEmail(), customer.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

		return customer.getId();
	}

	@Override
	public void deleteCustomer(long customerId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE ID = ?");
			preparedStatement.setLong(1, customerId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE customers SET FIRST_NAME= ? , LAST_NAME= ? , PHONE_NUMBER= ? , EMAIL= ? WHERE ID= ?");

			extractPreparedStatement(preparedStatement, customer.getFirstName(), customer.getLastName(),
					customer.getPhoneNumber(), customer.getEmail(), customer.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	public List<Customer> getAllCustomer() throws ApplicationException {

		List<Customer> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM customers");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(new Customer(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"),
						resultSet.getString("LAST_NAME"), resultSet.getString("PHONE_NUMBER"),
						resultSet.getString("EMAIL")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;

	}

	@Override
	public boolean isCustomerExists(long customerId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE ID = ?");
			preparedStatement.setLong(1, customerId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;

	}

	@Override
	public Customer getCustomer(long customerId) throws ApplicationException {

		Customer customer = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE ID = ? ");
			preparedStatement.setLong(1, customerId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customer = (new Customer(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"),
						resultSet.getString("LAST_NAME"), resultSet.getString("PHONE_NUMBER"),
						resultSet.getString("EMAIL")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return customer;

	}

	// extract

	private PreparedStatement extractPreparedStatement(PreparedStatement preparedStatement, String firstName,
			String lastName, String phoneNumber, String email, long id) throws ApplicationException {

		try {
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, phoneNumber);
			preparedStatement.setString(4, email);
			preparedStatement.setLong(5, id);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage(), e);
		}
		return preparedStatement;
	}

}
