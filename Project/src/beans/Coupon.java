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

	// property

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
	 * @param amount      Receive an amount
	 * @param price       Receive a price
	 * @param image       Receive an image
	 */
	public Coupon(long id, long companyId, Category category, String title, String description, Date startDate,
			Date endDate, int amount, double price, String image) {
		this(companyId, category, title, description, startDate, endDate, amount, price, image);
		this.id = id;
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
	 * @param amount      Receive an amount
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
	 */
	public Coupon() {
		super();

	}

	// getter & setter

	/**
	 * @return This function return an id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id Receive an id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return This function return a company id
	 */
	public long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId Receive a company id
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return This function return a category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category Receive a category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return This function return a title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title Receive a title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return This function return a description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description Receive a description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return This function return a start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate Receive a start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return This function return an end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate Receive an end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return This function return an amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount Receive an amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return This function receive a price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price Receive a price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return This function return an image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image Receive an image
	 */
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
