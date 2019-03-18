package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ICreate;
import exception.ApplicationException;
import utils.JdbcUtils;

/**
 * This class is refresh all the data base (only for testing)
 * 
 * @author Lichay
 *
 */
public class RefreshDataBase implements ICreate {

	public RefreshDataBase() {

	}

	/**
	 * This function refresh all DataBase info
	 */
	public void refreshDB() {
		try {
			drop();
			create();
			System.out.println("refresh DataBase end! (delete all DB)");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICreate#create()
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
					"CREATE TABLE IF NOT EXISTS companies (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT ,NAME VARCHAR(10) NOT NULL , EMAIL VARCHAR(25) NOT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
			preparedStatement1.executeUpdate();
			System.out.println("The table companies has created");

			preparedStatement5 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS users (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT , USER_NAME VARCHAR(25) NOT NULL , PASSWORD VARCHAR(50) NOT NULL , TYPE VARCHAR(50) , COMPANY_ID BIGINT(255) UNSIGNED, PRIMARY KEY(ID) , FOREIGN KEY(COMPANY_ID) REFERENCES companies(ID))");
			preparedStatement5.executeUpdate();
			System.out.println("The table users has created");

			preparedStatement2 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS customers (ID BIGINT(255) UNSIGNED NOT NULL ,FIRST_NAME VARCHAR(10) NOT NULL,lAST_NAME VARCHAR(10) DEFAULT NULL,EMAIL VARCHAR(25) DEFAULT NULL ,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID) , FOREIGN KEY(ID) REFERENCES users(ID))");
			preparedStatement2.executeUpdate();
			System.out.println("The table customers has created");
			preparedStatement3 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS coupons (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT , COMPANY_ID BIGINT(255) UNSIGNED NOT NULL , CATEGORY VARCHAR(40) NOT NULL , TITLE  VARCHAR(25) NOT NULL, DESCRIPTION TEXT DEFAULT NULL, START_DATE DATE , END_DATE DATE , AMOUNT int(200) UNSIGNED, PRICE DOUBLE PRECISION UNSIGNED, IMAGE VARCHAR(20) , PRIMARY KEY(ID) , FOREIGN KEY(COMPANY_ID) REFERENCES companies(ID) )");
			preparedStatement3.executeUpdate();
			System.out.println("The table coupons has created");
			preparedStatement4 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS purchases (ID BIGINT(255) UNSIGNED NOT NULL AUTO_INCREMENT , CUSTOMER_ID BIGINT(255) UNSIGNED NOT NULL , COUPON_ID BIGINT(255) UNSIGNED NOT NULL , AMOUNT INT(20) UNSIGNED , PRIMARY KEY(ID), FOREIGN KEY(CUSTOMER_ID) REFERENCES customers(ID), FOREIGN KEY(COUPON_ID) REFERENCES coupons(ID))");
			preparedStatement4.executeUpdate();
			System.out.println("The table purchases has created");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement1, preparedStatement2, preparedStatement3,
					preparedStatement4, preparedStatement5);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICreate#drop()
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


			preparedStatement1 = connection.prepareStatement("DROP TABLE purchases");
			preparedStatement1.executeUpdate();
			System.out.println("The table purchases is a drop");
			preparedStatement3 = connection.prepareStatement("DROP TABLE coupons");
			preparedStatement3.executeUpdate();
			System.out.println("The table coupons is a drop");
			preparedStatement2 = connection.prepareStatement("DROP TABLE customers");
			preparedStatement2.executeUpdate();
			System.out.println("The table customers is a drop");
			preparedStatement5 = connection.prepareStatement("DROP TABLE users");
			preparedStatement5.executeUpdate();
			System.out.println("The table users is a drop");
			preparedStatement4 = connection.prepareStatement("DROP TABLE companies");
			preparedStatement4.executeUpdate();
			System.out.println("The table companies is a drop");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			JdbcUtils.closeResources(connection, preparedStatement1, preparedStatement2, preparedStatement3,
					preparedStatement4, preparedStatement5);
		}
	}
}
