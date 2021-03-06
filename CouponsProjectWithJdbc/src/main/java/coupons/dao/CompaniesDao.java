package coupons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import coupons.beans.Company;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.JdbcUtils;

/**
 * This class create a connection with data base
 * 
 * @author Lichay
 *
 */
@Repository
public class CompaniesDao implements ICompaniesDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long createCompany(Company company) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement(
					"INSERT INTO companies (NAME,PHONE_NUMBER,EMAIL) VALUES ( ? , ? , ? )",
					PreparedStatement.RETURN_GENERATED_KEYS);

			// call to private function that prepared the statement
			extractPreparedStatement(preparedStatement, company.getName(), company.getPhoneNumber(),
					company.getEmail());

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				return resultSet.getLong(1);
			}

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true);

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCompany(long companyId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM companies WHERE ID = ?");
			preparedStatement.setLong(1, companyId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateCompany(Company company) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement = connection
					.prepareStatement("UPDATE companies SET NAME = ? , PHONE_NUMBER = ? , EMAIL = ? WHERE ID = ?");

			// call to private function that prepared the statement
			extractPreparedStatement(preparedStatement, company.getName(), company.getPhoneNumber(),
					company.getEmail());
			preparedStatement.setLong(4, company.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Company> getAllCompanies() throws ApplicationException {

		Company company = null;
		List<Company> list = new ArrayList<Company>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM companies");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				company = new Company(resultSet.getLong("ID"), resultSet.getString("NAME"),
						resultSet.getString("PHONE_NUMBER"), resultSet.getString("EMAIL"));

				list.add(company);

			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return list;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCompanyExists(String name) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE NAME = ?");
			preparedStatement.setString(1, name);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCompanyExists(long companyId) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE ID = ?");
			preparedStatement.setLong(1, companyId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Company getCompany(long companyId) throws ApplicationException {

		Company company = null;

		Connection connection = null;
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

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return company;

	}

	// extract

	private PreparedStatement extractPreparedStatement(PreparedStatement preparedStatement, String name,
			String phoneNumber, String email) throws ApplicationException {

		try {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phoneNumber);
			preparedStatement.setString(3, email);

		} catch (SQLException e) {

			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		}
		return preparedStatement;
	}

}
