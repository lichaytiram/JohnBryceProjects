package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Company;
import enums.ProblemsException;
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

			preparedStatement = connection
					.prepareStatement("INSERT INTO companies (NAME,PHONE_NUMBER,EMAIL) VALUES ( ? , ? , ? )");
			extractPreparedStatement(preparedStatement, company.getName(), company.getPhoneNumber(),
					company.getEmail());
			preparedStatement.executeUpdate();

			System.out.println("insert companies has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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

			preparedStatement = connection.prepareStatement("DELETE FROM companies WHERE ID = ?");
			preparedStatement.setLong(1, companyId);
			preparedStatement.executeUpdate();
			System.out.println("delete from company has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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

			preparedStatement = connection
					.prepareStatement("UPDATE companies SET NAME= ? , PHONE_NUMBER= ? , EMAIL= ?  WHERE ID= ? ");
			extractPreparedStatement(preparedStatement, company.getName(), company.getPhoneNumber(),
					company.getEmail());
			preparedStatement.setLong(4, company.getId());
			preparedStatement.executeUpdate();

			System.out.println("update companies has done");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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
	public List<Company> getAllCompany() throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Company> list = new ArrayList<>();
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM companies");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(new Company(resultSet.getLong("ID"), resultSet.getString("NAME"),
						resultSet.getString("PHONE_NUMBER"), resultSet.getString("EMAIL")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;
	}

	public boolean isCompanyExists(String name) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE NAME = ? ");
			preparedStatement.setString(1, name);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
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

			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE ID = ?");
			preparedStatement.setLong(1, companyId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				company = new Company(resultSet.getInt("ID"), resultSet.getString("NAME"),
						resultSet.getString("PHONE_NUMBER"), resultSet.getString("EMAIL"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return company;
	}

// extracts

	private PreparedStatement extractPreparedStatement(PreparedStatement preparedStatement, String name,
			String phoneNumber, String email) throws ApplicationException {
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phoneNumber);
			preparedStatement.setString(3, email);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(ProblemsException.problem.getName() + e);
		}
		return preparedStatement;
	}

}
