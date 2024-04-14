package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.repository.ProductRepository;
import com.graphqljava.tutorial.retail.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(final UUID id) {
        return this.productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public List<Product> getAllProductsLimitedTo(final int limit) {
        return this.productRepository.findAllLimitedTo(limit);
    }

    public Product createProduct(final Product product) {
        return this.productRepository.save(product);
    }

    public void deleteProductById(final UUID id) {
        this.productRepository.deleteById(id);
    }
}
