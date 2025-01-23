package com.manudev.service.impl;

import com.manudev.dto.ProductDTO;
import com.manudev.entity.Product;
import com.manudev.mappers.ProductMapper;
import com.manudev.repository.ProductRepository;
import com.manudev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;


    @Override
    public List<ProductDTO> listAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToDTO)
                .collect(Collectors.toList());
    }

    // recordar que debemos de devolver el dto siempre.
    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return productMapper.productToDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.dtoToProduct(productDTO);
        productRepository.save(product);
        return productMapper.productToDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        Product updatedProduct = productMapper.dtoToProduct(productDTO);
        updatedProduct.setProductId(existingProduct.getProductId());
        updatedProduct = productRepository.save(updatedProduct);
        return productMapper.productToDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        product.setActive(false);
        productRepository.save(product);
    }
}
