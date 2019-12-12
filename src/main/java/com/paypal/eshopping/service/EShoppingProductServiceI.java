package com.paypal.eshopping.service;

import java.util.List;
import com.paypal.eshopping.dto.ProductDTO;

public interface EShoppingProductServiceI {

	void saveProduct(ProductDTO productDTO);
	ProductDTO retieveProductByProductId(Long productId);
	List<ProductDTO> retieveAllProductsSortByProductId();
	List<ProductDTO> retieveAllAvailableProductsByCategory(String category);
	List<ProductDTO> retieveAllProductsByCategoryAndAvailability(String category,boolean availability);	
}
