package Program36;

import java.util.ArrayList;

public class Program {
	public static ArrayList<String> stringList = new ArrayList<>();

	public static void main(String[] args) {
		Thread[] t = new Thread[4];
		for (int i = 0; i < t.length; i++)
			t[i] = new Thread(new Writer("writer: " + (i + 1)));
		for (int i = 0; i < t.length; i++)
			t[i].start();
		for (int i = 0; i < t.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Reader r = new Reader();
		r.read();
	}
}
