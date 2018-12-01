
public class try86 {
	public static void main(String[] args) {
		System.out.println(alphabetWar("wwwwwwz"));
	}

	public static String alphabetWar(String fight) {
		int left = 0, right = 0;

		for (int i = 0; i < fight.length(); i++) {
			switch (fight.charAt(i)) {
			case 'w':
				left += 4;
				break;
			case 'p':
				left += 3;
				break;
			case 'b':
				left += 2;
				break;
			case 's':
				left++;
				break;
			case 'm':
				right += 4;
				break;
			case 'q':
				right += 3;
				break;
			case 'd':
				right += 2;
				break;
			case 'z':
				right++;
				break;

			}
		}

		if (left > right)
			return "Left side wins!";
		else if (left < right)
			return "Right side wins!";

		return "Let's fight again!";
	}
}
