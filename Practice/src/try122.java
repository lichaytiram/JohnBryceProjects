import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class try122 {
	public static void main(String[] args) {

		String s1 = "abcdefg";
		char[] sc1 = s1.toCharArray();
		String s2 = String.copyValueOf(sc1);
		System.out.println(sc1);
		System.out.println(s2);
		ArrayList<String> list = new ArrayList<>();
		list.add(s1);
		list.add("x");
		list.add("Y");
		System.out.println(list);
		String[] sArr = new String[4];
		list.toArray(sArr);
		System.out.println(Arrays.toString(sArr));
		list.clear();
		list.add(s1);
		list.add("x");
		list.add("y");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(2);
		list2.add(18);
		list2.add(10);
		System.out.println(list2);
		Collections.sort(list2);
		System.out.println(list2);
		Collections.reverse(list2);
		System.out.println(list2);

		for (int i = 0; i < list2.size(); i++)
			if (list2.get(i) == 3)
				System.out.println("true");
			else
				System.out.println("false");
	}

}
