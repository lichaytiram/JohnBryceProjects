package Day05_11_2018_Project1;

public class Program {
	public static void main(String[] args) {

		Product p1 = new Product("apple", randomPlaceInSuitcase());
		Product p2 = new Product("pizza", randomPlaceInSuitcase());
		Product p3 = new Product("computer", randomPlaceInSuitcase());
		Product p4 = new Product("camera", randomPlaceInSuitcase());
		Suitcase s1 = new Suitcase();
		int howMuchProduceInside = howMuchProduceInside();
		while (howMuchProduceInside > 0) {
			int rand = (int) (Math.random() * 6 + 5);
			s1.addProductToSuitcase(product);
			howMuchProduceInside--;
		}

		Traveler t1 = new Traveler(randomFlight(), randomKg(), s1, randomExtraKg());

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
