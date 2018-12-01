package page49;

public class try8 {
	public static void main(String[] args) {
		int[][] arr = new int[10][10];
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			for (int j = 0; j < arr.length; j++) {
				if (i == 0 || j == 0 || arr.length - 1 == i || arr[i].length - 1 == j)
					System.out.print("1 ");
				else if (i == 1 || j == 1 || arr.length - 2 == i || arr[i].length - 2 == j)
					System.out.print("2 ");
				else if (i == 2 || j == 2 || arr.length - 3 == i || arr[i].length - 3 == j)
					System.out.print("3 ");
				else if (i == 3 || j == 3 || arr.length - 4 == i || arr[i].length - 4 == j)
					System.out.print("4 ");
				else if (i == 4 || j == 4 || arr.length - 5 == i || arr[i].length - 5 == j)
					System.out.print("5 ");
			}
		}
	}
}
