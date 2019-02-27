package Program41;

//import java.time.LocalDate;
//import java.util.Date;

public class Program {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Job j = new Job();
		Thread t1 = new Thread(j, "daily job");
		System.out.println(t1.getName());
//		t1.start();

//		Date d = new Date();
//		System.out.println(d);
//		System.out.println(d.getTime());

		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    sqlDate.setHours(30);
	    System.out.println("utilDate:" + utilDate);
	    System.out.println("sqlDate:" + sqlDate);

	}
}
