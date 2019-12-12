package com.paypal.eshopping.dto;

public class HttpResponseDTO<T> {
	private T payload;
	private String error;

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	 
}
