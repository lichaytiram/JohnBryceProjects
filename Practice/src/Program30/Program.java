package Program30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Program {
	public static void main(String[] args) {
		ArrayList<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza(toppings.OLIVE, Size.SMALL, 30.1));
		pizzaList.add(new Pizza(toppings.OLIVE, Size.LARGE, 30.1));
		pizzaList.add(new Pizza(toppings.ONION, Size.SMALL, 30.1));

		for (Pizza p : pizzaList)
			System.out.println(p);

		
		Collections.sort(pizzaList);
		for (Pizza p : pizzaList)
			System.out.println(p);
	}
}
