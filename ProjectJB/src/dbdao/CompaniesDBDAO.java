package dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ICompaniesDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Company;
import javaBeans.Coupon;

/**
 * This class create a connection with data base ( with name companies )
 * 
 * @author Lichay
 *
 */
public class CompaniesDBDAO implements ICompaniesDAO {

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
					"CREATE TABLE IF NOT EXISTS companies (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,NAME VARCHAR(10) NOT NULL,"
							+ "EMAIL VARCHAR(25) NOT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
			System.out.println("The table companies has created");
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
			con.createStatement().executeUpdate("DROP TABLE companies");
			System.out.println("The table companies is a drop");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#insert(javaBeans.Company)
	 */
	public void insert(Company c) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies");
			while (re.next())
				if (re.getString("EMAIL").equals(c.getEmail()) || re.getString("NAME").equals(c.getName()))
					throw new ExceptionName("The companies already exist on data base");
			con.createStatement().executeUpdate("INSERT INTO companies (NAME,EMAIL,PASSWORD) VALUES('" + c.getName()
					+ "','" + c.getEmail() + "','" + c.getPassword() + "')");
			System.out.println("insert companies has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#delete(int)
	 */
	public void delete(int companyID) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ArrayList<Integer> couponsID = new ArrayList<Integer>();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyID);
			while (re.next())
				couponsID.add(re.getInt("ID"));
			while (!couponsID.isEmpty()) {
				con.createStatement()
						.executeUpdate("DELETE FROM customersVsCoupons WHERE COUPON_ID=" + couponsID.get(0));
				couponsID.remove(0);
			}
			con.createStatement().executeUpdate("DELETE FROM coupons WHERE COMPANY_ID=" + companyID);
			con.createStatement().executeUpdate("DELETE FROM companies WHERE ID=" + companyID);
			System.out.println("delete from company has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#update(javaBeans.Company)
	 */
	public void update(Company c) throws Exception {
		Connection con = null;

		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies");
			while (re.next())
				if (re.getString("PASSWORD").equals(c.getPassword()) && re.getString("EMAIL").equals(c.getEmail())
						&& re.getString("NAME").equals(c.getName()))
					throw new ExceptionName("The company already exist on data base");
			con.createStatement().executeUpdate("UPDATE companies SET NAME='" + c.getName() + "', EMAIL='"
					+ c.getEmail() + "', PASSWORD='" + c.getPassword() + "' WHERE ID=" + c.getId());
			System.out.println("update companies has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#getAllCompany()
	 */
	@Override
	public ArrayList<Company> getAllCompany() throws Exception {
		Connection con = null;
		ArrayList<Company> list = new ArrayList<>();
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies");
			while (re.next()) {
				Company c = new Company(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"),
						re.getString("NAME"));
				ResultSet reCouponList = con.createStatement()
						.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + c.getId());
				while (reCouponList.next()) {
					Category category = null;
					for (Category ca : Category.values())
						if (ca.ordinal() == reCouponList.getInt("CATEGORY_ID")) {
							category = ca;
							break;
						}
					Coupon coupon = new Coupon(reCouponList.getInt("ID"), reCouponList.getInt("COMPANY_ID"), category,
							reCouponList.getString("TITLE"), reCouponList.getString("DESCRIPTION"),
							reCouponList.getDate("START_DATE"), reCouponList.getDate("END_DATE"),
							reCouponList.getInt("AMOUNT"), reCouponList.getDouble("PRICE"),
							reCouponList.getString("IMAGE"));
					c.setCouponList(coupon);
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
	 * @see dao.ICompaniesDAO#isCompanyExists(java.lang.String, java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#getOneCompany(int)
	 */
	public Company getOneCompany(int companyID) throws Exception {
		Connection con = null;
		Company company = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery("SELECT * FROM companies where id=" + companyID);
			if (re.next())
				company = new Company(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"),
						re.getString("NAME"));

			re = con.createStatement().executeQuery("SELECT * FROM coupons where COMPANY_ID=" + companyID);
			while (re.next()) {
				Category category = null;
				for (Category ca : Category.values())
					if (ca.ordinal() == re.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				company.setCouponList(new Coupon(re.getInt("ID"), re.getInt("COMPANY_ID"), category,
						re.getString("TITLE"), re.getString("DESCRIPTION"), re.getDate("START_DATE"),
						re.getDate("END_DATE"), re.getInt("AMOUNT"), re.getDouble("PRICE"), re.getString("IMAGE")));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return company;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#getOneCompanyByEmailAndPassword(java.lang.String,
	 * java.lang.String)
	 */
	public Company getOneCompanyByEmailAndPassword(String email, String password) throws Exception {
		Connection con = null;
		Company company = null;
		try {
			con = connection.getConnection();
			ResultSet re = con.createStatement().executeQuery(
					"SELECT * FROM companies where EMAIL='" + email + "' AND PASSWORD='" + password + "'");
			if (re.next())
				company = new Company(re.getInt("ID"), re.getString("PASSWORD"), re.getString("EMAIL"),
						re.getString("NAME"));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return company;
	}

}
