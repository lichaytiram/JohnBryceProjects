
public class try140 {
	public static void main(String[] args) {
		System.out.println(random());
	}
	public static String random() {
		String[] project = { "Lichay", "Dor", "Maor", "Nil", "Talia" };
		String values = "Team 1: ";
		for (int i = 0; i < 3; i++) {
			int rand = rand();
			while (values.contains(project[rand]))
				rand = rand();
			values += project[rand] + " ";
		}
		values += "\nTeam 2: ";
		for (int i = 0; i < project.length; i++)
			if (!values.contains(project[i]))
				values += project[i] + " ";
		return values;

	}
	public static int rand() {
		return (int) (Math.random() * 5);
	}
}
