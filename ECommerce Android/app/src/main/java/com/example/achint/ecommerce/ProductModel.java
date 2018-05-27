package com.example.achint.ecommerce;

public class ProductModel {


    private String productName;

    private String productId;

    private String productPrice;

    private String productImageURL;


    public ProductModel() {
    }

    public ProductModel(String productName, String productId, String productPrice, String productImageURL) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productImageURL = productImageURL;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageURL() {
        return productImageURL;
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
                '}';
    }
}
