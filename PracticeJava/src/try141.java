import java.util.Date;

public class try141 {
	public static void main(String[] args) {
		System.out.println("Start");
		int x = 3;
		System.out.println(x);
		try {
			Thread.sleep(0L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(x);
		System.out.println("End");
		double d = 22.345678;
		System.out.println(d);
		System.out.println(String.format("", d));
		System.out.println(new Date());
		String s = "abc@walla.com";
		int index = s.indexOf('@');
		System.out.println(index);
		System.out.println(s.contains("."));

		System.out.println("-------------------------");
		String s1 = "1sdsdD";
		char checkLetter = 'A';
		while (checkLetter <= 'Z') {
			if (s1.contains(checkLetter + ""))
				break;
			if (checkLetter == 'Z')
				System.out.println("error");
			checkLetter++;
		}
		System.out.println("-------------------------");
		int checkDigit = 0;
		while (checkDigit < 10) {
			if (s1.contains(checkDigit + ""))
				break;
			if (checkDigit == 9)
				System.out.println("digit error");
			checkDigit++;
		}
		System.out.println("-------------------------");
		String s2 = "lichay.tiram@g.mail.com";
		if (!s2.contains("@"))
			System.out.println("no 1");
		else if (!(s2.indexOf('@') + 1 < s2.lastIndexOf('.')))
			System.out.println("no 2");
		else
			System.out.println("yes");
		System.out.println("-------------------------");
		System.out.println((char) (s2.charAt(0) - 32));
		System.out.println("-------------------------");
		String s3 = "aaA";
		System.out.println(s3.charAt(0) <= 'Z' ? s3.charAt(0) + s3.substring(1, s3.length()).toLowerCase()
				: (char) (s3.charAt(0) - 32) + s3.substring(1, s3.length()).toLowerCase());

	}
}
