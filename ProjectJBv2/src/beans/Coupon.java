package beans;

import java.util.Date;

import enums.Category;
import exception.ExceptionName;

/**
 * This class create a coupon
 * 
 * @author Lichay
 *
 */
public class Coupon extends BaseAttribute {

	// properties

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
	 * @param category    Receive a category from enum list
	 * @param title       Receive a title
	 * @param description Receive a descripotion
	 * @param startDate   Receive a start date
	 * @param endDate     Receive an end date
	 * @param amount      Receive an amount for this coupon
	 * @param price       Receive a price
	 * @param image       Receive an image
	 * @throws ExceptionName Throw an exception by name
	 */
	public Coupon(long id, long companyId, Category category, String title, String description, Date startDate,
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

	/**
	 * constructor for create a show for this class
	 * 
	 * @param companyId   Receive a company id
	 * @param category    Receive a category from enum list
	 * @param title       Receive a title
	 * @param description Receive a descripotion
	 * @param startDate   Receive a start date
	 * @param endDate     Receive an end date
	 * @param amount      Receive an amount for this coupon
	 * @param price       Receive a price
	 * @param image       Receive an image
	 * @throws ExceptionName Throw an exception by name
	 */
	public Coupon(long companyId, Category category, String title, String description, Date startDate, Date endDate,
			int amount, double price, String image) throws ExceptionName {
		super();
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

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id          Receive an id
	 * @param companyId   Receive a company id
	 * @param category    Receive a category from enum list
	 * @param title       Receive a title
	 * @param description Receive a descripotion
	 * @param price       Receive a price
	 * @param image       Receive an image
	 * @throws ExceptionName Throw an exception by name
	 */
	public Coupon(long id, long companyId, Category category, String title, String description, double price,
			String image) throws ExceptionName {
		super(id);
		setCompanyId(companyId);
		setCategory(category);
		setTitle(title);
		setDescription(description);
		setPrice(price);
		setImage(image);
	}

	// getter & setter

	/**
	 * @return This function return a id
	 */
	public long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId This function receive a company id and set new one if valid
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setCompanyId(long companyId) throws ExceptionName {
		if (companyId > 0)
			this.companyId = companyId;
		else
			throw new ExceptionName("Your Id must contain at least 1 digit!");
	}

	/**
	 * @return This function return a category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category This function set a new category
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
	 * @param title This function set a new title if valid
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setTitle(String title) throws ExceptionName {
		if (title.length() < 2)
			throw new ExceptionName("The title too short");
		this.title = title;
	}

	/**
	 * @return This function return a description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description This function set a new description
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
	 * @param startDate This function receive a start date and set a new one
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setStartDate(Date startDate) throws ExceptionName {
		if (endDate != null && startDate.after(this.endDate))
			throw new ExceptionName("The start date isn't vaild (must be before end date)");
		this.startDate = startDate;
	}

	/**
	 * @return This function return an end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate This function receive end date and set a new one
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setEndDate(Date endDate) throws ExceptionName {
		if (startDate != null && endDate.before(this.startDate))
			throw new ExceptionName("The end date isn't vaild (must be after start date)");
		this.endDate = endDate;
	}

	/**
	 * @return This function return an amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount This function receive an amount and set new one if valid
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setAmount(int amount) throws ExceptionName {
		if (amount < 0)
			throw new ExceptionName("The amount must be more then 0 or equal");
		this.amount = amount;
	}

	/**
	 * @return This function return a price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price This function receive a price and set a new one if valid
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setPrice(double price) throws ExceptionName {
		if (price > 0)
			this.price = price;
		else
			throw new ExceptionName("The price must be more then 0$");
	}

	/**
	 * @return This function return an image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image This function receive an image and set new one if valid
	 * @throws ExceptionName Throw an exception by name
	 */
	public void setImage(String image) throws ExceptionName {
		if (!(image.contains(".")) || image.charAt(image.length() - 1) == '.' || image.charAt(0) == '.')
			throw new ExceptionName("The image file invalid.");
		this.image = image;
	}

	/**
	 * @return This function return as string all attributes
	 */
	@Override
	public String toString() {
		return "Coupon->[" + super.toString() + ", companyId=" + getCompanyId() + ", category=" + getCategory()
				+ ", title=" + getTitle() + ", description=" + getDescription() + ", startDate=" + getStartDate()
				+ ", endDate=" + getEndDate() + ", amount=" + getAmount() + ", price=" + getPrice() + ", image="
				+ getImage() + "]";
	}

}
