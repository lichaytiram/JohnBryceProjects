import java.util.Arrays;
import java.util.ArrayList;

public class try125 {
	public static void main(String[] args) {
		System.out.println(nthSmallest(new int[] { 15, 20, 7, 10, 4, 3 }, 3));
		System.out.println(nthSmallestV2(new int[] { 15, 20, 7, 10, 4, 3 }, 3));
	}

	public static int nthSmallest(final int[] arr, final int n) {
		Arrays.sort(arr);
		return arr[n - 1];
	}

	public static int nthSmallestV2(final int[] arr, final int n) {
		int num = n, min = arr[0];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++)
			list.add(arr[i]);
		while (num > 0) {
			for (int i = 0; i < list.size(); i++)
				if (list.get(i) < min)
					min = list.get(i);
			if (num > 1) {
				list.remove((Integer) (min));
				min = list.get(0);
			}
			num--;
		}
		return min;
	}
}
