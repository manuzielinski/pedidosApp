package com.manudev.controller;

import com.manudev.dto.ProductDTO;
import com.manudev.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.listAllProducts();
    }

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PutMapping("/{productId}")
    public ProductDTO updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productId, productDTO);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return "Se ha eliminado el producto: " + productId;
    }
}
