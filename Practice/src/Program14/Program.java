package Program14;

public class Program {
	public static void main(String[] args) {
		AcousticGuitar a1 = new AcousticGuitar("nissan", 2400);
		System.out.println(a1);
		AcousticGuitar a2 = new AcousticGuitar("nissan", 2400);
		System.out.println(a2);
		AcousticGuitar a3 = new AcousticGuitar("nissan", 240);
		AcousticGuitar a4 = new AcousticGuitar("nsan", 20);
		AcousticGuitar a5 = new AcousticGuitar("sd", 700);
		AcousticGuitar a6 = new AcousticGuitar("od", 8400);
		ElectricGuitar e1 = new ElectricGuitar("wooe", 6400);
		System.out.println(e1);
		AcousticGuitar.list.add(a1);
		AcousticGuitar.list.add(a2);
		AcousticGuitar.list.add(a3);
		AcousticGuitar.list.add(a4);
		AcousticGuitar.list.add(a5);
		AcousticGuitar.list.add(a6);
		System.out.println(AcousticGuitar.printAcousticGuitar());
		AcousticGuitar.sellAcousticGuitar(1);
		AcousticGuitar.sellAcousticGuitar(1);

		System.out.println(AcousticGuitar.printAcousticGuitar());
	}
}
