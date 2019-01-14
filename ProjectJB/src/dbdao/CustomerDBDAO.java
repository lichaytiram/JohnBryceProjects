package dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import BaseProgram.Customer;
import dao.ICustomersDAO;

public class CustomerDBDAO implements ICustomersDAO {

	private ConnectionPool connection = ConnectionPool.getInstance();

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

	public void insert(Customer c) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
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

	public void delete(int customerID) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("DELETE FROM customers WHERE ID=" + customerID);
			System.out.println("delete from customers has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void update(Customer c, int index) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement()
					.executeUpdate("UPDATE customers SET FIRST_NAME='" + c.getFirstName() + "',lAST_NAME='"
							+ c.getLastName() + "', EMAIL='" + c.getEmail() + "', PASSWORD='" + c.getPassword()
							+ "' WHERE ID=" + index);
			System.out.println("update customers has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void showAll() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers");
			while (re.next())
				System.out.println("ID: " + re.getInt("ID") + " ,FIRST_NAME: " + re.getString("FIRST_NAME")
						+ " ,lAST_NAME: " + re.getString("lAST_NAME") + " ,EMAIL: " + re.getString("EMAIL")
						+ " ,PASSWORD:" + re.getString("PASSWORD"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

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

	public Customer getOneCustomer(int customerID) throws Exception {
		Connection con = null;
		Customer c = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM customers where id=" + customerID);
			if (re.next())
				c = new Customer(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"),
						re.getString("FIRST_NAME"), re.getString("LAST_NAME"));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return c;
	}
}
