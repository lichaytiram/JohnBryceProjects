package dbdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import beans.Category;
import beans.Company;
//import beans.Coupon;
import dao.ICompaniesDao;
//import exception.ExceptionName;

/**
 * This class create a connection with data base ( with name companies )
 * 
 * @author Lichay
 *
 */
public class CompaniesDao implements ICompaniesDao {

	private ConnectionPool connection = ConnectionPool.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#insert(javaBeans.Company)
	 */
	public void insert(Company company) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = connection.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
//			while (result.next())
//				if (result.getString("EMAIL").equals(company.getEmail())
//						|| result.getString("NAME").equals(company.getName()))
//					throw new ExceptionName("The companies already exist on data base");

			preparedStatement = con
					.prepareStatement("INSERT INTO companies (NAME,EMAIL,PASSWORD) VALUES ( ? , ? , ? )");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.executeUpdate();

			System.out.println("insert companies has done");
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
	 * @see dao.ICompaniesDAO#delete(int)
	 */
	public void delete(long companyID) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = connection.getConnection();
//			ArrayList<Integer> couponsID = new ArrayList<Integer>();
//			ResultSet result = con.createStatement()
//					.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + companyID);
//			while (result.next())
//				couponsID.add(result.getInt("ID"));
//			while (!couponsID.isEmpty()) {
//
//				PreparedStatement preparedStatement1 = con
//						.prepareStatement("DELETE FROM customersVsCoupons WHERE COUPON_ID = ?");
//				preparedStatement1.setInt(1, couponsID.get(0));
//				preparedStatement1.executeUpdate();
//				couponsID.remove(0);
//			}
//			PreparedStatement preparedStatement2 = con.prepareStatement("DELETE FROM coupons WHERE COMPANY_ID = ?");
//			preparedStatement2.setLong(1, companyID);
//			preparedStatement2.executeUpdate();
			preparedStatement = con.prepareStatement("DELETE FROM companies WHERE ID = ?");
			preparedStatement.setLong(1, companyID);
			preparedStatement.executeUpdate();
			System.out.println("delete from company has done");
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
	 * @see dao.ICompaniesDAO#update(javaBeans.Company)
	 */
	public void update(Company company) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = connection.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
//			while (result.next())
//				if (result.getString("PASSWORD").equals(company.getPassword())
//						&& result.getString("EMAIL").equals(company.getEmail())
//						&& result.getString("NAME").equals(company.getName()))
//					throw new ExceptionName("The company already exist on data base");

			preparedStatement = con
					.prepareStatement("UPDATE companies SET NAME= ? , EMAIL= ? , PASSWORD= ? WHERE ID= ? ");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.setLong(4, company.getId());
			preparedStatement.executeUpdate();

			System.out.println("update companies has done");
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
	 * @see dao.ICompaniesDAO#getAllCompany()
	 */
	@Override
	public ArrayList<Company> getAllCompany() throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Company> list = new ArrayList<>();
		ResultSet result = null;
		try {
			con = connection.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
			preparedStatement = con.prepareStatement("SELECT * FROM companies");
			result = preparedStatement.executeQuery();

			while (result.next()) {
				list.add(new Company(result.getLong("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("NAME")));

//				Company company = new Company(result.getInt("ID"), result.getString("PASSWORD"),
//						result.getString("EMAIL"), result.getString("NAME"));
//				ResultSet reCouponList = con.createStatement()
//						.executeQuery("SELECT * FROM coupons WHERE COMPANY_ID=" + company.getId());
//				while (reCouponList.next()) {
//					Category category = null;
//					for (Category tempCategory: Category.values())
//						if (tempCategory.ordinal() == reCouponList.getInt("CATEGORY_ID")) {
//							category = tempCategory;
//							break;
//						}
//					Coupon coupon = new Coupon(reCouponList.getInt("ID"), reCouponList.getInt("COMPANY_ID"), category,
//							reCouponList.getString("TITLE"), reCouponList.getString("DESCRIPTION"),
//							reCouponList.getDate("START_DATE"), reCouponList.getDate("END_DATE"),
//							reCouponList.getInt("AMOUNT"), reCouponList.getDouble("PRICE"),
//							reCouponList.getString("IMAGE"));
//					company.setCouponList(coupon);
//				}
//				list.add(company);
			}

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
	 * @see dao.ICompaniesDAO#isCompanyExists(java.lang.String, java.lang.String)
	 */
	public boolean isCompanyExists(String email, String password) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();
			preparedStatement = con.prepareStatement("SELECT * FROM companies WHERE EMAIL = ? AND PASSWORD = ?");
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies WHERE EMAIL = ? AND PASSWORD = ?");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#isCompanyExists(long)
	 */
	public boolean isCompanyExists(long companyId) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();
			preparedStatement = con.prepareStatement("SELECT * FROM companies WHERE ID = ? ");
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies WHERE EMAIL = ? AND PASSWORD = ?");
			preparedStatement.setLong(1, companyId);
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
	 * @see dao.ICompaniesDAO#getOneCompany(int)
	 */
	public Company getCompany(long companyID) throws Exception {
		Connection con = null;
		Company company = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies where id=" + companyID);
//			if (result.next())
//				company = new Company(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
//						result.getString("NAME"));
//
//			result = con.createStatement().executeQuery("SELECT * FROM coupons where COMPANY_ID=" + companyID);

			preparedStatement = con.prepareStatement("SELECT * FROM companies WHERE ID= ? ");
			preparedStatement.setLong(1, companyID);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				company = new Company(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("NAME"));
//				Category category = null;
//				for (Category ca : Category.values())
//					if (ca.ordinal() == result.getInt("CATEGORY_ID")) {
//						category = ca;
//						break;
//					}
//				company.setCouponList(new Coupon(result.getInt("ID"), result.getInt("COMPANY_ID"), category,
//						result.getString("TITLE"), result.getString("DESCRIPTION"), result.getDate("START_DATE"),
//						result.getDate("END_DATE"), result.getInt("AMOUNT"), result.getDouble("PRICE"),
//						result.getString("IMAGE")));
//				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			preparedStatement.close();
			result.close();
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
	public Company getCompanyByEmailAndPassword(String email, String password) throws Exception {
		Connection con = null;
		Company company = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			con = connection.getConnection();
//			preparedStatement = con.prepareStatement("SELECT * FROM companies WHERE EMAIL= ? AND PASSWORD = ?");
			preparedStatement = getQuery("SELECT * FROM companies WHERE EMAIL= ? AND PASSWORD = ?");

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				company = new Company(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
						result.getString("NAME"));

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			preparedStatement.close();
			result.close();
			connection.restoreConnection(con);
		}
		return company;
	}

	public PreparedStatement getQuery(String query) throws Exception {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = connection.getConnection();
			preparedStatement = con.prepareStatement(query);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}

		return preparedStatement;
	}

}
