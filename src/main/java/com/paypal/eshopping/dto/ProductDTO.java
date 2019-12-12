package com.paypal.eshopping.dto;

import java.math.BigDecimal;

public class ProductDTO {

	private String product_id;
	private String name;
	private String category;
	private BigDecimal retail_price;
	private BigDecimal discounted_price;
	private boolean availability;
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getRetail_price() {
		return retail_price;
	}
	public void setRetail_price(BigDecimal retail_price) {
		
		this.retail_price = convert2DecimalPlaces(retail_price);;
	}
	public BigDecimal getDiscounted_price() {
		return discounted_price;
	}
	public void setDiscounted_price(BigDecimal discounted_price) {
		this.discounted_price = convert2DecimalPlaces(discounted_price);
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	private static BigDecimal convert2DecimalPlaces(BigDecimal bdValue) {
		BigDecimal bd = new BigDecimal(bdValue.doubleValue());
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);

        return bd;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", name=" + name + ", category=" + category + ", retail_price="
				+ retail_price + ", discounted_price=" + discounted_price + "]";
	}
	
}
