package class2;

public class NoteMain {
	public static void main(String[] args) {
		Note n1 = new Note("java", "i love java", "10,12,1992", "open");
		Note n2 = new Note("pp", "i love java", "10,12,1992", "open");
		Note n3 = new Note("pxxx", "i love java", "10,12,1992", "open");
		System.out.println(n1);
		Group g1 = new Group("ios");
		g1.addNote(n1);
		g1.addNote(n2);
		g1.addNote(n3);
		System.out.println(g1.getNote(1));
		
	}

}
