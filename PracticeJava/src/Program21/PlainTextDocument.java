package Program21;

public class PlainTextDocument extends Document {

	public PlainTextDocument(String nameFile, int numberOfWords, String text) {
		super(nameFile, numberOfWords, text);
	}

	@Override
	public String toString() {
		String text = "";
		for (int i = 0; i < super.getText().length(); i++) {
			if (i % 9 == 0 && i != 0)
				text += "\n";
			text += super.getText().charAt(i);
		}

		return text;
	}

}
