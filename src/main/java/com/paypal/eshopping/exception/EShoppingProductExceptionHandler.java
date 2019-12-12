package com.paypal.eshopping.exception;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.paypal.eshopping.dto.HttpResponseDTO;

@RestControllerAdvice
public class EShoppingProductExceptionHandler {  
	
	@ExceptionHandler(HibernateException.class)
	public ResponseEntity<HttpResponseDTO<String>> handleDBException(HttpServletRequest request, Exception ex){

		 HttpResponseDTO<String> response=new HttpResponseDTO<>();
		 response.setError("Error while saving a product to DB. Please check the log for more information.");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<HttpResponseDTO<String>> handleProductNotFoundException(HttpServletRequest request, Exception ex){
	
		 HttpResponseDTO<String> response=new HttpResponseDTO<>();
		 response.setError(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
