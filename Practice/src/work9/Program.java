package work9;

public class Program {
	public static void main(String[] args) {
		Monster[] m = new Monster[4];
		m[0] = new Monster("olaf");
		System.out.println(m[0].attack());
		m[1] = new FireMonster("dark devil");
		System.out.println(m[1].attack());
		System.out.println(m[1].getName());
		m[2] = new WaterMonster("gooru");
		System.out.println(m[2].attack());
		m[3] = new StoneMonster("erred");
		System.out.println(m[3].attack());
	}
}
