package codility;

public class CountDiv {

	public static void main(String[] args) {
		System.out.println(solution(6, 11, 2));
	}

	public static int solution(int n1, int n2, int k) {

		int count = 0;
		if (n1 != 0 && n1 % k == 0)
			count++;

		n2 = n2 - n1;
		if (n2 < k)
			return count;
		else
			return count + n2 / k;
	}
}
