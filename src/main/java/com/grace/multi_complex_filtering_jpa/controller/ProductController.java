package com.grace.multi_complex_filtering_jpa.controller;

import com.grace.multi_complex_filtering_jpa.model.Product;
import com.grace.multi_complex_filtering_jpa.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String name) {
        return productService.filterProducts(category, price, name);
    }
}

