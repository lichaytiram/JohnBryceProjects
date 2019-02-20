import java.util.Date;

public class try148 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date);
		date.setYear(date.getYear()+1);
		System.out.println(date);
	}
}
