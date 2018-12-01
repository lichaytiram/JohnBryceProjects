package Program2;

import java.sql.*;

public class Program {
	public static final String connection = "jdbc:derby://localhost:1527/JBDB;create=true";
	public static final String co = "org.apache.derby.jdbc.ClientDriver";

	public static void main(String[] args) {
		Person p1 = new Person("Moshe", 123456789, 21);
		Person p2 = new Person("Gil", 4245654, 7);
		Person p3 = new Person("Omri", 397, 9);
		try {
			System.out.println("Start DB");
			drop();
			create();
			insert(p1);
			insert(p2);
			insert(p3);
			showAll();
			System.out.println("End DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// all information try 105 PracticeJava
	public static void create() throws SQLException {

		Connection con = DriverManager.getConnection(connection);
		con.createStatement()
				.execute("CREATE TABLE person"
						+ "(label int generated always as identity ( start with 1, increment by 1) not null,"
						+ "name varchar(10) not null," + "id int not null," + "age int default null)");
		System.out.println("table is succeed");

	}

	public static void drop() throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		con.createStatement().executeUpdate("DROP TABLE Person");
		System.out.println("has droped");
	}

	public static void insert(Person p) throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		con.createStatement().executeUpdate(
				"INSERT INTO person(name,id,age) values('" + p.getName() + "'," + p.getId() + "," + p.getAge() + ")");
		System.out.println("insert has been done");
	}

	public static void showAll() throws SQLException {
		Connection con = DriverManager.getConnection(connection);
		ResultSet re = con.createStatement().executeQuery("SELECT * FROM person");
		while (re.next()) {
			System.out.println("label: " + re.getInt("label") + " ,name: " + re.getString("name") + " ,id: "
					+ re.getInt("id") + " ,age: " + re.getInt("age"));
		}
	}
}
