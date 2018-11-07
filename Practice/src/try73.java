import java.util.ArrayList;

public class try73 {
	public static void main(String[] args) {
		String s1 = "abcD -a";
		String s2 = "abcD -e";
		System.out.println(s1);
		System.out.println(s1.compareTo(s2));
		System.out.println(s1);

		char[] cArr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		String s = "";
		System.out.println(s.length());
		s = String.copyValueOf(cArr, 0, 3);
		System.out.println(s);
		System.out.println(s.length());

		String s3 = "omge1";
		String s4 = "omge1";
		System.out.println(s3.endsWith(s4));
		String tryString = "hiWorlds";
		char[] arrc = new char[5];

		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(list);
		list.add(5);
		System.out.println(list.size());
		list.add(0, 6);
		list.add(7);
		System.out.println(list.size());
		System.out.println(list);

		list.remove(1);
		System.out.println(list);
		
	}
}
