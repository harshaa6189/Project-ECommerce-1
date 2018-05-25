package com.ecommerce.ECommerce.Repository;

import com.ecommerce.ECommerce.Model.Product;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface extends MongoRepository<Product, String> {
    List<Product> findByProductId(String productId);

    List<Product> findByProductCategory(String productId);

    List<Product> findByProductPrice();
}
