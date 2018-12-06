package Program1;

import java.sql.*;

public class Program {
	private static String USERNAME = "root";
	private static String PASSWORD = null;

	private final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final static String Driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		Person p1 = new Person("Moshe", 123456, 24);
		Person p2 = new Person("Omer", 123456, 18);
		Person p3 = new Person("Pool", 1243456, 34);
		try {
			Class.forName(Driver);
			create();
			insert(p1);
			insert(p2);
			insert(p3);
			delete(231);
			update(p1, 225);
//			showByAge();
			showAll();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void create() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		con.createStatement()
				.executeUpdate("CREATE TABLE IF NOT EXISTS person" + "(label int(5) not null auto_increment,"
						+ "name varchar(10) not null," + "id int(9) not null," + "age int(3) default null,"
						+ "primary key(label))");
		System.out.println("table is succeed");
	}

	public static void insert(Person p) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		con.createStatement().executeUpdate(
				"INSERT INTO person (name,id,age) values('" + p.getName() + "'," + p.getId() + "," + p.getAge() + ")");
		System.out.println("insert has done");
	}

	public static void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM person");
		while (re.next())
			System.out.println("label: " + re.getInt("label") + " ,name: " + re.getString("name") + " ,id: "
					+ re.getInt("id") + " ,age: " + re.getInt("age"));

	}

	public static void update(Person p, int label) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("start update");
		con.createStatement().executeUpdate("UPDATE person set name='" + p.getName() + "' ,id=" + p.getId() + " ,age="
				+ p.getAge() + " WHERE label = " + label);
		System.out.println("Update has done");
	}

	public static void delete(int label) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		con.createStatement().executeUpdate("DELETE FROM person WHERE label=" + label);
	}

	public static void showByAge() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM person ORDER BY age");
		while (re.next())
			System.out.println("label: " + re.getInt("label") + " ,name: " + re.getString("name") + " ,id: "
					+ re.getInt("id") + " ,age: " + re.getInt("age"));
	}

//	public static void merge2To1() throws SQLException {
//		Connection con = DriverManager.getConnection(connection);
//		ResultSet re = con.createStatement()
//				.executeQuery("select * from Animals join Products on Animals.name=Products.name");
//		while (re.next())
//			System.out.println(re.getInt(1) + " " + re.getString(2) + " " + re.getString(3) + " " + re.getInt(4) + " "
//					+ re.getString(5) + " " + re.getInt(6));
//		re.close();
//		con.close();
//		

}
