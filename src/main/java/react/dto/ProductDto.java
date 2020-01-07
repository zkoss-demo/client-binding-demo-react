/* ProductDto.java

	Purpose:
		
	Description:
		
	History:
		Fri Dec 20 15:27:57 CST 2019, Created by rudyhuang

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package react.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import react.model.Currency;
import react.model.Product;

/**
 * @author rudyhuang
 */
public class ProductDto {
	private int id;
	private long sku;
	private String title;
	private String description;
	private String style;
	private double price;
	private int installments;
	private String currencyId;
	private String currencyFormat;
	private boolean isFreeShipping;
	private List<String> availableSizes;

	public ProductDto() {
	}

	public ProductDto(Product p) {
		this.id = p.getId();
		this.sku = p.getSku();
		this.title = p.getTitle();
		this.description = p.getDescription();
		this.style = p.getStyle();
		this.price = p.getPrice();
		this.installments = p.getInstallments();
		this.currencyId = Optional.ofNullable(p.getCurrency()).map(Currency::getName).orElse("");
		this.currencyFormat = Optional.ofNullable(p.getCurrency()).map(Currency::getFormat).orElse("");
		this.isFreeShipping = p.isFreeShipping();
		this.availableSizes = new ArrayList<>(p.getAvailableSizes());
	}

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

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyFormat() {
		return currencyFormat;
	}

	public void setCurrencyFormat(String currencyFormat) {
		this.currencyFormat = currencyFormat;
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
