package Program49;

import java.util.LinkedList;
import java.util.Queue;

public class Program {

	public static void main(String[] args) {

		int[][] countries = { { 1, 1, 0, 1, 2 }, { 0, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0 }, { 1, 2, 2, 1, 0 },
				{ 1, 1, 2, 0, 0 } };

		int count = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));

		while (!queue.isEmpty()) {
			recursive(countries, queue.poll());
			count++;
		}

		System.out.println(count);

	}

	public static boolean recursive(int[][] countries, Point point) {

		if (point == null)
			return false;

		return recursive(countries, new Point(point.getX() + 1, point.getY()))
				&& recursive(countries, new Point(point.getX(), point.getY() + 1))
				&& recursive(countries, new Point(point.getX() - 1, point.getY()));

	}

}
