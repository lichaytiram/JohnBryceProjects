package Day05_11_2018_Project1;

import java.util.Scanner;

public class Program {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Suitcase s1 = new Suitcase();
		howMuch(s1);
		Traveler t1 = new Traveler(randomFlight(), randomKg(), s1, randomExtraKg());
		yesOrNo(t1);
		Traveler t2 = new Traveler(randomFlight(), randomKg(), s1, randomExtraKg());
		yesOrNo(t2);
	}

	public static void yesOrNo(Traveler t1) {
		System.out.println(t1);
		System.out.println("Do you want pey Extra kg for suitcase?\nYes or No");
		String choose = scan.next();
		if (choose.equals("yes")) {
			if (t1.getMoneyForExtraPlace() * (t1.getSuitcase().getAllItems() - t1.getKgAllowedPerSuitcase()) > 0)
				System.out.println("You need to pay more "
						+ t1.getMoneyForExtraPlace() * (t1.getSuitcase().getAllItems() - t1.getKgAllowedPerSuitcase())
						+ '#');
			else
				System.out.println("You got enough space in your Suitcase!\nNo need additional pay.");
		} else {
			while (t1.getSuitcase().getAllItems() > t1.getKgAllowedPerSuitcase()) {
				t1.getSuitcase().removeProductToSuitcase(
						t1.getSuitcase().getProduct().get(t1.getSuitcase().getProduct().size() - 1));
			}
		}
		System.out.println(t1 + "\n");
	}

	public static void howMuch(Suitcase s1) {
		int howMuchProduceInside = howMuchProduceInside();

		Product p0 = new Product("water", randomPlaceInSuitcase());
		Product p1 = new Product("apple", randomPlaceInSuitcase());
		Product p2 = new Product("pizza", randomPlaceInSuitcase());
		Product p3 = new Product("computer", randomPlaceInSuitcase());
		Product p4 = new Product("camera", randomPlaceInSuitcase());
		Product p5 = new Product("macbook", randomPlaceInSuitcase());
		Product p6 = new Product("psp", randomPlaceInSuitcase());
		Product p7 = new Product("pcPro", randomPlaceInSuitcase());
		Product p8 = new Product("iphoneX", randomPlaceInSuitcase());
		Product p9 = new Product("galaxyS10", randomPlaceInSuitcase());
		Product p10 = new Product("dvd", randomPlaceInSuitcase());
		Product p11 = new Product("dvd", randomPlaceInSuitcase());
		Product p12 = new Product("TV", randomPlaceInSuitcase());
		Product p13 = new Product("glasses", randomPlaceInSuitcase());
		Product p14 = new Product("ball", randomPlaceInSuitcase());
		Product p15 = new Product("bag", randomPlaceInSuitcase());
		Product p16 = new Product("shoes", randomPlaceInSuitcase());
		Product p17 = new Product("laptop", randomPlaceInSuitcase());
		Product p18 = new Product("xboxOne", randomPlaceInSuitcase());
		Product p19 = new Product("Toster", randomPlaceInSuitcase());

		while (howMuchProduceInside > 0) {
			int rand = (int) (Math.random() * 20);
			if (rand == 0)
				s1.addProductToSuitcase(new Product(p0));
			else if (rand == 1)
				s1.addProductToSuitcase(new Product(p1));
			else if (rand == 2)
				s1.addProductToSuitcase(new Product(p2));
			else if (rand == 3)
				s1.addProductToSuitcase(new Product(p3));
			else if (rand == 4)
				s1.addProductToSuitcase(new Product(p4));
			else if (rand == 5)
				s1.addProductToSuitcase(new Product(p5));
			else if (rand == 6)
				s1.addProductToSuitcase(new Product(p6));
			else if (rand == 7)
				s1.addProductToSuitcase(new Product(p7));
			else if (rand == 8)
				s1.addProductToSuitcase(new Product(p8));
			else if (rand == 9)
				s1.addProductToSuitcase(new Product(p9));
			else if (rand == 10)
				s1.addProductToSuitcase(new Product(p10));
			else if (rand == 11)
				s1.addProductToSuitcase(new Product(p11));
			else if (rand == 12)
				s1.addProductToSuitcase(new Product(p12));
			else if (rand == 13)
				s1.addProductToSuitcase(new Product(p13));
			else if (rand == 14)
				s1.addProductToSuitcase(new Product(p14));
			else if (rand == 15)
				s1.addProductToSuitcase(new Product(p15));
			else if (rand == 16)
				s1.addProductToSuitcase(new Product(p16));
			else if (rand == 17)
				s1.addProductToSuitcase(new Product(p17));
			else if (rand == 18)
				s1.addProductToSuitcase(new Product(p18));
			else if (rand == 19)
				s1.addProductToSuitcase(new Product(p19));
			howMuchProduceInside--;
			s1.getAllItems();
		}
	}

	public static int howMuchProduceInside() {
		return (int) (Math.random() * 6 + 5);
	}

	public static int randomPlaceInSuitcase() {
		return (int) (Math.random() * 16 + 1);
	}

	public static int randomFlight() {
		return (int) (Math.random() * 901 + 100);
	}

	public static int randomKg() {
		return (int) (Math.random() * 91 + 10);

	}

	public static int randomExtraKg() {
		return (int) (Math.random() * 191 + 10);

	}
}
