import java.sql.*;

public class try104 {

	public static void main(String[] args) {

		try {

			// ����� ��'���� ����� �� ������� �� ����
			// ������ ��� ������ �������� ���� �������
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			buildDB();

			insert("Apple", 3.5);
			insert("Banana", 4.7);
			insert("Peach", 3.2);
			insert("Orange", 5.2);
			insert("Grapes", 7.3);

			update(4, "Blueberry", 10.7);

			delete(5);
			delete(700);

			readAll();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}

	}

	// ������ ������ ���� ��� ������� ����:
	private static String connectionString = "jdbc:derby://localhost:1527/JBDB;create=true";

	// -------------------------����� ����-----------------------------
	public static void buildDB() {

		// If JohnBryceDB already exist, there will be an exception.
		// Do nothing in the catch.
		try {

			// Create a connection to the database:
			Connection connection = DriverManager.getConnection(connectionString);

			// ����� ������� ���� ������ �����
			String sql = "create table Products ("
					+ "id integer not null primary key generated always as identity(start with 1, increment by 1), "
					+ "name varchar(50) not null, " + "price double not null)";

			// ������� ����� ����� ������ �� ��� �������
			Statement statement = connection.createStatement();

			// ��� �� ������� ��"�
			statement.executeUpdate(sql);

			System.out.println("Products table has been created.");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// -------------------------����� ������ �����-----------------------------
	public static void insert(String name, double price) throws SQLException {

		// Create a connection:
		Connection connection = DriverManager.getConnection(connectionString);

		// Create sql statement:
		String sql = String.format("insert into Products(name, price) values('%s', %.2f)", name, price);

		// Create object which can execute the above sql and return the new id:
		PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

		// Execute (the insert command):
		preparedStatement.executeUpdate();

		// Retrieves any auto-generated keys created as a result of executing this
		// Statement object (returns ResultSet)
		ResultSet resultSet = preparedStatement.getGeneratedKeys();

		resultSet.next();

		int id = resultSet.getInt(1);

		System.out.println("Insert succeeded. New create id: " + id);
	}

	// -------------------------����� ������ ������-----------------------------
	public static void readAll() throws SQLException {

		// Create a connection:
		Connection connection = DriverManager.getConnection(connectionString);

		// Create a statement object which can read data:
		Statement statement = connection.createStatement();

		// Create sql statement for reading data:
		String sql = "select * from Products";

		// Execute the query and return an object which contains the data (the table):
		ResultSet resultSet = statement.executeQuery(sql);

		// loop over the rows in the ResultSet
		// next() - Moves the cursor forward one row from its current position - returns
		// true if the new current row is valid; false if there are no more rows
		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			double price = resultSet.getDouble("price");

			System.out.println("id: " + id + ", name: " + name + ", price: " + price);
		}
	}

	// -------------------------������ ������ �����-----------------------------
	public static void update(int id, String name, double price) throws SQLException {

		// Create a connection:
		Connection connection = DriverManager.getConnection(connectionString);

		// Create an update sql statement:
		String sql = String.format("update Products set name='%s', price=%.2f where id=%d", name, price, id);

		// Create an object for executing the above sql:
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.executeUpdate();

		System.out.println("Update succeeded.");
	}

	// -------------------------����� ������ ������-----------------------------
	public static void delete(int id) throws SQLException {

		// Create a connection:
		Connection connection = DriverManager.getConnection(connectionString);

		// Create sql command for delete one record:
		String sql = String.format("delete from Products where id=%d", id);

		// Create an object for executing the above command:
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// Execute:
		preparedStatement.executeUpdate();

		System.out.println("Delete succeeded.");
	}

}
