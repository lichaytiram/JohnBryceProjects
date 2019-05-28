package codility;

public class StoneWall {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 }));
	}

	public static int solution(int[] h) {

		if (h == null || h.length == 0)
			return 0;

		int count = 1, currenthigh = h[0];

		for (int i = 0; i < h.length; i++) {
			if (h[i] != currenthigh) {
				count++;
				currenthigh = h[i];
			}
		}

		return count;

	}
}
