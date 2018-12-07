package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Customers {
	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"CREATE TABLE IF NOT EXISTS customers (ID INT(255) NOT NULL AUTO_INCREMENT ,FIRST_NAME VARCHAR(10) NOT NULL,lAST_NAME VARCHAR(10) DEFAULT NULL,EMAIL VARCHAR(25) DEFAULT NULL,PASSWORD VARCHAR(50) NOT NULL,PRIMARY KEY(ID))");
		System.out.println("The table Customers has created");
	}
}
