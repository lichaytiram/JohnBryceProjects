package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import beans.Category;
//import beans.Company;
//import beans.Coupon;
import beans.Customer;
import exception.ApplicationException;
//import exception.ExceptionName;
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
					"INSERT INTO customers (FIRST_NAME,lAST_NAME,EMAIL,PASSWORD) VALUES ( ? , ? , ? , ? )");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.executeUpdate();

			System.out.println("insert customers has succeed");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("Problem!" + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#delete(long)
	 */
	public void deleteCustomer(long customerID) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
//			PreparedStatement preparedStatement1 = con
//					.prepareStatement("DELETE FROM customersVsCoupons WHERE CUSTOMER_ID = ?");
//			preparedStatement1.setLong(1, customerID);
//			preparedStatement1.executeUpdate();
			preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE ID = ?");
			preparedStatement.setLong(1, customerID);
			preparedStatement.executeUpdate();

			System.out.println("delete from customers has done");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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

//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
//			while (result.next())
//				if (result.getString("EMAIL").equals(customer.getEmail()))
//					throw new ExceptionName("The customer's EMAIL is already exist on data base");

			preparedStatement = connection.prepareStatement(
					"UPDATE customers SET FIRST_NAME=? , lAST_NAME=? , EMAIL=? , PASSWORD=? WHERE ID=? ");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setLong(5, customer.getId());
			preparedStatement.executeUpdate();

			System.out.println("update customers has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getAllCustomer()
	 */
	@Override
	public ArrayList<Customer> getAllCustomer() throws ApplicationException {
		ArrayList<Customer> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM customers");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(new Customer(resultSet.getInt("ID"), resultSet.getString("PASSWORD"),
						resultSet.getString("EMAIL"), resultSet.getString("FIRST_NAME"),
						resultSet.getString("lAST_NAME")));
			}

//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
//			while (result.next()) {
//				Customer customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"),
//						result.getString("EMAIL"), result.getString("FIRST_NAME"), result.getString("lAST_NAME"));
//
//				ResultSet addCoupons = con.createStatement().executeQuery(
//						"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
//								+ customer.getId());
//				while (addCoupons.next()) {
//					Category category = null;
//					for (Category ca : Category.values())
//						if (ca.ordinal() == addCoupons.getInt("CATEGORY_ID")) {
//							category = ca;
//							break;
//						}
//					customer.setCouponList(new Coupon(addCoupons.getInt("ID"), addCoupons.getInt("COMPANY_ID"),
//							category, addCoupons.getString("TITLE"), addCoupons.getString("DESCRIPTION"),
//							addCoupons.getDouble("PRICE"), addCoupons.getString("IMAGE")));
//				}
//
//				list.add(customer);
//			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#isCustomerExists(java.lang.String, java.lang.String)
	 */
	public boolean isCustomerExists(String email, String password) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("SELECT * FROM customers WHERE EMAIL = ? AND PASSWORD = ? ");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;
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

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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
	public Customer getCustomer(long customerID) throws ApplicationException {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE ID = ? ");
			preparedStatement.setLong(1, customerID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer(resultSet.getInt("ID"), resultSet.getString("PASSWORD"),
						resultSet.getString("EMAIL"), resultSet.getString("FIRST_NAME"),
						resultSet.getString("LAST_NAME"));

//			result = con.createStatement().executeQuery("SELECT * FROM customers WHERE ID=" + customerID);
//			if (result.next())
//				customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
//						result.getString("FIRST_NAME"), result.getString("LAST_NAME"));
//			result = con.createStatement().executeQuery(
//					"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
//							+ customerID);
//			while (result.next()) {
//				Category category = null;
//				for (Category ca : Category.values())
//					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
//						category = ca;
//						break;
//					}
//				customer.setCouponList(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
//						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDouble("PRICE"),
//						result.getString("IMAGE")));
//			}

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getOneCustomerByEmailAndPassword(java.lang.String,
	 * java.lang.String)
	 */
	public Customer getCustomerByEmailAndPassword(String email, String password) throws ApplicationException {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE EMAIL = ? AND PASSWORD = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer(resultSet.getInt("ID"), resultSet.getString("PASSWORD"),
						resultSet.getString("EMAIL"), resultSet.getString("FIRST_NAME"),
						resultSet.getString("LAST_NAME"));

//			result = con.createStatement().executeQuery(
//					"SELECT * FROM customers where email='" + email + "' AND PASSWORD='" + password + "'");
//			if (result.next())
//				customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
//						result.getString("FIRST_NAME"), result.getString("LAST_NAME"));
//
//			result = con.createStatement().executeQuery(
//					"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
//							+ customer.getId());
//
//			while (result.next()) {
//				Category category = null;
//				for (Category ca : Category.values())
//					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
//						category = ca;
//						break;
//					}
//				customer.setCouponList(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
//						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDouble("PRICE"),
//						result.getString("IMAGE")));
//			}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return customer;
	}

}
