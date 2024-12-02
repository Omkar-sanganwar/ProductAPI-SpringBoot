package com.pro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pro.entity.Product;
import com.pro.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint to insert a single product
    @PostMapping("/insertProduct")
    public String insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    // Endpoint to insert multiple products
    @PostMapping("/MultiProducts")
    public String insertMultipleProducts(@RequestBody List<Product> products) {
        return productService.insertMultipleProducts(products);
    }

    // Endpoint to get all products
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Endpoint to get products by category
    @GetMapping("/getProductsByCategory")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    // Endpoint to get all products sorted by price in ascending order
    @GetMapping("/getAllProductsAscPrice")
    public List<Product> getAllProductsAscPrice() {
        return productService.getAllProductsAscPrice();
    }

    // Endpoint to get all products sorted by price in descending order
    @GetMapping("/getAllProductsDscPrice")
    public List<Product> getAllProductsDscPrice() {
        return productService.getAllProductsDscPrice();
    }
}
