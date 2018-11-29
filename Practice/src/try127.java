import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class try127 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("before if: " + i);
			if (i == 2)
				continue;
			System.out.println("after if: " + i);
		}
		System.out.println("-----------1--------------");
		Integer[] arr1 = { 4, 6, 1, 9, 7, 3 };
		System.out.println(Arrays.toString(arr1));
		Arrays.sort(arr1, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr1));
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		System.out.println("-----------2--------------");
		int[] arr2 = { 4, 6, 1, 9, 7, 3 };
		System.out.println(Arrays.toString(arr2));
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		Arrays.sort(arr2);
		System.out.println("-----------3--------------");
		ArrayList<String> list = new ArrayList<>();
		list.add("2");
		list.add("5");
		list.add("3");
		list.add("9");
		list.add("8");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println("----------way 2-----------");
		Collections.reverse(list);
		System.out.println(list);
	}
}
