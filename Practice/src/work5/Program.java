package work5;

public class Program {
	public static void main(String[] args) {
		Box b = new Box("dx");
		PrintBoxData(b);

		PlasticBox p = new PlasticBox("top", 20, 20, 2);
		PrintBoxData(p);

		CanBox c = new CanBox("tst", 20, 30);
		PrintBoxData(c);

		System.out.println("----------------- ARR BOX -----------------");
		Box[] arrB = new Box[4];
		for (int i = 0; i < arrB.length; i++) {
			if (i % 3 == 0)
				arrB[i] = new PlasticBox("PlasticBox", 2, 3, 5);
			else
				arrB[i] = new CanBox("canBox", 5, 5);
		}
		for (int i = 0; i < arrB.length; i++) {
			PrintBoxData(arrB[i]);
		}

	}

	public static void PrintBoxData(Box box) {
		System.out.println(box.getData());
	}

}
