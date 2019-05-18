import java.util.LinkedList;
import java.util.List;

public class try155 {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));

	}

	public static int solution(int[] arr) {

		List<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!list.contains(arr[i]))
				list.add(arr[i]);

			else
				list.remove((Integer) (arr[i]));

		}

		if (list.isEmpty())
			return 0;

		return list.get(0);

	}

}
