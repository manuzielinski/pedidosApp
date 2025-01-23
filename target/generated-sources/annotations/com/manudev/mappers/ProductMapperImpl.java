package com.manudev.mappers;

import com.manudev.dto.ProductDTO;
import com.manudev.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T02:04:02-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId( product.getProductId() );
        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setStock( product.getStock() );
        productDTO.setActive( product.isActive() );

        return productDTO;
    }

    @Override
    public Product dtoToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.productId( productDTO.getProductId() );
        product.name( productDTO.getName() );
        product.description( productDTO.getDescription() );
        product.price( productDTO.getPrice() );
        product.stock( productDTO.getStock() );
        product.active( productDTO.isActive() );

        return product.build();
    }
}
