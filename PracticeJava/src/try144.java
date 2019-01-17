import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class try144 {
	public static void main(String[] args) {

		String name = "bTb2";
//		String pattern = "[a-z|A-Z|0-9]{3,}";
		String pattern = "[?=.*A-Z][?=.*a-z][?=.*0-9]";

		Pattern check = Pattern.compile(pattern);
		Matcher m = check.matcher(name);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.matches());
		} else
			System.out.println("else: Found value ->" + m.matches() + "<-");
		
	}
}
