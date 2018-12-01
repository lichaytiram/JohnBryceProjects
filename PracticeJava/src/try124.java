
public class try124 {
	public static void main(String[] args) {
		System.out.println(check(new char[] { 'c', 'd', 'v', 'c', 'r', 'c', 'd', 'o' }));
	}

	public static char[] check(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			char temp = arr[i];
			boolean changeTemp = false;
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				else if (temp == arr[j]) {
					arr[j] = ' ';
					changeTemp = true;
				}
			}
			if (changeTemp)
				arr[i] = ' ';
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != ' ')
				count++;
		char[] newChar = new char[count];
		for (int i = 0; i < newChar.length; i++)
			for (int j = 0; j < arr.length; j++)
				if (arr[j] != ' ') {
					newChar[i] = arr[j];
					arr[j] = ' ';
					break;
				}
		return newChar;
	}
}
