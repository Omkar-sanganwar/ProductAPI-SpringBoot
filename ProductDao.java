package com.pro.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pro.entity.Product;

@Repository
public class ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    // Save a single product
    public void insertProduct(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Save multiple products
    public void insertMultipleProducts(List<Product> products) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            for (Product product : products) {
                session.save(product);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Get all products
    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();
            products = session.createQuery("from Product", Product.class).list(); 
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    // Get all products sorted by price in ascending order
    public List<Product> getAllProductsAscPrice() {
        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();
            products = session.createQuery("from Product order by price asc", Product.class).list(); 
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    // Get all products sorted by price in descending order
    public List<Product> getAllProductsDscPrice() {
        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();
            products = session.createQuery("from Product order by price desc", Product.class).list(); 
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    // Get products by category
    public List<Product> getProductsByCategory(String category) {
        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();
            products = session.createQuery("from Product where category = :category", Product.class)
                              .setParameter("category", category)
                              .list(); 
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }
}
