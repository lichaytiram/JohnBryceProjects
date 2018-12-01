
public class try117 {
	public static void main(String[] args) {

		try {
			tryIt("1");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void tryIt(String temp) throws Exception {

		Integer.parseInt(temp);
		System.out.println("The name is: " + temp);
	}
}
