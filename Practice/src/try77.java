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
		System.out.println(Arrays.deepToString(sTry1));
	}
}
