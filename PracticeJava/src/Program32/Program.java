package Program32;

public class Program {
	public static void main(String[] args) {
		System.out.println(PresidentOfUsa.getInstance().getAge());
		PresidentOfUsa.getInstance().setAge(50);
		System.out.println(PresidentOfUsa.getInstance());
		System.out.println(PresidentOfUsa.getInstance().getAge());
		System.out.println("--before---^-");
		PresidentOfUsa presidentOfUsa = PresidentOfUsa.getInstance();
		System.out.println(presidentOfUsa);
		presidentOfUsa.setLive("USA");
		System.out.println(presidentOfUsa);
		System.out.println(PresidentOfUsa.getInstance().getLive());
	}

}
