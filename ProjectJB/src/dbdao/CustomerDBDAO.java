package dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ICustomersDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Coupon;
import javaBeans.Customer;

/**
 * This class create a connection with data base ( with name customers )
 * 
 * @author Lichay
 *
 */
public class CustomerDBDAO implements ICustomersDAO {

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
	public void insert(Customer c) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();

			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers");
			while (re.next())
				if (re.getString("EMAIL").equals(c.getEmail()))
					throw new ExceptionName("The customer's EMAIL is already exist on data base");

			con.createStatement().executeUpdate(
					"insert into customers (FIRST_NAME,lAST_NAME,EMAIL,PASSWORD) values ('" + c.getFirstName() + "','"
							+ c.getLastName() + "','" + c.getEmail() + "','" + c.getPassword() + "')");
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
			con.createStatement().executeUpdate("DELETE FROM customersVsCoupons WHERE CUSTOMER_ID=" + customerID);
			con.createStatement().executeUpdate("DELETE FROM customers WHERE ID=" + customerID);
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
	public void update(Customer c) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();

			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers");
			while (re.next())
				if (re.getString("EMAIL").equals(c.getEmail()))
					throw new ExceptionName("The customer's EMAIL is already exist on data base");

			con.createStatement()
					.executeUpdate("UPDATE customers SET FIRST_NAME='" + c.getFirstName() + "',lAST_NAME='"
							+ c.getLastName() + "', EMAIL='" + c.getEmail() + "', PASSWORD='" + c.getPassword()
							+ "' WHERE ID=" + c.getId());
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
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers");
			while (re.next()) {
				Customer c = new Customer(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"),
						re.getString("FIRST_NAME"), re.getString("lAST_NAME"));

				ResultSet addCoupons = con.createStatement().executeQuery(
						"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
								+ c.getId());
				while (addCoupons.next()) {
					Category category = null;
					for (Category ca : Category.values())
						if (ca.ordinal() == addCoupons.getInt("CATEGORY_ID")) {
							category = ca;
							break;
						}
					c.setCouponList(new Coupon(addCoupons.getInt("ID"), addCoupons.getInt("COMPANY_ID"), category,
							addCoupons.getString("TITLE"), addCoupons.getString("DESCRIPTION"),
							addCoupons.getDouble("PRICE"), addCoupons.getString("IMAGE")));
				}

				list.add(c);
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
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers");
			while (re.next()) {
				if (re.getString("EMAIL").equals(email) && re.getString("PASSWORD").equals(password))
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
		Customer c = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers WHERE ID=" + customerID);
			if (re.next())
				c = new Customer(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"),
						re.getString("FIRST_NAME"), re.getString("LAST_NAME"));
			re = con.createStatement().executeQuery(
					"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
							+ customerID);
			while (re.next()) {
				Category category = null;
				for (Category ca : Category.values())
					if (ca.ordinal() == re.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				c.setCouponList(new Coupon(re.getInt("ID"), re.getInt("COMPANY_ID"), category, re.getString("TITLE"),
						re.getString("DESCRIPTION"), re.getDouble("PRICE"), re.getString("IMAGE")));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICustomersDAO#getOneCustomerByEmailAndPassword(java.lang.String,
	 * java.lang.String)
	 */
	public Customer getOneCustomerByEmailAndPassword(String email, String password) throws Exception {
		Connection con = null;
		Customer c = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery(
					"SELECT * FROM customers where email='" + email + "' AND PASSWORD='" + password + "'");
			if (re.next())
				c = new Customer(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"),
						re.getString("FIRST_NAME"), re.getString("LAST_NAME"));

			re = con.createStatement().executeQuery(
					"SELECT * FROM customersvscoupons JOIN coupons ON coupons.id = customersvscoupons.COUPON_ID WHERE customersvscoupons.CUSTOMER_ID="
							+ c.getId());

			while (re.next()) {
				Category category = null;
				for (Category ca : Category.values())
					if (ca.ordinal() == re.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				c.setCouponList(new Coupon(re.getInt("ID"), re.getInt("COMPANY_ID"), category, re.getString("TITLE"),
						re.getString("DESCRIPTION"), re.getDouble("PRICE"), re.getString("IMAGE")));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return c;
	}

}
