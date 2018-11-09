package Day07_11_2018_Project1;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
	public static void main(String[] args) {

		Task<String> t1 = new Task<>("Buy food", 20);
		Task<String[]> t2 = new Task<>(new String[] { "Clean room", "Clean garden" }, 50);
		Task<String> t3 = new Task<>("Cook food", 20);
		Task<String[][]> t4 = new Task<>(
				new String[][] { { "Buy drink", "Buy food" }, { "Pay to post", "Pay to bank" } }, 120);

		@SuppressWarnings("rawtypes")
		Queue<Task> listQ1 = new LinkedList<>();
		@SuppressWarnings("rawtypes")
		Queue<Task> listQ2 = new LinkedList<>();
		listQ1.add(t1);
		listQ1.add(t2);
		listQ2.add(t3);
		listQ2.add(t4);
		@SuppressWarnings("rawtypes")
		Hashtable<String, Queue<Task>> listH = new Hashtable<>();
		listH.put("Bob", listQ1);
		listH.put("Alice", listQ2);
		for (String key : listH.keySet()) {
			System.out.println("The key is " + key + "\n" + listH.get(key));
		}
		int sumTaskDuration = t1.getTaskDuration() + t2.getTaskDuration() + t3.getTaskDuration() + t4.getTaskDuration();
		System.out.println("Total duration of all tasks is " + sumTaskDuration);
	}
}
