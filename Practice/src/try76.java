import java.util.Arrays;

public class try76 {
	public static void main(String[] args) {

//		String s = "abc"; don't work 
		String[] s1 = { "a", "b", "c" };
		String[][] s2 = { { "a", "b" }, { "c", "d" } };
		System.out.println(print(s1));
		System.out.println(print(s2));
	}

	public static String print(Object[] s) {
		return Arrays.deepToString(s);
	}
}
