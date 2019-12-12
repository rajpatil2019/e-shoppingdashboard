package com.paypal.eshopping.service;

public class SaveProductException extends RuntimeException {	
	
	private static final long serialVersionUID = -7248783985655940825L;
	
	public SaveProductException() {}
	public SaveProductException(String message) {
		super(message);
	}
}
