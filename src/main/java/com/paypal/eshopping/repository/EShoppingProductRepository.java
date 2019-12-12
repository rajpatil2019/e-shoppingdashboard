package com.paypal.eshopping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.paypal.eshopping.entiry.Product;

@Repository
public interface EShoppingProductRepository extends PagingAndSortingRepository<Product, Long> {	
	Optional<Product> findProductByProductId(Long productId);
	List<Product> findAll(Sort sort);
	List<Product> findProductsByCategory(String category,Sort sort);
	List<Product> findProductsByCategoryAndAvailabilityTrue(String category,Sort sort);	
	List<Product> findProductsByCategoryAndAvailability(String category,boolean availability,Sort sort);
	
}
