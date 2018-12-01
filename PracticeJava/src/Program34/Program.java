package Program34;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Animal[] animalArr = new Animal[5];
		animalArr[0] = new Dog("Roki", 3, 4);
		animalArr[1] = new Cat("Mittsi", 5, EColor.WHITE);
		animalArr[2] = new Cat("Miyu", 7, EColor.Purple);
		animalArr[3] = new Cat("Titay", 2, EColor.BLACK);
		animalArr[4] = new Bird("Gigi", 13, "ss");
		System.out.println(Arrays.toString(animalArr));
		if (animalArr[0] instanceof Dog)
			System.out.println(((Dog) (animalArr[0])).isBite());
		Arrays.sort(animalArr);
		System.out.println("\nafter compateTo sort by name");
		System.out.println(Arrays.toString(animalArr));

		System.out.println("\nafter comparator sort by age");
		Arrays.sort(animalArr, new SortByAge());
		System.out.println(Arrays.toString(animalArr));
		Cat[] catArr = new Cat[3];
		int dontSameCat = 0;
		for (int i = 0; i < catArr.length; i++)
			for (int j = dontSameCat; j < animalArr.length; j++)
				if (animalArr[j] instanceof Cat) {
					catArr[i] = (Cat) animalArr[j];
					dontSameCat = ++j;
					break;
				}
		catArr[0].lick();
		catArr[1].lick();
		catArr[1].lick();
		catArr[1].lick();
		catArr[0].lick();
		System.out.println("Cat Array\n" + Arrays.toString(catArr));
		System.out.println("\nArray comparable sort by name for Cat");
		Arrays.sort(catArr);
		System.out.println("Cat Array regular\n" + Arrays.toString(catArr));
		Arrays.sort(catArr, Collections.reverseOrder());
		System.out.println("Cat Array reverse\n" + Arrays.toString(catArr));
		System.out.println("\nArray comparable sort by age for Cat");
		Arrays.sort(catArr, new ArrSortByAge());
		System.out.println("Cat Array\n" + Arrays.toString(catArr));

		System.out.println("Now we do queue of Cat");
		Queue<Cat> CQ = new LinkedList<>();
		CQ.add(catArr[0]);
		CQ.add(catArr[1]);
		CQ.add(catArr[2]);
		System.out.println("Ready to delete....");
		int size = CQ.size();
		for (int i = 0; i < size; i++) {
			System.out.println("delete: " + CQ.peek());
			System.out.println(CQ);
			CQ.poll();
		}
		System.out.println(CQ);
	}
}