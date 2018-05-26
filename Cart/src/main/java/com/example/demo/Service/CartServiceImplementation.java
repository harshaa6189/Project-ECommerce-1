package com.example.demo.Service;

import com.example.demo.DbObject;
import com.example.demo.Dto.ProductDto;
import com.example.demo.Model.ProductModel;
import com.example.demo.Product;
import com.example.demo.Repository.CartRepository;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*


import com.squareup.okhttp.*;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImplementation implements CartService {

    private static OkHttpClient client = new OkHttpClient();


    @Autowired
    private CartRepository cartRepository;

    @Override
    public boolean addToCart(ProductDto productDto) {

        DbObject dbObject = new DbObject(productDto.getProductId(),productDto.getUnitStock());

        boolean exists = cartRepository.existsById(productDto.getUserId());

        if(!exists)
        {
            ArrayList<DbObject> tempArray = new ArrayList<>();
            tempArray.add(dbObject);

            Product tempProduct = cartRepository.save(new Product(productDto.getUserId(), tempArray ));

            cartRepository.save(tempProduct);
        }
        else
        {
            Product tempProduct = cartRepository.findById(productDto.getUserId()).get();

            ArrayList<DbObject> tempArray = tempProduct.getProductList();
            tempArray.add(dbObject);
            tempProduct.setProductList(tempArray);
            cartRepository.save(tempProduct);
        }

        return true;

    }

    @Override
    public boolean removeFromCart(ProductDto productDto) {

        boolean exists = cartRepository.existsById(productDto.getUserId());

        if(!exists)
        {
            //############################################## Throw exception
        }

        Product tempProduct = cartRepository.findById(productDto.getUserId()).get();

        ArrayList<DbObject> tempArray = tempProduct.getProductList();
        DbObject mainObject=null;

        int objectIndex=0;
        int tempProductId=Integer.parseInt(productDto.getProductId());
        int tempDbProductId;
        boolean productCheckIfPresent=false;


        for(DbObject dbObject : tempArray)
        {
            tempDbProductId = Integer.parseInt(dbObject.getProductId());

            if(tempDbProductId == tempProductId )
            {
                mainObject = dbObject;

                productCheckIfPresent = true;

                break;
            }
            objectIndex++;
        }

        if(!productCheckIfPresent)
        {
            //################################################################# Throw Exception
        }

        if(mainObject.getUnitStock() > productDto.getUnitStock())
        {
            int unitStock = mainObject.getUnitStock();

            unitStock = unitStock - productDto.getUnitStock();

            mainObject.setUnitStock(unitStock);
            tempProduct.setProductList(tempArray);
            cartRepository.save(tempProduct);
        }
        else
        {
            tempArray.remove(objectIndex);
            tempProduct.setProductList(tempArray);
            cartRepository.save(tempProduct);
        }

        return true;
    }

//    @Override
//    public List<ProductDto> cartListItems(ProductDto productDto) {
    @Override
    public List<ProductModel> cartListItems(ProductDto productDto) throws IOException {

        boolean exists = cartRepository.existsById(productDto.getUserId());

        System.out.println("here : service");

        if(!exists)
        {
            System.out.println("here : service - error");
            //####################################################### Throw exception
        }

        Product tempProduct = cartRepository.findById(productDto.getUserId()).get();

        ArrayList<DbObject> tempArray = tempProduct.getProductList();
        ArrayList<ProductDto> dtoList = new ArrayList<ProductDto>();
        ArrayList<ProductModel> productModelList = new ArrayList<>();

        final String URL = "http://127.0.0.1:8080/cart/dummy";//########################### Change here

        final Gson gson = new Gson();

        for(DbObject dbObject : tempArray) {
            HttpUrl.Builder urlBuilder = HttpUrl.parse(URL).newBuilder();
            urlBuilder.addQueryParameter("productId", dbObject.getProductId());
            String url = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            int a=1;

            int b=0;

/*            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println("here");
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    if (!response.isSuccessful()) {

                        System.out.println("xyz");

                        throw new IOException("Unexpected code " + response);
                    } else {
                        // do something wih the result

                        ProductModel productModel = gson.fromJson(response.body().charStream(), ProductModel.class);
                        productModel.setUserId(productDto.getUserId());


                        productModelList.add(productModel);
                    }
                }

            });*/

            Response response = client.newCall(request).execute();

            ProductModel productModel = gson.fromJson(response.body().charStream(), ProductModel.class);
            productModel.setUserId(productDto.getUserId());


            productModelList.add(productModel);


        }




        return productModelList;

//        return dtoList;
    }
}

/*

            client.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Request request, IOException e) {
                    System.out.println("error");
                    //################################ Throw exception
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    if (!response.isSuccessful())
                    {
                        throw new IOException("Unexpected code " + response);
                    }

                    ProductModel productModel = gson.fromJson(response.body().charStream(), ProductModel.class);
                    productModel.setUserId(productDto.getUserId());


                    productModelList.add(productModel);
                }
            });

 */




/*

@Override
                                    public void onFailure(Call call, IOException e)
                                    {
                                        //Throw Exception

                                        e.printStackTrace();
                                    }

                                    @Override
                                    public void onResponse(Call call, final Response response) throws IOException {
                                        if (!response.isSuccessful())
                                        {
                                            throw new IOException("Unexpected code " + response);
                                        }

                                        ProductModel productModel = response.body();
                                        productModelList.add(productModel);
                                    }
 */

/*


        ProductDto tempProductDto = new ProductDto();

        for(DbObject dbObject : tempArray)
        {
            tempProductDto.setUserId(productDto.getUserId());
            tempProductDto.setProductId(dbObject.getProductId());
            tempProductDto.setUnitStock(dbObject.getUnitStock());

            dtoList.add(tempProductDto);
        }

 */