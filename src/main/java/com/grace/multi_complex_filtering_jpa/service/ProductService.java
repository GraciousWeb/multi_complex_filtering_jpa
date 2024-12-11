package com.grace.multi_complex_filtering_jpa.service;


import com.grace.multi_complex_filtering_jpa.model.Product;
import com.grace.multi_complex_filtering_jpa.repository.ProductRepository;
import com.grace.multi_complex_filtering_jpa.specification.ProductSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> filterProducts(String category, Double price, String name) {
        Specification<Product> specification = Specification.where(null);

        if (category != null) {
            specification = specification.and(ProductSpecification.hasCategory(category));
        }
        if (price != null) {
            specification = specification.and(ProductSpecification.hasPriceGreaterThan(price));
        }
        if (name != null) {
            specification = specification.and(ProductSpecification.hasNameLike(name));
        }

        return productRepository.findAll(specification);
    }
}

