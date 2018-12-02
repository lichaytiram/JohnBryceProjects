package Program36;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	public static ArrayList<String> stringList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Thread[] t = new Thread[4];
		for (int i = 0; i < t.length; i++)
			t[i] = new Thread(new Writer(scan.next()));
		scan.close();
	}
}
