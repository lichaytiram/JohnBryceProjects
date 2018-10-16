import java.util.Scanner;

public class try12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String n = scan.next();
		System.out.println(change(n) + " !");

		scan.close();
	}

	public static String change(String n) {
		String s = "";
		char check1 = 'a', check2 = 'A';
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < n.length(); j++)
				if (n.charAt(j) == check1 || n.charAt(j) == check2)
					s += n.charAt(j);
			if (s.length() == n.length())
				break;
			check1 += 1;
			check2 += 1;
		}
		return s;
	}
}