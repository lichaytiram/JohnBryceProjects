
public class try140 {
	public static void main(String[] args) {
		System.out.println(random(new String[] { "Lichay", "Dor", "Maor", "Nil", "Talia" }));
	}

	public static String random(String[] project) {
		String values = "Team 1: ";
		int length = project.length;
		for (int i = 0; i < 3; i++) {
			int rand = rand(length);
			while (values.contains(project[rand]))
				rand = rand(length);
			values += project[rand] + " ";
		}
		values += "\nTeam 2: ";
		for (int i = 0; i < project.length; i++)
			if (!values.contains(project[i]))
				values += project[i] + " ";
		return values;

	}

	public static int rand(int n) {
		return (int) (Math.random() * n);
	}
}
