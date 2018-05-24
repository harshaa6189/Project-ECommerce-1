package com.ecommerce.ECommerce.Service;

import com.ecommerce.ECommerce.DTO.ProductDto;
import com.ecommerce.ECommerce.Model.Product;

import java.util.List;

public interface ProductServiceInterface {
    public List<Product> getProductList();
    List<Product> getProductById(String productId);

    String createProduct(ProductDto product);

    int getMerchantRating(String productRating);
    
}
