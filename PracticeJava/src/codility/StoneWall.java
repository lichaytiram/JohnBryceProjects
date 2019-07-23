package codility;

public class StoneWall {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }));
	}

	public static int solution(int[] h) {

		if (h == null || h.length == 0)
			return 0;

		int countWalls = 1;
		if (h.length == 1)
			return countWalls;

		for (int i = 1; i < h.length; i++) {

			if (h[i] == h[i - 1])
				continue;

			if (h[i] > h[i - 1])
				countWalls++;

			else {

				
				
			}
		}

		return countWalls;

	}
}
