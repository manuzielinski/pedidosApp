package com.manudev.mappers;

import com.manudev.dto.ProductDTO;
import com.manudev.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToDTO(Product product);
    Product dtoToProduct(ProductDTO productDTO);
}

