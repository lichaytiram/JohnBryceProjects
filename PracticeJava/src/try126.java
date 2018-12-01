import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class try126 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(menFromBoys(new int[] { 2, 15, 17, 15, 2, 10, 10, 17, 1, 1 })));
	}

	public static int[] menFromBoys(final int[] values) {
		Arrays.sort(values);
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < values.length; i++)
			if (values[i] % 2 == 0)
				list1.add(values[i]);
			else
				list2.add(values[i]);
		Collections.reverse(list2);
		int size = list1.size();
		for (int i = 0; i < values.length; i++)
			if (i < size) {
				values[i] = list1.get(0);
				list1.remove(0);
			} else {
				values[i] = list2.get(0);
				list2.remove(0);
			}
		ArrayList<Integer> finalList = new ArrayList<>();
		for (int i = 0; i < values.length; i++) {
			boolean check = true;
			for (int j = 0; j < finalList.size(); j++)
				if (values[i] == finalList.get(j)) {
					check = false;
					break;
				}
			if (check)
				finalList.add(values[i]);
		}
		int[] finalInt = new int[finalList.size()];
		for (int i = 0; i < finalInt.length; i++)
			finalInt[i] = finalList.get(i);
		return finalInt;
	}
}
