
public class try17 {
	public static void main(String[] args) {
		System.out.println(noSpace("hello To All"));
	}

	public static String noSpace(String x) {
		String s = "";
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) != ' ')
				s += x.charAt(i);
		}
		return s;
	}

}
