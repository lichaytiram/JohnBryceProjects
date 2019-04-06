package Program47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Program {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<Person>();
		people.add(new Person("ido", 27, false));
		people.add(new Person("dani", 82, false));
		people.add(new Person("adi", 12, true));
		people.add(new Person("dorit", 19, false));

		printWithCondition(people, new Predicate<Person>() {

			@Override
			public boolean test(Person p) {
				return true;
			}
		});

		System.out.println("-------------------------------------------");

		printWithCondition(people, p -> true);

		System.out.println("-------------------------------------------");

		printWithCondition(people, new Predicate<Person>() {

			@Override
			public boolean test(Person p) {
				return p.getName().startsWith("d");
			}
		});

		System.out.println("-------------------------------------------");

		Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));

		printWithCondition(people, s -> true);

		System.out.println("-------------------------------------------");

		Collections.sort(people, (p1, p2) -> (int) (p1.getAge() - p2.getAge()));

		printWithCondition(people, s -> true);

	}

	public static void printWithCondition(List<Person> people, Predicate<Person> condition) {

		for (Person person : people) {
			if (condition.test(person))
				System.out.println(person);
		}
	}
}
