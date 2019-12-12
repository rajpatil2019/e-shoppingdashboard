package com.paypal.eshopping.entiry;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.paypal.eshopping.util.BooleanToStringConverter;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private Long productId;
	
	@Column(unique = true)
	private String name;
	
	private String category;
	private BigDecimal retailPprice;
	private BigDecimal discountedPrice;
	
	@Convert(converter=BooleanToStringConverter.class)
	private boolean availability;
	
	public Long getId() {
		return id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
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
	public BigDecimal getRetailPprice() {
		return retailPprice;
	}
	public void setRetailPprice(BigDecimal retailPprice) {
		this.retailPprice = convert2DecimalPlaces(retailPprice);
	}
	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = convert2DecimalPlaces(discountedPrice);
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
		return "Product [id=" + id + ", productId=" + productId + ", name=" + name + ", category=" + category
				+ ", retailPprice=" + retailPprice + ", discountedPrice=" + discountedPrice + "]";
	}
}
