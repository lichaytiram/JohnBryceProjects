package Day18_11_2018_DataBase;

import java.sql.*;

public class Program {
	public static void main(String[] args) {

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
//			drop();
			make();
			insert("moshe", 21.6);
			insert("dima", 23);
			update(7, "davidovzki", 12);
			delete(3);
			delete(10);
			readAll();

			System.out.println("--------------------");
//			read(4);

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	private static String connectionString = "jdbc:derby://localhost:1527/JBDB;create=true";

	public static void drop() {
		try {
			Connection connection = DriverManager.getConnection(connectionString);
			String sql = "drop table Students";

			Statement statment = connection.createStatement();
			statment.executeUpdate(sql);
			System.out.println("Students table has been drop.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// if not exist
	public static void make() {
		try {
			Connection connection = DriverManager.getConnection(connectionString);
			String sql = "create table Students"
					+ "(id integer not null primary key generated always as identity(start with 1, increment by 1), "
					+ "name varchar(20) not null, " + "age double not null)";

			Statement statment = connection.createStatement();
			System.out.println("Produce in progress");
			statment.executeUpdate(sql);
			System.out.println("Produce table has been created.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void insert(String name, double age) throws SQLException {
		Connection connection = DriverManager.getConnection(connectionString);
		String sql = String.format("insert into Students(name, age) values('%s',%.3f)", name, age);
		PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		resultSet.next();
		int id = resultSet.getInt(1);
		System.out.println("Insert succeeded. New create id: " + id);
	}

	public static void readAll() throws SQLException {

		Connection connection = DriverManager.getConnection(connectionString);
		Statement statment = connection.createStatement();
		String sql = "select * from Students";

		ResultSet resultSet = statment.executeQuery(sql);

		while (resultSet.next()) {
			System.out.println("id: " + resultSet.getInt("id") + ", name: " + resultSet.getString("name") + ", age: "
					+ resultSet.getDouble("age"));
		}
	}

	public static void read(int index) throws SQLException {
		Connection connection = DriverManager.getConnection(connectionString);
		Statement statement = connection.createStatement();
		String sql = "select * from Students where id=index";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next())
			System.out.println(resultSet);
	}

	public static void update(int id, String name, double age) throws SQLException {
		Connection connection = DriverManager.getConnection(connectionString);

		String sql = String.format("update Students set name='%s' , age=%.3f where id=%d", name, age, id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("update is done!");

	}

	public static void delete(int id) throws SQLException {
		Connection connection = DriverManager.getConnection(connectionString);
		String sql = String.format("delete from Students where id=%d", id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("delete is done!");
	}
}
