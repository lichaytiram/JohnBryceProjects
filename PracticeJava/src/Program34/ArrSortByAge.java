package Program34;

import java.util.Comparator;

public class ArrSortByAge implements Comparator<Cat> {

	@Override
	public int compare(Cat c1, Cat c2) {
		return c1.getAge() - c2.getAge();
	}
}
