package com.graphqljava.tutorial.retail.controller;

import com.graphqljava.tutorial.retail.model.Product;
import com.graphqljava.tutorial.retail.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private final ProductService productService;
    private final InputConverter inputConverter;

    public ProductController(final ProductService productService, final InputConverter inputConverter) {
        this.productService = productService;
        this.inputConverter = inputConverter;
    }

    @QueryMapping(name = "productById")
    public Product getProductById(final @Argument UUID id) {
        return this.productService.getProductById(id);
    }

    @QueryMapping(name = "allProducts")
    public List<Product> getProducts() {
        return this.productService.getAllProducts();
    }

    @QueryMapping(name = "allProductsWithLimit")
    public List<Product> getAllProductsWithLimit(final @Argument int limit) {
        return this.productService.getAllProductsLimitedTo(limit);
    }

    @MutationMapping(name = "createProduct")
    public Product createProduct(final @Argument ProductInput productInput) {
        Product product = inputConverter.convert(productInput);

        return this.productService.createProduct(product);
    }

    @MutationMapping(name = "deleteProductById")
    public Product deleteProductById(final @Argument UUID id) {
        this.productService.deleteProductById(id);

		return null;
    }

}
