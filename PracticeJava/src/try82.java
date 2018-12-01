
public class try82 {
	public static void main(String[] args) {

		int[] arr = {25, 100};
		System.out.println(Tickets(arr));
	}

	public static String Tickets(int[] peopleInLine) {
		String isAllTicketsSold = "yes";
		for (int i = 0; i < peopleInLine.length; i++) {
			if (peopleInLine[i] < 25)
				isAllTicketsSold = "no";
		}

		return isAllTicketsSold;
	}
}
