package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Categories implements ICategoriesDAO2 {
	public void create() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate(
				"CREATE TABLE IF NOT EXISTS categories (ID INT(200) UNSIGNED NOT NULL AUTO_INCREMENT ,NAME VARCHAR(10) NOT NULL,PRIMARY KEY(ID))");
		System.out.println("The table categories has created");
	}

	public void drop() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DROP TABLE categories");
		System.out.println("The table categories is a drop");
	}

	public void insert(String Name) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("insert into categories (NAME) values ('" + Name + "')");
		System.out.println("insert categories has succeed");
	}

	public void delete(int indexToDelete) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("DELETE FROM categories WHERE ID=" + indexToDelete);
		System.out.println("delete from categories has done");
	}

	public void update(String Name, int index) throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		con.createStatement().executeUpdate("UPDATE categories SET NAME='" + Name + "' WHERE ID=" + index);
		System.out.println("update categories has done");
	}

	public void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(Program.URL, Program.USERNAME, Program.PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM categories");
		while (re.next())
			System.out.println("ID: " + re.getInt("ID") + " ,NAME: " + re.getString("NAME"));
	}

}
