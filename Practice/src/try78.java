
public class try78 {
	public static void main(String[] args) {

		String s1 = "53";
		String s2 = "2";
		String s3 = "c";

		int n1 = Integer.parseInt(s1);
		System.out.println(n1);
		int n2 = Integer.parseInt(s2);
		System.out.println(n2);
//		int n3 = Integer.parseInt((s3));  don't work
//		System.out.println(n3);

		int sum = Integer.parseInt(s2) - Integer.parseInt(s1);
		System.out.println("The sum is " + sum);
		try {
			int n3 = Integer.parseInt((s3));
			System.out.println(n3);
		} catch (java.lang.NumberFormatException exept) {
			System.out.println("run time fail.");
		}
		System.out.println(++n1);
	}
}
