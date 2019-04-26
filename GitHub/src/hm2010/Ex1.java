package hm2010;

import java.util.LinkedList;
import java.util.Queue;

public class Ex1 {

	public static void main(String[] args) {

		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(7);
		q1.add(9);
		q1.add(12);
		q1.add(8);
		q1.add(14);
		q1.add(6);
		q1.add(7);
		Queue<Integer> q2 = new LinkedList<Integer>();
		q2.add(2);
		q2.add(8);
		q2.add(4);
		q2.add(13);
		q2.add(4);
		q2.add(1);
		q2.add(9);
		q2.add(11);
		System.out.println(bigSum(q1, q2));

	}

	public static int bigSum(Queue<Integer> q1, Queue<Integer> q2) {

		int sumS2 = 0;

		while (!q2.isEmpty()) {
			int tempValue = q2.poll(), newSum = 0;

			if (!q2.isEmpty()) {
				newSum = tempValue + q2.peek();
			}

			if (sumS2 < newSum)
				sumS2 = newSum;
		}

		while (!q1.isEmpty()) {
			int tempValue = q1.poll(), newSum = 0;

			if (!q1.isEmpty()) {
				newSum = tempValue + q1.peek();
			}

			if (newSum > sumS2)
				return newSum;
		}

		return 0;
	}
}