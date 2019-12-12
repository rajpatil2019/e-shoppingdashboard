package com.paypal.eshopping.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.paypal.eshopping.dto.ProductDTO;
import com.paypal.eshopping.entiry.Product;
import com.paypal.eshopping.exception.ProductNotFoundException;
import com.paypal.eshopping.mapper.ProductMapper;
import com.paypal.eshopping.repository.EShoppingProductRepository;

@Service
public class EShoppingProductServiceImpl implements EShoppingProductServiceI{

	public static final Logger LOGGER = LoggerFactory.getLogger(EShoppingProductServiceImpl.class);

	@Autowired
	private EShoppingProductRepository respository;
	
	public void saveProduct(ProductDTO productDTO){	
		String method="saveProduct";
		Product product = ProductMapper.INSTANCE.productDTOtoProduct(productDTO);
		LOGGER.info(method+" productDTO ->{}",productDTO);
		LOGGER.info(method+" product ->{}",product);
		
		respository.save(product);
	}
	
	public ProductDTO retieveProductByProductId(Long productId){	
		String method="retieveProductbyId :::: ";		
		Optional<Product> productOptional =respository.findProductByProductId(productId);
		
		if(!productOptional.isPresent()) {
			LOGGER.error(method+" Product Not Found for productId :{} ",productId);
			throw new ProductNotFoundException("Product Not Found for Id ::: "+productId);
		}
		Product product =productOptional.get();
		LOGGER.info(method+" product ->{} and productId -> {}",product,productId);
		ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product);
		
		return productDTO;
	}
	public List<ProductDTO> retieveAllProductsSortByProductId(){
		String method="retieveAllProducts : ";
		
		Sort sort = Sort.by("productId").ascending();		
		List<Product> productList =respository.findAll(sort);
		
		if(Objects.isNull(productList) || productList.isEmpty()) {
			LOGGER.error(method+" Products are not available>>. ");
			throw new ProductNotFoundException("Products are not available>>>>.");
		}
		List<ProductDTO> productDTOList = ProductMapper.INSTANCE.productListToProductDTOList(productList);
		LOGGER.info(method+" >>>>>> Product List ->{}",productList);
		LOGGER.info(method+" productDTOList List ->{}",productDTOList);
		return productDTOList;
	}
	
	public List<ProductDTO> retieveAllAvailableProductsByCategory(String category){
		String method="retieveAllProductsByCategoryAscenindOrder : ";
		
		Sort sort = Sort.by("discountedPrice").ascending()
				    .and(Sort.by("productId").ascending());		

		List<Product> productList =respository.findProductsByCategoryAndAvailabilityTrue(category,sort);
	    
		if(Objects.isNull(productList) || productList.isEmpty()) {
			LOGGER.error(method+" Products are not available. ");
			throw new ProductNotFoundException("Products are not available.");
		}
		
		List<ProductDTO> productDTOList = ProductMapper.INSTANCE.productListToProductDTOList(productList);
		LOGGER.info(method+" Product List ->{}",productList);
		LOGGER.info(method+" productDTOList List ->{}",productDTOList);
		return productDTOList;
	}
	
	public List<ProductDTO> retieveAllProductsByCategoryAndAvailability(String category,boolean availability){
		String method="retieveAllProductsByCategoryAscenindOrder : ";
		
		Sort sort = Sort.by("discountedPrice").ascending()
				    .and(Sort.by("productId").ascending());
		
		List<Product> productList =respository.findProductsByCategoryAndAvailability(category,availability,sort);
	    
		if(Objects.isNull(productList) || productList.isEmpty()) {
			LOGGER.error(method+" Products are not available. ");
			throw new ProductNotFoundException("Products are not available.");
		}
		
		List<ProductDTO> productDTOList = ProductMapper.INSTANCE.productListToProductDTOList(productList);
		LOGGER.info(method+" Product List ->{}",productList);
		LOGGER.info(method+" productDTOList List ->{}",productDTOList);
		return productDTOList;
	}
	
	
}

