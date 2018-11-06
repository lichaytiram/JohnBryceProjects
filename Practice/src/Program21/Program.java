package Program21;

public class Program {
	public static void main(String[] args) {
		PlainTextDocument p1 = new PlainTextDocument("program1", 50, "abcdefghijklmnopqrstuvwxyz");
		PlainTextDocument p2 = new PlainTextDocument("program2", 50, "abcdefghijklmnopqrstuvwxyz");
		WordDocument p3 = new WordDocument("program3", 50, "abcdefghijklmnopqrstuvwxyz");
		Folder f = new Folder();
		f.addDocumentToArr(p1);
		f.addDocumentToArr(p2);
		f.addDocumentToArr(p3);
		f.printDocument("program1");
	}
}
