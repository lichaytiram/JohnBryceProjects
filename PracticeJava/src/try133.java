import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class try133 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(flattenAndSort(
				new int[][] { { 111, 999 }, { 222 }, { 333 }, { 444 }, { 888 }, { 777 }, { 666 }, { 555 } })));
	}

	public static int[] flattenAndSort(int[][] array) {
		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				intList.add(array[i][j]);
		Collections.sort(intList);
		int[] arr = new int[intList.size()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = intList.get(i);
		return arr;
	}
}
