package codility;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 3, 4, 3, 2, 3, -1, 3, 3 }));

	}

	public static int solution(int[] arr) {

		int length = arr.length / 2;

		Map<Integer, MyMap> map = new HashMap<Integer, MyMap>();

		for (int i = 0; i < arr.length; i++) {

			int key = arr[i];

			if (map.containsKey(key))
				map.put(key, new MyMap((map.get(key).value + 1), i));
			else
				map.put(key, new MyMap(1, i));

		}

		for (Integer key : map.keySet()) {

			if (map.get(key).value > length)
				return map.get(key).index;
		}

		return -1;
	}

}

class MyMap {

	int value;
	int index;

	public MyMap(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

}
