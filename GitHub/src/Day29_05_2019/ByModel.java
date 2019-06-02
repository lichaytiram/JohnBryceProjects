package Day29_05_2019;

import java.util.Comparator;

public class ByModel implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		if (car1.getModel().charAt(0) > car2.getModel().charAt(0))
			return 1;
		else
			return -1;
	}

}
