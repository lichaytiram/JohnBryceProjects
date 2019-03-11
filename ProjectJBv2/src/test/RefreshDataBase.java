package test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ICreate;
import dbdao.ConnectionPool;

/**
 * This class is refresh all the data base (only for testing)
 * 
 * @author Lichay
 *
 */
public class RefreshDataBase implements ICreate {
	private ConnectionPool connection = ConnectionPool.getInstance();

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
	public void create() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS companies (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,NAME VARCHAR(10) NOT NULL,"
							+ "EMAIL VARCHAR(25) NOT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
			System.out.println("The table companies has created");

			con.createStatement()
					.executeUpdate("CREATE TABLE IF NOT EXISTS coupons (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,"
							+ " COMPANY_ID int(10) UNSIGNED NOT NULL ," + " CATEGORY_ID int(10) UNSIGNED NOT NULL ,"
							+ " TITLE  VARCHAR(25) NOT NULL, DESCRIPTION TEXT DEFAULT NULL, START_DATE TIMESTAMP ,"
							+ " END_DATE TIMESTAMP , AMOUNT int(200) UNSIGNED, PRICE DOUBLE PRECISION UNSIGNED, IMAGE VARCHAR(20) , PRIMARY KEY(ID) ,"
							+ " FOREIGN KEY(COMPANY_ID) REFERENCES companies(ID) )");
			System.out.println("The table coupons has created");

			con.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS customers (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,FIRST_NAME VARCHAR(10) NOT NULL,lAST_NAME VARCHAR(10) DEFAULT NULL,EMAIL VARCHAR(25) DEFAULT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
			System.out.println("The table customers has created");

			con.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS customersVsCoupons (CUSTOMER_ID INT(200) UNSIGNED NOT NULL ,"
							+ "COUPON_ID INT(200) UNSIGNED NOT NULL ," + "PRIMARY KEY(CUSTOMER_ID,COUPON_ID),"
							+ "FOREIGN KEY(CUSTOMER_ID) REFERENCES customers(ID),"
							+ "FOREIGN KEY(COUPON_ID) REFERENCES coupons(ID))");
			System.out.println("The table customersVsCoupons has created");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.ICreate#drop()
	 */
	public void drop() throws Exception {
		Connection con = null;
		try {
			con = connection.getConnection();
			con.createStatement().executeUpdate("DROP TABLE customersVsCoupons");
			System.out.println("The table customersVsCoupons is a drop");

			con.createStatement().executeUpdate("DROP TABLE customers");
			System.out.println("The table customers is a drop");

			con.createStatement().executeUpdate("DROP TABLE coupons");
			System.out.println("The table coupons is a drop");

			con.createStatement().executeUpdate("DROP TABLE companies");
			System.out.println("The table companies is a drop");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			connection.restoreConnection(con);
		}
	}
}
