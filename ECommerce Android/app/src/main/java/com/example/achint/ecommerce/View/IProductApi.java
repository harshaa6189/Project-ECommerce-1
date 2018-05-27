package com.example.achint.ecommerce.View;

//import android.telecom.Call;

import com.example.achint.ecommerce.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IProductApi {

    @GET("add-to-cart")
    Call<Boolean> addToCart(@Path("productId") String productId,@Path("unitStock") int unitStock,@Path("userId") String userId);

    @GET("remove-from-cart")
    Call<Boolean> removeFromCart(@Path("productId") String productId,@Path("unitStock") int unitStock,@Path("userId") String userId);//(@Body Product product);

    @GET("cart-list-items")
    Call< List<ProductModel> > cartListItems(@Path("productId") String userId);

}

