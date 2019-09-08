import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class try175 {

	public static void main(String[] args) {

		Integer[] arr1 = { 1, 3, 5, 6, 6, 0, 0, 0 };
		Integer[] arr2 = { 2, 3, 9 };

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		// after sort
		sort(arr1, arr2);
		System.out.println(Arrays.toString(arr1));

	}

	public static void sort(Integer[] arr1, Integer[] arr2) {

		List<Integer> sortList = new ArrayList<>();

		int firstLength = 0, secondLength = 0;

		while (arr1[firstLength] != 0 || secondLength < arr2.length) {

			if (secondLength == arr2.length || (arr1[firstLength] < arr2[secondLength] && arr1[firstLength] != 0))
				sortList.add(arr1[firstLength++]);
			else
				sortList.add(arr2[secondLength++]);
		}

		for (int i = 0; i < sortList.size(); i++) {
			arr1[i] = sortList.get(i);
		}

	}

}
