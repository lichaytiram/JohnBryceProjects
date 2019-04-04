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
public class CustomerDao implements ICustomersDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#insert(javaBeans.Customer)
	 */
	public void createCustomer(Customer customer) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO customers (ID,FIRST_NAME,LAST_NAME,PHONE_NUMBER,EMAIL) VALUES ( ? , ? , ? , ? , ? )");
			preparedStatement.setLong(1, customer.getId());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getPhoneNumber());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.executeUpdate();

			System.out.println("insert customers has succeed");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage() , e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#delete(long)
	 */
	public void deleteCustomer(long customerId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE ID = ?");
			preparedStatement.setLong(1, customerId);
			preparedStatement.executeUpdate();

			System.out.println("delete from customers has done");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage() , e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#update(javaBeans.Customer)
	 */
	public void updateCustomer(Customer customer) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE customers SET FIRST_NAME= ? , LAST_NAME= ? , PHONE_NUMBER= ? , EMAIL= ? WHERE ID= ?");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getPhoneNumber());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setLong(5, customer.getId());
			preparedStatement.executeUpdate();

			System.out.println("update customers has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ErrorType.PROBLEM.getMessage() , e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getAllCustomer()
	 */
//	@Override
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
			throw new ApplicationException(ErrorType.PROBLEM.getMessage() , e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;
	}

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
			throw new ApplicationException(ErrorType.PROBLEM.getMessage() , e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getOneCustomer(int)
	 */
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
			throw new ApplicationException(ErrorType.PROBLEM.getMessage() , e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return customer;
	}

}
