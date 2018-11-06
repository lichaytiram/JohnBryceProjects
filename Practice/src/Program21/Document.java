package Program21;

public abstract class Document {
	private String nameFile;
	private int numberOfWords;
	private String text;

	public Document(String nameFile, int numberOfWords, String text) {
		super();
		this.nameFile = nameFile;
		this.numberOfWords = numberOfWords;
		this.text = text.length() <= numberOfWords ? text : text.substring(0, this.numberOfWords);
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text.length() <= numberOfWords ? text : text.substring(0, this.numberOfWords);
	}

	public void addText(String text) {
		this.text += text;
		if (this.text.length() > this.numberOfWords)
			this.text = this.text.substring(0, this.numberOfWords);
	}

	public void deleteAllText() {
		this.text = "";
	}

	public boolean sameDocument(Document document) {
		return this.nameFile.equals(document.nameFile);
	}

	@Override
	public String toString() {
		return "Document [nameFile=" + nameFile + ", numberOfWords=" + numberOfWords + ", text=" + text + "]";
	}

}
