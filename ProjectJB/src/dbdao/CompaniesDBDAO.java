package dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import baseProgram.Company;
import dao.ICompaniesDAO;

public class CompaniesDBDAO implements ICompaniesDAO {

	private ConnectionPool connection = ConnectionPool.getInstance();

	public void create() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS companies (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,NAME VARCHAR(10) NOT NULL,"
							+ "EMAIL VARCHAR(25) NOT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
			System.out.println("The table companies has created");
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
			con.createStatement().executeUpdate("DROP TABLE companies");
			System.out.println("The table companies is a drop");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void insert(Company c) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("INSERT INTO companies (NAME,EMAIL,PASSWORD) VALUES('" + c.getName()
					+ "','" + c.getEmail() + "','" + c.getPassword() + "')");
			System.out.println("insert companies has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void delete(int indexToDelete) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("DELETE FROM companies WHERE ID=" + indexToDelete);
			System.out.println("delete from customers has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public void update(Company c, int index) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("UPDATE companies SET NAME='" + c.getName() + "', EMAIL='"
					+ c.getEmail() + "', PASSWORD='" + c.getPassword() + "' WHERE ID=" + index);
			System.out.println("update companies has done");
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
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies");
			while (re.next())
				System.out.println("ID: " + re.getInt("ID") + " ,NAME: " + re.getString("NAME") + " ,EMAIL: "
						+ re.getString("EMAIL") + " ,PASSWORD:" + re.getString("PASSWORD"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	public boolean isCompanyExists(String email, String password) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies");
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

	public Company getOneCompany(int companyID) throws Exception {
		Connection con = null;
		Company c = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies where id=" + companyID);
			if (re.next())
				c = new Company(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"), re.getString("NAME"));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return c;
	}
}
