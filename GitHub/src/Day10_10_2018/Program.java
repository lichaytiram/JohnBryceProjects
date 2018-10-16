package Day10_10_2018;

public class Program {
	public static void main(String[] args) {
		Pizza[] p = new Pizza[5];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Pizza();
		}

		for (Pizza pizza : p) {
			System.out.println(pizza.print());
			System.out.println(pizza.isBasicPizza());
		}
		System.out.println("The sum of Toppings is " + Pizza.getSumToppings() + " pcs");

	}
}
