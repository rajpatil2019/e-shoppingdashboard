package com.paypal.eshopping.exception;

public class ProductNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 8167167005651724640L;
	public ProductNotFoundException() {}
	public ProductNotFoundException(String message) {
		super(message);
	}
}
