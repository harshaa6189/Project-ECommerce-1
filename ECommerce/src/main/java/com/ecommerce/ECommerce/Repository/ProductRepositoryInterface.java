package com.ecommerce.ECommerce.Repository;

import com.ecommerce.ECommerce.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface extends MongoRepository<Product, String> {
    List<Product> findByProductId(String productId);
}
