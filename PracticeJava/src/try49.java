
public class try49 {
	public static void main(String[] args) {

		String s = "howAreU";
		System.out.println("need to be! ---------> -UerAwoh");
		System.out.println("This is by replace --> -" + replace(s) + "-");

	}

	public static String replace(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char temp = s.charAt(left);
			s = s.replace(s.charAt(left), s.charAt(right));
			s = s.replace(s.charAt(right), temp);
			left++;
			right--;
		}
		return s;
	}
}
