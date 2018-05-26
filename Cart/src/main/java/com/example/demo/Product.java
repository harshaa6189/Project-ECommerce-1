package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;

@Document(collection = Product.COLLECTION_NAME)
public class Product {

    public static final String COLLECTION_NAME = "CartDetails";

    @Id
    private String userId;
    private ArrayList<DbObject> productList;

    public Product(String userId, ArrayList<DbObject> productList) {
        this.userId = userId;
        this.productList = productList;
    }

    public Product() {
    }


    public String getUserId() {
        return userId;
    }

    public ArrayList<DbObject> getProductList() {
        return productList;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProductList(ArrayList<DbObject> productList) {
        this.productList = productList;
    }


    @Override
    public String toString() {
        return "Product{" +
                "userId='" + userId + '\'' +
                ", productList=" + productList +
                '}';
    }
}