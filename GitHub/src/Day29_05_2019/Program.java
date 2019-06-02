package Day29_05_2019;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		Car[] cars = new Car[4];
		cars[0] = new Car("car1", 50, "nissan");
		cars[1] = new Car("car2", 80, "toyota");
		cars[2] = new Car("car3", 60, "hyundai");
		cars[3] = new Car("car4", 55, "avi");

		System.out.println(Arrays.toString(cars));
		System.out.println("after sort");
		Arrays.sort(cars);
		System.out.println(Arrays.toString(cars));
		System.out.println("after sort");
		Arrays.sort(cars, new ByModel());
		System.out.println(Arrays.toString(cars));
	}

}
