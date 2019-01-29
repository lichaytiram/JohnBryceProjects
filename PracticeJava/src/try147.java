import java.util.Arrays;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class try147 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String[] array = { "omer", "dor", "shani", "batel", "lichay" };
		System.out.println(Arrays.toString(array) + " This is a toString");
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		for (int i = 0; i < array.length; i++) {
			jsonObject.put("name", array[i]);
			System.out.println("jsonObject:" + jsonObject);
			jsonArray.add(jsonObject);
		}

		System.out.println("This^" + jsonObject); // why this print only lichay
		System.out.println("This^" + jsonArray); // and how lichay print 5 times (only i==length-1 happen only one time)
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("id", "123456");
		jsonArray.add(jsonObject2);
		jsonObject2 = new JSONObject();
		jsonObject2.put("id", "123");
		jsonArray.add(jsonObject2);

		System.out.println("jsonArray");
		System.out.println(jsonArray);
		System.out.println("------------------------1-----------------------------");
		JSONArray jA = new JSONArray();
		JSONObject jO = new JSONObject();
		System.out.println(jA);
		System.out.println(jO);

		jO.put("name", "ido");
		jO.put("isMale", true);
		jO.put("age", 32);
		System.out.println("single");
		System.out.println(jA);
		System.out.println(jO);
		System.out.println("after add");
		jA.add(jO);
		System.out.println(jA);
		System.out.println(jO);
		System.out.println("------------------------2-----------------------------");
		for (int i = 0; i < 3; i++) {

			jA.add(i);
		}
		jO.put("array", jO.toString());
		System.out.println("JSONArray: " + jA);
		System.out.println("JSONObject: " + jO);

	}
}
