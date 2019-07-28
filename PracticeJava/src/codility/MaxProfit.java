package codility;

import java.util.Arrays;

public class MaxProfit {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 8, 9, 3, 6, 1, 2 }));

	}

	public static int solution(int[] arr) {

		if (arr == null || arr.length == 0)
			return 0;

		Container[] containerArray = new Container[arr.length];

		for (int i = 0; i < arr.length; i++)
			containerArray[i] = new Container(arr[i], i);

		int minIndex = 0, maxIndex = containerArray.length - 1;
		int minIndexToDecrease = maxIndex, maxIndexToIncrease = minIndex;

		Arrays.sort(containerArray);

		for (Container e : containerArray) {
			System.out.println(e);
		}

		while (minIndex <= maxIndex) {

			if (containerArray[minIndex].index < containerArray[maxIndex].index)
				return Math.abs(containerArray[minIndex].number - containerArray[maxIndex].number);

			else if (containerArray[minIndex].number > containerArray[maxIndex].number)
				return 0;

			if (containerArray[minIndex].index == minIndexToDecrease) {
				minIndexToDecrease--;
				minIndex++;
			}

			if (containerArray[maxIndex].index == maxIndexToIncrease) {
				maxIndexToIncrease++;
				maxIndex--;
			}

		}

		return 0;

	}

}

class Container implements Comparable<Container> {

	int number;
	int index;

	public Container(int number, int index) {
		super();
		this.number = number;
		this.index = index;
	}

	@Override
	public int compareTo(Container o) {

		if (this.number > o.number)
			return 1;
		return -1;
	}

	@Override
	public String toString() {
		return "Container [number=" + number + ", index=" + index + "]";
	}

}