import java.util.Arrays;

public class try158 {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 1, 2, 3 }));
	}

	public static int solution(int[] arr) {

		if (arr == null || arr.length == 0)
			return 1;

		Arrays.sort(arr);
		if (arr[0] != 1)
			return 1;

		if (arr[arr.length - 1] == arr.length)
			return arr[arr.length - 1] + 1;

		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] + 1 != arr[i + 1])
				return arr[i] + 1;

		return arr[0] + 1;

	}
}
