package com.ecommerce.ECommerce.Service;

import com.ecommerce.ECommerce.DTO.ProductDto;
import com.ecommerce.ECommerce.Model.Product;
import com.ecommerce.ECommerce.Repository.ProductRepositoryInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductServiceInterface{

    @Autowired
    private ProductRepositoryInterface  productRepository;

    @Override
    public String createProduct(ProductDto product){
        Product productClass = new Product();
        BeanUtils.copyProperties(product, productClass);
        productRepository.save(productClass);
        return "Success";
    }

    @Override
    public int getMerchantRating(String productId) {
        List<Product> product =  productRepository.findByProductId(productId);
        return product.get(0).getMerchantRating();
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductById(String productId) {
        return productRepository.findByProductId(productId);
    }


}
