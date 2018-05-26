package com.example.demo.Service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Model.ProductModel;

import java.io.IOException;
import java.util.List;

public interface CartService {

    boolean addToCart(ProductDto productDto);
    boolean removeFromCart(ProductDto productDto);
    List<ProductModel> cartListItems(ProductDto productDto) throws IOException;
    //    List<ProductDto> cartListItems(ProductDto productDto);
}
