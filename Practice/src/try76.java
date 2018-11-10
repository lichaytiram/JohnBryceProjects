import java.util.Arrays;

public class try76 {
	public static void main(String[] args) {

		String s = "abc"; // don't work on first
		String[] s1 = { "a", "b", "c" };
		String[][] s2 = { { "a", "b" }, { "c", "d" } };
		char[] s3 = { 'a', 'b' };
//		System.out.println(print(s)); don't work in print()
		System.out.println(print(s1));
		System.out.println(print(s2));
//		System.out.println(print(s3)); don't work in print()
		System.out.println(printAll(s));
		System.out.println(printAll(s1));
		System.out.println(printAll(s2));
		System.out.println(printAll(s3));

	}

	public static String print(Object[] s) {
		return Arrays.deepToString(s);
	}

	@SuppressWarnings("unchecked")
	public static <T> T printAll(T t) {
		if (t instanceof Object[])
			return (T) (Arrays.deepToString((Object[]) t));
		return t;

	}
}
