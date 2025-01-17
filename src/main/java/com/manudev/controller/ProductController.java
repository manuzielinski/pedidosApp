package com.manudev.controller;

import com.manudev.entity.Product;
import com.manudev.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("{productId}")
    public Product updateProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("El producto no se encuentra con su id: " + id));

        product.setName(productDetails.get);
        product.setDescription();
        product.setPrice();
        product.setStock();
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("El producto no se encuentra con su id: " + id));

        product.setActive(false);
        productRepository.save(product);
        return "Se ha eliminado el producto: " + productId;
    }
}
