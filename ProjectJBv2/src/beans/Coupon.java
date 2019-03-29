package beans;

import java.util.Date;

import enums.Category;

/**
 * This class create a coupon
 * 
 * @author Lichay
 *
 */
public class Coupon {

	// properties

	private long id;
	private long companyId;
	private Category category;
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;
	private int amount;
	private double price;
	private String image;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id          Receive an id
	 * @param companyId   Receive a company id
	 * @param category    Receive a category
	 * @param title       Receive a title
	 * @param description Receive a description
	 * @param startDate   Receive a start date
	 * @param endDate     Receive an end date
	 * @param amount      Receive an amount for this coupon
	 * @param price       Receive a price
	 * @param image       Receive an image
	 */
	public Coupon(long id, long companyId, Category category, String title, String description, Date startDate,
			Date endDate, int amount, double price, String image) {
		this(companyId, category, title, description, startDate, endDate, amount, price, image);
		this.companyId = id;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param companyId   Receive a company id
	 * @param category    Receive a category
	 * @param title       Receive a title
	 * @param description Receive a description
	 * @param startDate   Receive a start date
	 * @param endDate     Receive an end date
	 * @param amount      Receive an amount for this coupon
	 * @param price       Receive a price
	 * @param image       Receive an image
	 */
	public Coupon(long companyId, Category category, String title, String description, Date startDate, Date endDate,
			int amount, double price, String image) {
		super();
		this.companyId = companyId;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}

	/**
	 * constructor for create a show for this class
	 * 
	 */
	public Coupon() {

	}

	// getter & setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
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
		return "Coupon [id=" + getId() + ", companyId=" + getCompanyId() + ", category=" + getCategory() + ", title="
				+ getTitle() + ", description=" + getDescription() + ", startDate=" + getStartDate() + ", endDate="
				+ getEndDate() + ", amount=" + getAmount() + ", price=" + getPrice() + ", image=" + getImage() + "]";
	}

}
