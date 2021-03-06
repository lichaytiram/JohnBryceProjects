package coupons.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import coupons.enums.Category;

/**
 * This class create a coupon
 * 
 * @author Lichay
 *
 */
@Entity
@Table(name = "coupons")
public class Coupon implements Serializable {

	// properties

	private static final long serialVersionUID = 3463614049774120920L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false, unique = true, columnDefinition = "BIGINT(20) UNSIGNED")
	private long id;

	@Column(name = "CATEGORY", nullable = false, unique = false, length = 40)
	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(name = "TITLE", nullable = false, unique = false, length = 25)
	private String title;

	@Column(name = "DESCRIPTION", nullable = true, unique = false, length = 255)
	private String description;

	@Column(name = "START_DATE", nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "END_DATE", nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "AMOUNT", nullable = false, unique = false, columnDefinition = "INT(11) UNSIGNED")
	private int amount;

	@Column(name = "PRICE", nullable = false, unique = false, columnDefinition = "DOUBLE UNSIGNED")
	private double price;

	@Column(name = "IMAGE", nullable = true, unique = false, length = 50)
	private String image;

	@JoinColumn(name = "COMPANY", nullable = false, unique = false)
	@ManyToOne
	private Company company;

	@JsonIgnore
	@OneToMany(mappedBy = "coupon", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Purchase> purchases;

	// constructor

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

	// java persistence API

	/**
	 * @return This function return a company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company Receive a company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return This function return list of purchases
	 */
	public List<Purchase> getPurchases() {
		return purchases;
	}

	/**
	 * @param purchases Receive a purchases
	 */
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + getId() + ", category=" + getCategory() + ", title=" + getTitle() + ", description="
				+ getDescription() + ", startDate=" + getStartDate() + ", endDate=" + getEndDate() + ", amount="
				+ getAmount() + ", price=" + getPrice() + ", image=" + getImage() + "]";
	}

}
