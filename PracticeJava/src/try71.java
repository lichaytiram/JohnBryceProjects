
public class try71 {

	public static void main(String[] args) {

		String s1 = "  hi-o m      glol     ";
		System.out.println(s1);
		s1 = s1.trim();
		System.out.println(s1);
		String s = "abcdE";
		System.out.println(s + "\t" + "hi");
		String s2 = "abcc", s3 = "Abc";
		System.out.println(s2.compareTo(s3));
		s3 = s3.toLowerCase();
		System.out.println(s2.compareTo(s3));
		System.out.println(s3.concat(" "));
		char[] c = { 'c', 'r', 'a', 'b', 'c' };
		System.out.println(String.copyValueOf(c, 0, 4));
		String s6 =String.copyValueOf(c);
		System.out.println(s6+" this");
		String s4 = "abcd";
		String s5 = "bcd";
		System.out.println(s4.endsWith(s5));
		
		
	}

}
