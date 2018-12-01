import java.util.Arrays;

public class try77 {
	public static void main(String[] args) {
		String s = "abcdecfghcijk";
		System.out.println(s.indexOf('c', 2));
		System.out.println(s.indexOf('c'));
		System.out.println(s.lastIndexOf('c', 8));

		System.out.println(s.lastIndexOf('c', 8));
		String[][] s1 = new String[5][]; // check?
		System.out.println(s1);
		System.out.println();

		String[][] sTry1 = { { "4", "f" }, { "f" } };
		String[][] sTry2 = new String[][] { new String[] {"1"}, new String[] {"2","3"} };
		String[][][] sTry3 = { { {"d"} }, { {"d"}} };
		System.out.println(Arrays.deepToString(sTry1));
		System.out.println(Arrays.deepToString(sTry2));
		System.out.println(Arrays.deepToString(sTry3));
	}
}
