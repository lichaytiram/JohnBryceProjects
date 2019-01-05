import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class try144 {
	public static void main(String[] args) {

		String name = "myxe name is lichay!%$ 100x";
		String p = "(\\D)";

		Pattern check = Pattern.compile(p);
		Matcher m = check.matcher(name);

		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
		}

	}
}
