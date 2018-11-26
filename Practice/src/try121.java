
public class try121 {
	public static void main(String[] args) {
		System.out.println(michaelPays(28.789));
	}

	public static double michaelPays(double cost) {
		if (cost < 5)
			return Double.parseDouble(String.format("%.2f", cost));
		if (cost * 1 / 3 < 10)
			return Double.parseDouble(String.format("%.2f", cost - (cost / 3)));
		return Double.parseDouble(String.format("%.2f", cost - 10));
	}
}
