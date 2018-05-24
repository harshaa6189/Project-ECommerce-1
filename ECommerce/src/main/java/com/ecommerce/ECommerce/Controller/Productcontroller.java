package com.ecommerce.ECommerce.Controller;


import com.ecommerce.ECommerce.DTO.ProductDto;
import com.ecommerce.ECommerce.Exception.ProductException;
import com.ecommerce.ECommerce.Model.Product;
import com.ecommerce.ECommerce.Service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class Productcontroller {

    @Autowired
    private ProductServiceInterface productService;

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String createProduct(@RequestBody ProductDto product){
        return productService.createProduct(product);
    }

    @RequestMapping("/getProductList")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getProductList();
        return products;
    }

    @RequestMapping("getProductById/{productId}")
    public List<Product> getProductById(@PathVariable(value = "productId") String productId){
        List<Product> product = productService.getProductById(productId);
        return product;
    }

    @RequestMapping("getMerchantRating")
    public int getMerchantRating(@PathVariable(value = "productId") String productId){
        return productService.getMerchantRating(productId);
    }


}
