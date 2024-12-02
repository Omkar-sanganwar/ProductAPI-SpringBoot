package com.pro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate primary key
    private int pro_id;

    private String pro_name;
    private int price;
    private int mfg; // Manufacturing year
    private int exp; // Expiry year
    private String category; // New category field

    public Product() {
    }

    public Product(int pro_id, String pro_name, int price, int mfg, int exp, String category) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.price = price;
        this.mfg = mfg;
        this.exp = exp;
        this.category = category;
    }

    // Getters and setters
    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMfg() {
        return mfg;
    }

    public void setMfg(int mfg) {
        this.mfg = mfg;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [pro_id=" + pro_id + ", pro_name=" + pro_name + ", price=" + price + ", mfg=" + mfg + ", exp=" + exp + ", category=" + category + "]";
    }
}
