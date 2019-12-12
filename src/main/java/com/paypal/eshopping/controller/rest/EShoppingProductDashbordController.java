package com.paypal.eshopping.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.paypal.eshopping.dto.HttpResponseDTO;
import com.paypal.eshopping.dto.ProductDTO;
import com.paypal.eshopping.service.EShoppingProductServiceI;

@RestController
@RequestMapping("e-shopping/dashboard")
public class EShoppingProductDashbordController {

	@Autowired
	public EShoppingProductServiceI productService;
	
   @PostMapping("/products")	
   public ResponseEntity<HttpResponseDTO<String>> addProduct(@RequestBody ProductDTO product){
	   productService.saveProduct(product);
	   HttpResponseDTO<String> response=new HttpResponseDTO<>();
	   response.setPayload("Successfully added a product to DB.");
	   return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }
   
   @GetMapping("/products/{product_id}")	
   public ResponseEntity<HttpResponseDTO<ProductDTO>> getProductbyProductId(@PathVariable("product_id") Long productId){
	   
	   HttpResponseDTO<ProductDTO> response=new HttpResponseDTO<>(); 
	   ProductDTO productDTO=productService.retieveProductByProductId(productId);
	   response.setPayload(productDTO);
	   return ResponseEntity.status(HttpStatus.OK).body(response);
   }
   
   @GetMapping("/products/sortByProductId")	
   public ResponseEntity<HttpResponseDTO<List<ProductDTO>>> retrieveProductsAndSortByProductId(){
	
	   HttpResponseDTO<List<ProductDTO>> response=new HttpResponseDTO<>(); 
	   
	   List<ProductDTO> productDTOList=productService.retieveAllProductsSortByProductId();
	   response.setPayload(productDTOList);
	   
	   return ResponseEntity.status(HttpStatus.OK).body(response);
	  
   }
   
   @GetMapping("/products/byCatagory")	
   public ResponseEntity<HttpResponseDTO<List<ProductDTO>>> retieveAllAvailableProductsByCategory(@RequestParam("category") String category ){

	   HttpResponseDTO<List<ProductDTO>> response=new HttpResponseDTO<>(); 
	   
	   List<ProductDTO> productDTOList=productService.retieveAllAvailableProductsByCategory(category);
	   response.setPayload(productDTOList);
	   
	   return ResponseEntity.status(HttpStatus.OK).body(response);
   }
   
   @GetMapping("/products/byCatagoryAndAvailability")	
   public ResponseEntity<HttpResponseDTO<List<ProductDTO>>> retieveAllAvailableProductsByCategoryAndAvailability(@RequestParam("category") String category,@RequestParam("availability") boolean availability ){

	   HttpResponseDTO<List<ProductDTO>> response=new HttpResponseDTO<>(); 
	   
	   List<ProductDTO> productDTOList=productService.retieveAllProductsByCategoryAndAvailability(category,availability);
	   response.setPayload(productDTOList);
	   
	   return ResponseEntity.status(HttpStatus.OK).body(response);
   }
}
