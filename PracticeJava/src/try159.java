import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class try159 {

	public static void main(String[] args) {

		String[] arr = { "my", "name", "is", "lichay" };
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		list.remove("lichay");
		list.add("tom");
		list.add("!");
		System.out.println(Arrays.toString(arr));
		arr = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(arr));
	}

}
