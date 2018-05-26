package com.example.demo.Model;

public class ProductModel {

    private String productName;

    private String productId;

    private String productPrice;

    private String productImageURL;

    private String userId;

    private int productQuantity;


    public ProductModel() {
    }

    public ProductModel(String productName, String productId, String productPrice, String productImageURL, String userId, int productQuantity) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productImageURL = productImageURL;
        this.userId = userId;
        this.productQuantity = productQuantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductImageURL() {
        return productImageURL;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }


    @Override
    public String toString() {
        return "ProductModel{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productImageURL='" + productImageURL + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
