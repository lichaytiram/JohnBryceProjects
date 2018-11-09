import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class try74 {
	public static void main(String[] args) {

		String[] sA = { "aa", "bb", "cc", "dd" };
		Hashtable<String, String> hT = new Hashtable<>();
		hT.put("a", sA[0]);
		hT.put("2r2", sA[3]);
		System.out.println(hT.get("2r2"));

		System.out.println();
		for (String temp : hT.keySet()) {
			System.out.println(hT.get(temp));

		}
		Queue<Integer> q = new LinkedList<>();
		System.out.println(q.add(3));
		System.out.println(q.add(5));
		System.out.println(q.add(8));
		System.out.println(q.peek());
		System.out.println(q);
		System.out.println(q.remove(3));
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q + " peek");
		System.out.println(q.poll());
		System.out.println(q + " poll");
		System.out.println("-----------------------------------------");
		ArrayList<Integer> listI = new ArrayList<>();
		listI.add(7);
		System.out.println(listI);
		Stack<Integer> s = new Stack<>();
		System.out.println(s.add(4));
		System.out.println(s.add(5));
		System.out.println(s.add(6));
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s.remove(2));
		System.out.println("this " + s.pop());
		System.out.println(s);
		System.out.println(s.peek());

	}
}
