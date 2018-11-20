
public class try103 {
	public static void main(String[] args) {
		String s = "a";
		System.out.println((char) (s.charAt(0) - 32));

		System.out.println((char) ('a' - 32));

		int index = 4;
		for (int i = 0; i < 10; i++) {
			System.out.println("before" + i);
			if (index == i)
				continue;
			System.out.println("after" + i);
		}
		int i = 4;
		String s1 = "hi";
		String s2 = "world";
		double d = 4.3;
		double d2 = 8.563;
		System.out.println(i + s1 + s2 + d);
		System.out.println(String.format("%s %d %s %.1f %.3f %.4f", s2, i, s1, d, d, d2));
		System.out.println(d2);
		d2 = Double.parseDouble(String.format("%.2f", d2));
		System.out.println(d2);

	}
}
