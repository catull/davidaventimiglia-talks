package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.model.OrderDetail;
import com.graphqljava.tutorial.retail.repository.OrderDetailRepository;
import com.graphqljava.tutorial.retail.repository.ProductRepository;
import com.graphqljava.tutorial.retail.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;

    public ProductService(
            final ProductRepository productRepository,
            final OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Product getProductById(final UUID id) {
        Product product = this.productRepository.findById(id).orElse(null);

        if (null == product) {
            return null;
        }

        List<OrderDetail> orderDetails = this.orderDetailRepository.findAllByProductId(id);
        product.setOrderDetails(orderDetails);

        return product;
    }

    public List<Product> getAllProducts() {
        return enhanceProducts(this.productRepository.findAll());
    }

    public List<Product> getAllProductsLimitedTo(final int limit) {
        return enhanceProducts(this.productRepository.findAllLimitedTo(limit));
    }

    private List<Product> enhanceProducts(final List<Product> products) {
        for (Product product : products) {
            List<OrderDetail> orderDetails = this.orderDetailRepository.findAllByProductId(product.getId());
            product.setOrderDetails(orderDetails);
        }

        return products;
    }

    public Product createProduct(final Product product) {
        return this.productRepository.save(product);
    }

    public void deleteProductById(final UUID id) {
        this.productRepository.deleteById(id);
    }
}
