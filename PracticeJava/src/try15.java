
public class try15 {
	public static void main(String[] args) {
		System.out.println(basicMath("*", 2, 3));
	}

	public static int basicMath(String x, int num1, int num2) {
		switch (x) {
		case "*":
			num1 *= num2;
			break;
		case "/":
			num1 /= num2;
			break;
		case "+":
			num1 += num2;
			break;
		case "-":
			num1 -= num2;
			break;
		default:
			System.out.println("This char isn't well");
			break;
		}
		return num1;
	}

}
