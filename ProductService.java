package com.pro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pro.dao.ProductDao;
import com.pro.entity.Product;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    // Single product insertion
    public String insertProduct(Product product) {
        productDao.insertProduct(product);
        return "Product inserted successfully!";
    }

    // Multiple products insertion
    public String insertMultipleProducts(List<Product> products) {
        productDao.insertMultipleProducts(products);
        return "All products inserted successfully!";
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    // Get all products sorted by price in ascending order
    public List<Product> getAllProductsAscPrice() {
        return productDao.getAllProductsAscPrice();
    }

    // Get all products sorted by price in descending order
    public List<Product> getAllProductsDscPrice() {
        return productDao.getAllProductsDscPrice();
    }

    // Get products by category
    public List<Product> getProductsByCategory(String category) {
        return productDao.getProductsByCategory(category);
    }
}
