import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class try161 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 4, 7, 8));
		System.out.println(list + "\n");
		list.forEach(p -> System.out.println(p));
		System.out.println();
		list.forEach(System.out::println);

	}

}
