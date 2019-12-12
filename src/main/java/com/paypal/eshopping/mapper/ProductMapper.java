package com.paypal.eshopping.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import com.paypal.eshopping.dto.ProductDTO;
import com.paypal.eshopping.entiry.Product;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	@Mappings({	
		  @Mapping(target="productId", source="dto.product_id"),
	      @Mapping(target="name", source="dto.name"),
	      @Mapping(target="category", source="dto.category"),
	      @Mapping(target="retailPprice", source="dto.retail_price"),
	      @Mapping(target="discountedPrice", source="dto.discounted_price"),
		  @Mapping(target="availability", source="dto.availability")
	    })
	Product productDTOtoProduct(ProductDTO dto);
	
	@Mappings({	
		  @Mapping(target="product_id", source="product.productId"),
	      @Mapping(target="name", source="product.name"),
	      @Mapping(target="category", source="product.category"),
	      @Mapping(target="retail_price", source="product.retailPprice"),
	      @Mapping(target="discounted_price", source="product.discountedPrice"),
	      @Mapping(target="availability", source="product.availability")
	    })
	ProductDTO productToProductDTO(Product product);
	
	//CommentMapper INSTANCE = Mappers.getMapper( CommentMapper.class );
   // @Mapping(source  = "user.organisation.name", target = "user.organisation")
    List<ProductDTO> productListToProductDTOList(List<Product> products);
}