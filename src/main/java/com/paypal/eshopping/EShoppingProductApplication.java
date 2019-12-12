package com.paypal.eshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.paypal.eshopping.repository")
public class EShoppingProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShoppingProductApplication.class, args);
	}

}
