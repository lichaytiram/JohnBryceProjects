import java.util.Arrays;

public class try110 {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 1 } };
		int[][] arr2 = { { 2, 2, 1 }, { 3, 2, 3 }, { 1, 1, 3 } };
		System.out.println(Arrays.deepToString(matrixAddition(arr1, arr2)));
	}

	public static int[][] matrixAddition(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[i].length; j++)
				a[i][j] += b[i][j];
		return a;
	}
}
