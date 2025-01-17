package com.manudev.service;

import com.manudev.dto.ProductDTO;
import com.manudev.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<ProductDTO> listAllProducts();
    ProductDTO getOrderById(Long productId);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long productId, ProductDTO productDTO);
    void deleteProduct(Long productId);
}