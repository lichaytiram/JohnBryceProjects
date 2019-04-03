package Program43;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<AviThread> threads = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			AviThread thread = new AviThread(i);
			threads.add(thread);
		}

		for (int i = 0; i < 10; i++) {
			threads.get(i).start();
		}
	}

}
