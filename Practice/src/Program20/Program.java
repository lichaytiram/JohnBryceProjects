package Program20;

public class Program {
	public static void main(String[] args) {
		bearCare bear1 = new bearCare("bearly", "love");
		bearCare bear2 = new bearCare("bearly", "hate");
		Dragon dragon1 = new Dragon("ess", 4, 4);
		Dragon dragon2 = new Dragon("ess", 4, 4);
		Zoo z = new Zoo();
		System.out.println(z.addAnimal(bear1));
		System.out.println(z.addAnimal(bear2));
		System.out.println(z.addAnimal(dragon1));
		System.out.println(z.addAnimal(dragon2));
		System.out.println(z + "\n");
		for (int i = 0; z.getAnimal(i) != null; i++) {
			if (z.getAnimal(i) instanceof bearCare)
				System.out.println(((bearCare) z.getAnimal(i)).getSign());
			
		}
	}
}
