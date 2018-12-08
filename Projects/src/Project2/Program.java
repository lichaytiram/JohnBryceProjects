package Project2;

public class Program {
	public static String USERNAME = "root";
	public static String PASSWORD = null;

	public final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final static String Driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		try {
			Class.forName(Driver);

			Coupons.drop();
			Coupons.create();
			Companies.create();
			Customers.create();
			Categories.create();
			Companies.insert("omer", "Sss", "s232s");
			Companies.insert("omsr", "Sss", "s232s");
			Customers.insert("dedo", "oh", "eee", "123");
			Companies.delete(40);
			Companies.update("os", "s3", "234", 42);
			Companies.showAll();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
