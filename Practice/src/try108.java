import java.sql.*;

public class try108 {

	public static final String connection = "jdbc:derby://localhost:1527/JBDB;create=true";
	public static final String co = "org.apache.derby.jdbc.ClientDriver";

	public static void main(String[] args) {
		try {
			drop();
			create();
			insert("cat", 'm');
			insert("dor", 'm');
			insert("dog", 'f');
			insert("bird", 'f');
//			deleteByName("cat");
//			deleteAll();
			showAll();
			merge2To1();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		con.createStatement().execute(
				"create table Animals( id int not null primary key generated always as identity(start with 1 ,increment by 1),name varchar(20) ,"
						+ "type char )");
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
			System.out.println(
					"-Id: " + re.getInt("id") + " -Name: " + re.getString("name") + " -Type: " + re.getString("type"));

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

	public static void merge2To1() throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		ResultSet re = con.createStatement()
				.executeQuery("select * from Animals join Products on Animals.name=Products.name");
		while (re.next())
			System.out.println(re.getInt(1) + " " + re.getString(2) + " " + re.getString(3) + " " + re.getInt(4) + " "
					+ re.getString(5) + " " + re.getInt(6));
		re.close();
		con.close();
		
	}
}
