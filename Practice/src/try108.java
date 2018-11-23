import java.sql.*;

public class try108 {

	public static final String connection = "jdbc:derby://localhost:1527/JBDB;create=true";

	public static void main(String[] args) {
		try {
//			drop();
//			create();
			insert("cat", 'm');
			insert("dog", 'f');
			deleteByName("cat");
//			deleteAll();
			showAll();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		con.createStatement().execute("create table Animals( name varchar(20) ," + "type char )");
		System.out.println("table is create!");
	}

	public static void drop() throws SQLException {

		Connection con = DriverManager.getConnection(connection);
		con.createStatement().execute("drop table Animals");
		System.out.println("Animal has droped");
	}

	public static void insert(String name, char type) throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		con.createStatement().execute("insert into Animals (name ,type) values('" + name + "','" + type + "')");
		System.out.println("insert is succeed");
	}

	public static void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		ResultSet re = con.createStatement().executeQuery("select * from Animals");
		while (re.next())
			System.out.println("-Name: " + re.getString("name") + " -Type: " + re.getString("type"));

	}

	public static void deleteByName(String val) throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		con.createStatement().execute("delete from Animals where name='" + val + "'");
	}

	public static void deleteAll() throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		con.createStatement().execute("delete from Animals");
		System.out.println("All deleted");
	}
}
