import java.util.Arrays;

public class try135 {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(partlist(new String[] { "vJQ", "anj", "mQDq", "sOZ" })));
	}

	public static String[][] partlist(String[] arr) {
		String[][] arrS = new String[arr.length - 1][2];
		for (int i = 0; i < arrS.length; i++)
			for (int j = 0; j < arrS[i].length; j++)
				arrS[i][j] = "";
		int start = 1;
		for (int i = 0; i < arrS.length; i++) {
			for (int j = 0; j < start; j++) {
				arrS[i][0] += arr[j];
				if (j != start - 1)
					arrS[i][0] += " ";
			}
			for (int j = start; j < arr.length; j++) {
				arrS[i][1] += arr[j];
				if (j != arr.length - 1)
					arrS[i][1] += " ";
			}
			start++;
		}
		return arrS;
	}
}
