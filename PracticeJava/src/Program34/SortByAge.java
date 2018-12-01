package Program34;

import java.util.Comparator;

public class SortByAge implements Comparator<Animal> {

	@Override
	public int compare(Animal a1, Animal a2) {
		return a1.getAge() - a2.getAge();
	}

}
