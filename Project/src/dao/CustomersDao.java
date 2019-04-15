package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Customer;
import enums.ErrorType;
import exception.ApplicationException;
import utils.JdbcUtils;

/**
 * This class create a connection with data base
 * 
 * @author Lichay
 *
 */
public class CustomersDao implements ICustomersDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long createCustomer(Customer customer) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO customers (FIRST_NAME,LAST_NAME,PHONE_NUMBER,EMAIL,ID) VALUES ( ? , ? , ? , ? , ? )");

			// call to private function that prepared the statement
			extractPreparedStatement(preparedStatement, customer.getFirstName(), customer.getLastName(),
					customer.getPhoneNumber(), customer.getEmail(), customer.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

		return customer.getId();

	}

	/**
	 * {@inheritDoc}
	 */
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
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCustomer(Customer customer) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE customers SET FIRST_NAME = ? , LAST_NAME = ? , PHONE_NUMBER = ? , EMAIL = ? WHERE ID = ?");

			// call to private function that prepared the statement
			extractPreparedStatement(preparedStatement, customer.getFirstName(), customer.getLastName(),
					customer.getPhoneNumber(), customer.getEmail(), customer.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> getAllCustomer() throws ApplicationException {

		Customer customer = null;
		List<Customer> list = new ArrayList<Customer>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM customers");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				customer = new Customer(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"),
						resultSet.getString("LAST_NAME"), resultSet.getString("PHONE_NUMBER"),
						resultSet.getString("EMAIL"));

				list.add(customer);

			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;

	}

	/**
	 * {@inheritDoc}
	 */
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

				customer = new Customer(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"),
						resultSet.getString("LAST_NAME"), resultSet.getString("PHONE_NUMBER"),
						resultSet.getString("EMAIL"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

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
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		}
		return preparedStatement;

	}

}
