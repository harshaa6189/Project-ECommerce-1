package com.order.Order.DTO;

public class OrderDto {

    private Long cartId;
    private String productId;
    private String merchantId;
    private String userId;
    private double totalCost;

    public OrderDto(String productId, String userId, String merchantId, double totalCost) {
        this.productId = productId;
        this.merchantId = merchantId;
        this.userId = userId;
        this.totalCost = totalCost;
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
