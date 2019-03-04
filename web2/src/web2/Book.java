package web2;

public class Book {

	private int code;
	private String name;
	private String author;
	private double price;

	public Book(int code, String name, String author, double price) {
		super();
		this.code = code;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [code=" + code + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

}
