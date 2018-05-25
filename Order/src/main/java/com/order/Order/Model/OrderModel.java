package com.order.Order.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderModel {

    @Id
    @GeneratedValue
    private Long cartId;

    private String productId;
    private String merchantId;
    private String userId;
    private double totalCost;

    public OrderModel(String productId, String userId, String merchantId, double totalCost) {
        this.productId = productId;
        this.merchantId = merchantId;
        this.userId = userId;
        this.totalCost = totalCost;
    }

    public OrderModel() {

    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
