package com.example.demo.Controller;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Model.ProductModel;
import com.example.demo.Product;
import com.example.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add-to-cart")
    public boolean addToCart(@RequestParam String productId, @RequestParam int unitStock, @RequestParam String userId)
    {
        boolean check = cartService.addToCart(new ProductDto(productId, unitStock, userId));

        return check;
    }

    @RequestMapping(value = "/remove-from-cart")
    public boolean removeFromCart(@RequestParam String productId, @RequestParam int unitStock, @RequestParam String userId)
    {
        boolean check = cartService.removeFromCart(new ProductDto(productId, unitStock, userId));

        return check;
    }

//    @RequestMapping(value = "/cart-list-items")
//    public List<ProductDto> cartListItems(@RequestParam String userId)
    @RequestMapping(value = "/cart-list-items")
    public List<ProductModel> cartListItems(@RequestParam String userId)
    {
        System.out.println("here : controller");
//        List<ProductDto> productDtoList = cartService.cartListItems(new ProductDto(userId));
        List<ProductModel> productModelList = null;
        try {
            productModelList = cartService.cartListItems(new ProductDto(userId));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return productDtoList;
        return productModelList;
    }


    @RequestMapping(value="/dummy")
    public ProductModel dummy(@RequestParam String productId)
    {
        System.out.println("here : dummy");

        String pName="OnePlus 6";
        String pId="1234";
        String pPrice="Rs.40000";
        int pQuantity=1;
        String pImageURL="@drawable/oneplus6";
        String uId = "555";

        ProductModel tempProductModel = new ProductModel(pName,pId,pPrice,pImageURL,uId,pQuantity);

        return tempProductModel;
    }

}