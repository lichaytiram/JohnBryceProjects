package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Company;
import exception.ApplicationException;
import utils.JdbcUtils;

/**
 * This class create a connection with data base ( with name companies )
 * 
 * @author Lichay
 *
 */
public class CompaniesDao implements ICompaniesDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#insert(javaBeans.Company)
	 */
	public void createCompany(Company company) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
//			while (result.next())
//				if (result.getString("EMAIL").equals(company.getEmail())
//						|| result.getString("NAME").equals(company.getName()))
//					throw new ExceptionName("The companies already exist on data base");

			preparedStatement = connection
					.prepareStatement("INSERT INTO companies (NAME,EMAIL,PASSWORD) VALUES ( ? , ? , ? )");
			extractPreparedStatement(preparedStatement, company.getName(), company.getEmail(), company.getPassword());
			preparedStatement.executeUpdate();

			System.out.println("insert companies has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#delete(int)
	 */
	public void deleteCompany(long companyId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
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
			preparedStatement = connection.prepareStatement("DELETE FROM companies WHERE ID = ?");
			preparedStatement.setLong(1, companyId);
			preparedStatement.executeUpdate();
			System.out.println("delete from company has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#update(javaBeans.Company)
	 */
	public void updateCompany(Company company) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
//			while (result.next())
//				if (result.getString("PASSWORD").equals(company.getPassword())
//						&& result.getString("EMAIL").equals(company.getEmail())
//						&& result.getString("NAME").equals(company.getName()))
//					throw new ExceptionName("The company already exist on data base");

			preparedStatement = connection
					.prepareStatement("UPDATE companies SET NAME= ? , EMAIL= ? , PASSWORD= ? WHERE ID= ? ");
			extractPreparedStatement(preparedStatement, company.getName(), company.getEmail(), company.getPassword());
			preparedStatement.setLong(4, company.getId());
			preparedStatement.executeUpdate();

			System.out.println("update companies has done");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#getAllCompany()
	 */
	@Override
	public ArrayList<Company> getAllCompany() throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Company> list = new ArrayList<>();
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies");
			preparedStatement = connection.prepareStatement("SELECT * FROM companies");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(new Company(resultSet.getLong("ID"), resultSet.getString("PASSWORD"),
						resultSet.getString("EMAIL"), resultSet.getString("NAME")));

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
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#isCompanyExists(java.lang.String, java.lang.String)
	 */
	public boolean isCompanyExists(String email, String password) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE EMAIL = ? AND PASSWORD = ?");
			extractPreparedStatement(preparedStatement, email, password);
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
	 * @see dao.ICompaniesDAO#isCompanyExists(long)
	 */
	public boolean isCompanyExists(long companyId) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE ID = ? ");
			preparedStatement.setLong(1, companyId);
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
	 * @see dao.ICompaniesDAO#getOneCompany(int)
	 */
	public Company getCompany(long companyId) throws ApplicationException {
		Connection connection = null;
		Company company = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
//			ResultSet result = con.createStatement().executeQuery("SELECT * FROM companies where id=" + companyID);
//			if (result.next())
//				company = new Company(result.getInt("ID"), result.getString("PASSWORD"), result.getString("EMAIL"),
//						result.getString("NAME"));
//
//			result = con.createStatement().executeQuery("SELECT * FROM coupons where COMPANY_ID=" + companyID);

			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE ID= ? ");
			preparedStatement.setLong(1, companyId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				company = new Company(resultSet.getInt("ID"), resultSet.getString("PASSWORD"),
						resultSet.getString("EMAIL"), resultSet.getString("NAME"));
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
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return company;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICompaniesDAO#getOneCompanyByEmailAndPassword(java.lang.String,
	 * java.lang.String)
	 */
	public Company getCompanyByEmailAndPassword(String email, String password) throws ApplicationException {
		Connection connection = null;
		Company company = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
//			preparedStatement = con.prepareStatement("SELECT * FROM companies WHERE EMAIL= ? AND PASSWORD = ?");
			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE EMAIL= ? AND PASSWORD = ?");

			extractPreparedStatement(preparedStatement, email, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				company = new Company(resultSet.getInt("ID"), resultSet.getString("PASSWORD"),
						resultSet.getString("EMAIL"), resultSet.getString("NAME"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return company;
	}

// extracts

	private PreparedStatement extractPreparedStatement(PreparedStatement preparedStatement, String email,
			String password) throws ApplicationException {
		try {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("Have a problem:\n" + e);
		}
		return preparedStatement;
	}

	private PreparedStatement extractPreparedStatement(PreparedStatement preparedStatement, String name, String email,
			String password) throws ApplicationException {
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("Have a problem:\n" + e);
		}
		return preparedStatement;
	}

}
