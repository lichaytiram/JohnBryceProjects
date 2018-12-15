package BaseProgram;

import java.util.Date;

import Exception.ExceptionName;

public class Coupon extends BaseAttribute {

	// properties

	// don't finish yet->

	private int companyId;
	private Category category;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private int amount;
	private double price;
	private String image;

	// constructor

	public Coupon(int id, int companyId, Category category, String title, String description, Date startDate,
			Date endDate, int amount, double price, String image) throws ExceptionName {
		super(id);
		setCompanyId(companyId);
		setCategory(category);
		setTitle(title);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setAmount(amount);
		setPrice(price);
		setImage(image);
	}

	// getter & setter

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) throws ExceptionName {
		if (companyId > 0)
			this.companyId = companyId;
		else
			throw new ExceptionName("Your Id must contain at least 1 digit!");
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon->[" + super.toString() + "companyId=" + getCompanyId() + ", category=" + getCategory()
				+ ", title=" + getTitle() + ", description=" + getDescription() + ", startDate=" + getStartDate()
				+ ", endDate=" + getEndDate() + ", amount=" + getAmount() + ", price=" + getPrice() + ", image="
				+ getImage() + "]";
	}

}
