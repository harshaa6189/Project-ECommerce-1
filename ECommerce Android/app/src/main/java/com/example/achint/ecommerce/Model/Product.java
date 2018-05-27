package com.example.achint.ecommerce.Model;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("productName")
    private String productName;

    @SerializedName("userId")//
    private String userId;

    @SerializedName("productId")//
    private String productId;

    @SerializedName("productPrice")
    private String productPrice;

    @SerializedName("productQuantity")//
    private int productQuantity;

    @SerializedName("productImageURL")
    private String productImageURL;


    public Product() {
    }

    public Product(String productName, String productPrice, int productQuantity, String productImageURL) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImageURL = productImageURL;
    }

    public Product(String productName, String userId, String productId, String productPrice, int productQuantity, String productImageURL) {
        this.productName = productName;
        this.userId = userId;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImageURL = productImageURL;
    }


    public String getUserId() {
        return userId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public String getProductId() {
        return productId;
    }




    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productQuantity=" + productQuantity +
                ", productImageURL='" + productImageURL + '\'' +
                '}';
    }
}
