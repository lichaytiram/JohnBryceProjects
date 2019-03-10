package dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Category;
import beans.Coupon;
import beans.Customer;
import dao.ICustomersDao;
import exception.ExceptionName;

/**
 * This class create a connection with data base ( with name customers )
 * 
 * @author Lichay
 *
 */
public class CustomerDBDAO implements ICustomersDao {

	private ConnectionPool connection = ConnectionPool.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IMainDAO#create()
	 */
	public void create() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS customers (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,FIRST_NAME VARCHAR(10) NOT NULL,lAST_NAME VARCHAR(10) DEFAULT NULL,EMAIL VARCHAR(25) DEFAULT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
			System.out.println("The table customers has created");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IMainDAO#drop()
	 */
	public void drop() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("DROP TABLE customers");
			System.out.println("The table customers is a drop");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#insert(javaBeans.Customer)
	 */
	public void insert(Customer customer) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();

			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
			while (result.next())
				if (result.getString("EMAIL").equals(customer.getEmail()))
					throw new ExceptionName("The customer's EMAIL is already exist on data base");
			PreparedStatement preparedStatement = con.prepareStatement(
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
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#delete(int)
	 */
	public void delete(int customerID) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			PreparedStatement preparedStatement1 = con
					.prepareStatement("DELETE FROM customersVsCoupons WHERE CUSTOMER_ID = ?");
			preparedStatement1.setInt(1, customerID);
			preparedStatement1.executeUpdate();
			PreparedStatement preparedStatement2 = con.prepareStatement("DELETE FROM customers WHERE ID = ?");
			preparedStatement2.setInt(1, customerID);
			preparedStatement2.executeUpdate();

			System.out.println("delete from customers has done");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
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
		try {
			con = connection.getConnection();

			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
			while (result.next())
				if (result.getString("EMAIL").equals(customer.getEmail()))
					throw new ExceptionName("The customer's EMAIL is already exist on data base");

			PreparedStatement preparedStatement = con.prepareStatement(
					"UPDATE customers SET FIRST_NAME=? , lAST_NAME=? , EMAIL=? , PASSWORD=? WHERE ID=? ");
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setInt(5, customer.getId());
			preparedStatement.executeUpdate();

			System.out.println("update customers has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
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
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
			while (result.next()) {
				Customer customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"),
						result.getString("EMAIL"), result.getString("FIRST_NAME"), result.getString("lAST_NAME"));

				ResultSet addCoupons = con.createStatement().executeQuery(
						"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
								+ customer.getId());
				while (addCoupons.next()) {
					Category category = null;
					for (Category ca : Category.values())
						if (ca.ordinal() == addCoupons.getInt("CATEGORY_ID")) {
							category = ca;
							break;
						}
					customer.setCouponList(new Coupon(addCoupons.getInt("ID"), addCoupons.getInt("COMPANY_ID"),
							category, addCoupons.getString("TITLE"), addCoupons.getString("DESCRIPTION"),
							addCoupons.getDouble("PRICE"), addCoupons.getString("IMAGE")));
				}

				list.add(customer);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
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
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers");
			while (result.next()) {
				if (result.getString("EMAIL").equals(email) && result.getString("PASSWORD").equals(password))
					return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getOneCustomer(int)
	 */
	public Customer getOneCustomer(int customerID) throws Exception {
		Connection con = null;
		Customer customer = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM customers WHERE ID=" + customerID);
			if (result.next())
				customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("FIRST_NAME"), result.getString("LAST_NAME"));
			result = con.createStatement().executeQuery(
					"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
							+ customerID);
			while (result.next()) {
				Category category = null;
				for (Category ca : Category.values())
					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				customer.setCouponList(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDouble("PRICE"),
						result.getString("IMAGE")));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
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
	public Customer getOneCustomerByEmailAndPassword(String email, String password) throws Exception {
		Connection con = null;
		Customer customer = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery(
					"SELECT * FROM customers where email='" + email + "' AND PASSWORD='" + password + "'");
			if (result.next())
				customer = new Customer(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("FIRST_NAME"), result.getString("LAST_NAME"));

			result = con.createStatement().executeQuery(
					"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
							+ customer.getId());

			while (result.next()) {
				Category category = null;
				for (Category ca : Category.values())
					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				customer.setCouponList(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDouble("PRICE"),
						result.getString("IMAGE")));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return customer;
	}

}
