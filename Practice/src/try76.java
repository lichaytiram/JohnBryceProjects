import java.util.Arrays;

public class try76 {
	public static void main(String[] args) {

		String s = "abc";
		String[] s1 = { "a", "b", "c" };
		String[][] s2 = { { "a", "b" }, { "c", "d" } };
		System.out.println(print(s1));
	}

	public static String print(String[] s1) {
		return Arrays.deepToString(s1);
	}
}
