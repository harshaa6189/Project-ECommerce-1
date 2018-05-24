package com.ecommerce.ECommerce.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

@Document(collection = Product.COLLECTION_NAME)
public class Product {
    public static final String COLLECTION_NAME = "product";

    @Id
    private String Id;

    @NotNull(message = "Product Id mustn\'t be null")
    private String productId;

    @NotNull(message = "Product Name mustn\'t be null")
    private String productName;

    @NotNull(message = "product Price mustn\'t be null")
    private Double productPrice;

    private int unitStock;

    @NotNull(message = "Product Description mustn\'t be null")
    private String productDescription;

    @NotNull(message = "Product Merchant mustn\'t be null")
    private String productMerchant;

    private MultipartFile productImage;

    public Product(String id, @NotNull(message = "Product Id mustn\'t be null") String productId, @NotNull(message = "Product Name mustn\'t be null") String productName, @NotNull(message = "product Price mustn\'t be null") Double productPrice, int unitStock, @NotNull(message = "Product Description mustn\'t be null") String productDescription, @NotNull(message = "Product Merchant mustn\'t be null") String productMerchant, MultipartFile productImage) {
        Id = id;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitStock = unitStock;
        this.productDescription = productDescription;
        this.productMerchant = productMerchant;
        this.productImage = productImage;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getUnitStock() {
        return unitStock;
    }

    public void setUnitStock(int unitStock) {
        this.unitStock = unitStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductMerchant() {
        return productMerchant;
    }

    public void setProductMerchant(String productMerchant) {
        this.productMerchant = productMerchant;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
