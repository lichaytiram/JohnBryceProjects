package Program34;

import java.util.Arrays;

public class Program {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Animal[] animalArr = new Animal[3];
		animalArr[0] = new Dog("Roki", 3, 4);
		animalArr[1] = new Cat("Mittsi", 7, EColor.WHITE);
		animalArr[2] = new Bird("Gigi", 13, "ss");
		System.out.println(Arrays.toString(animalArr));
		Arrays.sort(animalArr);
		System.out.println("\nafter compateTo sort by name");
		System.out.println(Arrays.toString(animalArr));

		System.out.println("\nafter comparator sort by age");
		Arrays.sort(animalArr, new SortByAge());
		System.out.println(Arrays.toString(animalArr));

	}
}
