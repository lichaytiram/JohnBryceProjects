package dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Category;
import beans.Company;
import beans.Coupon;
import dao.ICompaniesDao;
import exception.ExceptionName;

/**
 * This class create a connection with data base ( with name companies )
 * 
 * @author Lichay
 *
 */
public class CompaniesDBDAO implements ICompaniesDao {

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
	public void insert(Company company) throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
			while (result.next())
				if (result.getString("EMAIL").equals(company.getEmail())
						|| result.getString("NAME").equals(company.getName()))
					throw new ExceptionName("The companies already exist on data base");

			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO companies (NAME,EMAIL,PASSWORD) VALUES ( ? , ? , ? )");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.executeUpdate();

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
			ResultSet result = con.createStatement()
					.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyID);
			while (result.next())
				couponsID.add(result.getInt("ID"));
			while (!couponsID.isEmpty()) {

				PreparedStatement preparedStatement1 = con
						.prepareStatement("DELETE FROM customersVsCoupons WHERE COUPON_ID = ?");
				preparedStatement1.setInt(1, couponsID.get(0));
				preparedStatement1.executeUpdate();
				couponsID.remove(0);
			}
			PreparedStatement preparedStatement2 = con.prepareStatement("DELETE FROM coupons WHERE COMPANY_ID = ?");
			preparedStatement2.setInt(1, companyID);
			preparedStatement2.executeUpdate();
			PreparedStatement preparedStatement3 = con.prepareStatement("DELETE FROM companies WHERE ID= ?");
			preparedStatement3.setInt(1, companyID);
			preparedStatement3.executeUpdate();
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
	public void update(Company company) throws Exception {
		Connection con = null;

		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
			while (result.next())
				if (result.getString("PASSWORD").equals(company.getPassword())
						&& result.getString("EMAIL").equals(company.getEmail())
						&& result.getString("NAME").equals(company.getName()))
					throw new ExceptionName("The company already exist on data base");

			PreparedStatement preparedStatement = con
					.prepareStatement("UPDATE companies SET NAME=? , EMAIL=? , PASSWORD=? WHERE ID=? ");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.setInt(4, company.getId());
			preparedStatement.executeUpdate();

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
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
			while (result.next()) {
				Company company = new Company(result.getInt("ID"), result.getString("PASSWORD"),
						result.getString("EMAIL"), result.getString("NAME"));
				ResultSet reCouponList = con.createStatement()
						.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + company.getId());
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
					company.setCouponList(coupon);
				}
				list.add(company);
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
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
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
	 * @see dao.ICompaniesDAO#getOneCompany(int)
	 */
	public Company getOneCompany(int companyID) throws Exception {
		Connection con = null;
		Company company = null;
		try {
			con = connection.getConnection();
			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies where id=" + companyID);
			if (result.next())
				company = new Company(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("NAME"));

			result = con.createStatement().executeQuery("SELECT * FROM coupons where COMPANY_ID=" + companyID);
			while (result.next()) {
				Category category = null;
				for (Category ca : Category.values())
					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
						category = ca;
						break;
					}
				company.setCouponList(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
						result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
						result.getString("IMAGE")));
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
			ResultSet result = con.createStatement().executeQuery(
					"SELECT * FROM companies where EMAIL='" + email + "' AND PASSWORD='" + password + "'");
			if (result.next())
				company = new Company(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("NAME"));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
		return company;
	}

}
