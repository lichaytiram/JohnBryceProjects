package coupons.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import coupons.dao.ICreate;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.JdbcUtils;

/**
 * This class is refresh all the data base (only for testing)
 * 
 * @author Lichay
 *
 */
@Repository
public class RefreshDataBase implements ICreate {

	public RefreshDataBase() throws ApplicationException {
		super();
//		refreshDB();
	}

	/**
	 * This function refresh all data base info
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void refreshDB() throws ApplicationException {

		try {

			drop();
			create();
			System.out.println("refresh DataBase end!");

		} catch (Exception e) {

			e.printStackTrace();
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		}

	}

	/**
	 * This function create tables
	 */
	public void create() throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		PreparedStatement preparedStatement4 = null;
		PreparedStatement preparedStatement5 = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement1 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS companies (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT ,NAME VARCHAR(10) NOT NULL ,PHONE_NUMBER VARCHAR(10) NOT NULL , EMAIL VARCHAR(25) NOT NULL ,PRIMARY KEY(ID))");
			preparedStatement1.executeUpdate();

			preparedStatement2 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS users (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT , USER_NAME VARCHAR(25) NOT NULL , PASSWORD VARCHAR(50) NOT NULL , TYPE VARCHAR(50) NOT NULL, COMPANY_ID BIGINT(255) UNSIGNED , PRIMARY KEY(ID) , FOREIGN KEY(COMPANY_ID) REFERENCES companies(ID))");
			preparedStatement2.executeUpdate();

			preparedStatement3 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS customers (ID BIGINT(255) UNSIGNED NOT NULL ,FIRST_NAME VARCHAR(20) NOT NULL,LAST_NAME VARCHAR(20) DEFAULT NULL ,PHONE_NUMBER VARCHAR(10) NOT NULL ,EMAIL VARCHAR(25) NOT NULL ,PRIMARY KEY(ID) , FOREIGN KEY(ID) REFERENCES users(ID))");
			preparedStatement3.executeUpdate();

			preparedStatement4 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS coupons (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT , COMPANY_ID BIGINT(255) UNSIGNED NOT NULL , CATEGORY VARCHAR(40) NOT NULL , TITLE  VARCHAR(25) NOT NULL, DESCRIPTION TEXT DEFAULT NULL, START_DATE DATE NOT NULL, END_DATE DATE NOT NULL, AMOUNT INT(200) UNSIGNED NOT NULL, PRICE DOUBLE PRECISION UNSIGNED NOT NULL, IMAGE VARCHAR(50) DEFAULT NULL, PRIMARY KEY(ID) , FOREIGN KEY(COMPANY_ID) REFERENCES companies(ID) )");
			preparedStatement4.executeUpdate();

			preparedStatement5 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS purchases (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT , CUSTOMER_ID BIGINT(255) UNSIGNED NOT NULL , COUPON_ID BIGINT(255) UNSIGNED NOT NULL , AMOUNT INT(20) UNSIGNED NOT NULL, DATE DATE NOT NULL , PRIMARY KEY(ID), FOREIGN KEY(CUSTOMER_ID) REFERENCES customers(ID), FOREIGN KEY(COUPON_ID) REFERENCES coupons(ID))");
			preparedStatement5.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement1, preparedStatement2, preparedStatement3,
					preparedStatement4, preparedStatement5);
		}

	}

	/**
	 * This function drop tables
	 */
	public void drop() throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		PreparedStatement preparedStatement4 = null;
		PreparedStatement preparedStatement5 = null;

		try {
			connection = JdbcUtils.getConnection();

			preparedStatement1 = connection.prepareStatement("DROP TABLE IF EXISTS purchases");
			preparedStatement1.executeUpdate();

			preparedStatement2 = connection.prepareStatement("DROP TABLE IF EXISTS coupons");
			preparedStatement2.executeUpdate();

			preparedStatement3 = connection.prepareStatement("DROP TABLE IF EXISTS customers");
			preparedStatement3.executeUpdate();

			preparedStatement4 = connection.prepareStatement("DROP TABLE IF EXISTS users");
			preparedStatement4.executeUpdate();

			preparedStatement5 = connection.prepareStatement("DROP TABLE IF EXISTS companies");
			preparedStatement5.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true, e);

		} finally {
			JdbcUtils.closeResources(connection, preparedStatement1, preparedStatement2, preparedStatement3,
					preparedStatement4, preparedStatement5);
		}

	}
}
