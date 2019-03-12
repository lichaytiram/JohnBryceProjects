package dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import beans.Category;
//import beans.Company;
//import beans.Coupon;
import beans.Customer;
import dao.ICustomersDao;
//import exception.ExceptionName;

/**
 * This class create a connection with data base ( with name customers )
 * 
 * @author Lichay
 *
 */
public class CustomerDao implements ICustomersDao {

	private ConnectionPool connection = ConnectionPool.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#insert(javaBeans.Customer)
	 */
	public void insert(Customer customer) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = connection.getConnection();

//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
//			while (result.next())
//				if (result.getString("EMAIL").equals(customer.getEmail()))
//					throw new ExceptionName("The customer's EMAIL is already exist on data base");

			preparedStatement = con.prepareStatement(
					"INSERT INTO customers (FIRST_NAME,lAST_NAME,EMAIL,PASSWORD) VALUES ( ? , ? , ? , ? )");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.executeUpdate();

			System.out.println("insert customers has succeed");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			preparedStatement.close();
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#delete(long)
	 */
	public void delete(long customerID) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = connection.getConnection();
//			PreparedStatement preparedStatement1 = con
//					.prepareStatement("DELETE FROM customersVsCoupons WHERE CUSTOMER_ID = ?");
//			preparedStatement1.setLong(1, customerID);
//			preparedStatement1.executeUpdate();
			preparedStatement = con.prepareStatement("DELETE FROM customers WHERE ID = ?");
			preparedStatement.setLong(1, customerID);
			preparedStatement.executeUpdate();

			System.out.println("delete from customers has done");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			preparedStatement.close();
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#update(javaBeans.Customer)
	 */
	public void update(Customer customer) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = connection.getConnection();

//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
//			while (result.next())
//				if (result.getString("EMAIL").equals(customer.getEmail()))
//					throw new ExceptionName("The customer's EMAIL is already exist on data base");

			preparedStatement = con.prepareStatement(
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
			preparedStatement.close();
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getAllCustomer()
	 */
	@Override
	public ArrayList<Customer> getAllCustomer() throws Exception {
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			con = connection.getConnection();

			preparedStatement = con.prepareStatement("SELECT * FROM customers");
			result = preparedStatement.executeQuery();

			while (result.next()) {
				list.add(new Customer(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("FIRST_NAME"), result.getString("lAST_NAME")));
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
			preparedStatement.close();
			result.close();
			connection.restoreConnection(con);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#isCustomerExists(java.lang.String, java.lang.String)
	 */
	public boolean isCustomerExists(String email, String password) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();

			preparedStatement = con.prepareStatement("SELECT * FROM customers WHERE EMAIL = ? AND PASSWORD = ? ");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			preparedStatement.close();
			result.close();
			connection.restoreConnection(con);
		}

		return false;
	}

	public boolean isCustomerExists(long customerId) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();

			preparedStatement = con.prepareStatement("SELECT * FROM customers WHERE ID = ?");
			preparedStatement.setLong(1, customerId);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			preparedStatement.close();
			result.close();
			connection.restoreConnection(con);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getOneCustomer(int)
	 */
	public Customer getCustomer(long customerID) throws Exception {
		Customer customer = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();

			preparedStatement = con.prepareStatement("SELECT * FROM customers WHERE ID = ? ");
			preparedStatement.setLong(1, customerID);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("FIRST_NAME"), result.getString("LAST_NAME"));

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
			preparedStatement.close();
			result.close();
			connection.restoreConnection(con);
		}
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getOneCustomerByEmailAndPassword(java.lang.String,
	 * java.lang.String)
	 */
	public Customer getCustomerByEmailAndPassword(String email, String password) throws Exception {
		Customer customer = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();

			preparedStatement = con.prepareStatement("SELECT * FROM customers WHERE EMAIL = ? AND PASSWORD = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("FIRST_NAME"), result.getString("LAST_NAME"));

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
			preparedStatement.close();
			result.close();
			connection.restoreConnection(con);
		}
		return customer;
	}

}
