import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class try145 {
	public static void main(String[] args) {
		String word = "aa";
		String pattern = "$a";
		check(word, pattern);
	}

	public static void check(String word, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(word);
		while (m.find()) {
			System.out.println(m.start());
		}
	}
}
