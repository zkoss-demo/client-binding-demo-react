/* Product.java

	Purpose:
		
	Description:
		
	History:
		Thu Dec 19 10:21:58 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package react.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private long sku;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String style;
	@Column
	private double price;
	@Column
	private int installments;
	@OneToOne
	@JoinColumn(name = "currencyid")
	private Currency currency;
	@Column(name = "isfreeshipping")
	private boolean isFreeShipping;

	@ElementCollection
	@CollectionTable(name = "product_size")
	@Column(name = "size")
	private List<String> availableSizes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public boolean isFreeShipping() {
		return isFreeShipping;
	}

	public void setFreeShipping(boolean freeShipping) {
		isFreeShipping = freeShipping;
	}

	public List<String> getAvailableSizes() {
		return availableSizes;
	}

	public void setAvailableSizes(List<String> availableSizes) {
		this.availableSizes = availableSizes;
	}
}
