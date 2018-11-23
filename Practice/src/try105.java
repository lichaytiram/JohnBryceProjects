import java.sql.*;

public class try105 {
	public static final String connection = "jdbc:derby://localhost:1527/JBDB;create=true";
//	public static final String co = "org.apache.derby.jdbc.ClientDriver";

	public static void main(String[] args) {
		System.out.println("This is DataBase");
		drop();
		create();
		insert("dor", 25);
		insert("li", 23);
		insert("noh", 84);
		insert("omer", 85);
		update("omer", "yoni", 42);
		orderByAge();
		showAll();
		showByName("dor");
		showByAge(84);

	}

	public static void create() {

		try {
			Connection con = DriverManager.getConnection(connection);
			con.createStatement().execute(
					"create table Person( id integer not null primary key generated always as identity ( start with 1, increment by 1),"
							+ " name varchar(20),age int)");
			System.out.println("The table has created");
		} catch (SQLException e) {
			System.out.println("Touch: " + e);
		}
	}

	public static void drop() {
		try {
			Connection con = DriverManager.getConnection(connection);
			con.createStatement().execute("DROP TABLE Person");
			System.out.println("DROP HAS BEEN DONE");
		} catch (SQLException e) {
			System.out.println("Problem with drop: " + e);
		}
	}

	public static void insert(String name, int age) {
		try {
			Connection con = DriverManager.getConnection(connection);
			con.createStatement().execute("insert into Person (name , age) values ('" + name + "'," + age + ")",
					PreparedStatement.RETURN_GENERATED_KEYS);
			System.out.println("insert has done");

		} catch (SQLException e) {
			System.out.println("Can't insert: " + e);
		}
	}

	public static void update(String preName, String name, int age1) {
		try {
			Connection con = DriverManager.getConnection(connection);
			con.createStatement()
					.execute("update Person set name='" + name + "', age=" + age1 + "where name='" + preName + "'");
			System.out.println("Update has done");
		} catch (SQLException e) {
			System.out.println("Cant' update: " + e);
		}
	}

	public static void showAll() {
		try {
			Connection con = DriverManager.getConnection(connection);
			ResultSet re = con.createStatement().executeQuery("select * from Person");
			while (re.next()) {
				System.out.println(
						"id:" + re.getInt("id") + ", name:" + re.getString("name") + ", age:" + re.getInt("age"));
			}
		} catch (SQLException e) {
			System.out.println("Can't show! " + e);
		}
	}

	public static void showByName(String name) {
		try {
			Connection con = DriverManager.getConnection(connection);
			ResultSet re = con.createStatement().executeQuery("select * from Person where name='" + name + "'");
			while (re.next()) {
				System.out.println("id:" + re.getInt("id") + ", name:" + re.getString("name") + ", age:"
						+ re.getInt("age") + " by name!");
			}
		} catch (SQLException e) {
			System.out.println("Can't show! " + e);
		}
	}

	public static void showByAge(int age) {
		try {
			Connection con = DriverManager.getConnection(connection);
			ResultSet re = con.createStatement().executeQuery("select * from Person where age=" + age);
			while (re.next()) {
				System.out.println("id" + re.getInt("id") + ", name:" + re.getString("name") + ", age:"
						+ re.getInt("age") + " by name!");
			}
		} catch (SQLException e) {
			System.out.println("Can't show! " + e);
		}
	}

	public static void orderByAge() {
		try {
			Connection con = DriverManager.getConnection(connection);
			ResultSet re = con.createStatement().executeQuery("select * from Person order by age desc");
			while (re.next()) {
				System.out.println("id" + re.getInt("id") + ", name:" + re.getString("name") + ", age:"
						+ re.getInt("age") + " by name!");
			}
			System.out.println("OrderByAge has done");

		} catch (SQLException e) {
			System.out.println("Can't orderByAge! " + e);
		}
	}
}
