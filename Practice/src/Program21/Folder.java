package Program21;

import java.util.Arrays;

public class Folder {
	private Document[] documentArr;

	public Folder() {
		this.documentArr = new Document[100];
	}

	public Document getDocumentArr(int index) {
		return documentArr[index];
	}

	public void addDocumentToArr(Document document) {
		for (int i = 0; i < documentArr.length; i++) {
			if (documentArr[i] == null) {
				documentArr[i] = document;
				System.out.println("The add is success!");
				break;
			}

		}
	}

	public void printDocument(String name) {
		for (int i = 0; i < documentArr.length; i++) {
			if (documentArr[i] != null) {
				if (documentArr[i].getNameFile().equals(name)) {
					System.out.println(documentArr[i]);
					break;
				}
			}
		}

	}

	@Override
	public String toString() {
		return "Folder [documentArr=" + Arrays.toString(documentArr) + "]";
	}

}
