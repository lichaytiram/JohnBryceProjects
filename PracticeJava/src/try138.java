import java.util.Hashtable;

public class try138 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++)
			arr[i] = getDigit();
		Hashtable<String, Integer> hI = new Hashtable<>();
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 2 || arr[i] == 5)
				hI.put(i + "", arr[i]);
		for (int x : hI.values())
			System.out.println(x);
	}

	public static int getDigit() {
		return (int) (Math.random() * 10);
	}

}
