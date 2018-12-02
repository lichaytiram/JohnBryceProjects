
public class try132 {
	public static void main(String[] args) {
		String s1 = "abaebcp";
		String s2 = "abci";
		System.out.println(s1.compareTo(s2));
		char d = 'f';
		d++;
		System.out.println(d);
		System.out.println(s1);
		s1 = s1.substring(0, 2).replace('b', ' ') + s1.substring(2); // work too
		s1 = s1.replaceFirst("b", "");
		System.out.println(s1);
		System.out.println(Math.pow(10, 10));
	}
}
