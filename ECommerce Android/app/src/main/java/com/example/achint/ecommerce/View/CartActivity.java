package com.example.achint.ecommerce.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.achint.ecommerce.Adapter.CartAdapter;
import com.example.achint.ecommerce.Model.Product;
import com.example.achint.ecommerce.ProductModel;
import com.example.achint.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity implements CartAdapter.IAdapterCommunicator{

    private IProductApi mIProductApi;
    private RecyclerView mRecyclerView;
    private CartAdapter mCartAdapter;
    private List<Product> mProductList = new ArrayList<>();
//    private String productId;
//    private int productQuantity;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_cart);

        Intent i =getIntent();
//        productId= i.getStringExtra("productId");
        userId = i.getStringExtra("productUser");
//        productQuantity = i.getIntExtra("productQuantity",0);

        mRecyclerView = findViewById(R.id.rv_cart_product_list);

        mCartAdapter = new CartAdapter(mProductList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager((this)));
        mRecyclerView.setAdapter(mCartAdapter);
        mIProductApi = AppController.getInstance().getClient().create(IProductApi.class);

        listCartItems();

//        addProductToCart();
    }



    private void listCartItems()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();

        Call< List<ProductModel> > call = mIProductApi.cartListItems(userId);

        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                progressDialog.dismiss();

                if (response.code() == 200) {

                    ArrayList<ProductModel> tempProductArray = (ArrayList<ProductModel>) response.body();

                    //Send pid's and receive their details

                    //Insert those product objects into mProductList

                    for(ProductModel productModel : tempProductArray)
                    {
                        mProductList.add(new Product(productModel.getProductName(),
                                productModel.getProductPrice(),1,productModel.getProductImageURL()));
                    }


                    mCartAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CartActivity.this, "Failed to Show Cart", Toast.LENGTH_LONG);
            }

        });
    }




    @Override
    public void deleteItem(final int position) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();

        Product product = mProductList.get(position);

        Call<Boolean> call = mIProductApi.removeFromCart(product.getProductId(),
                product.getProductQuantity(),product.getUserId());

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                progressDialog.dismiss();

                if (response.code() == 200 && response.body() == true) {
                    mProductList.remove(position);
                    mCartAdapter.notifyItemRemoved(position);
                    Toast.makeText(CartActivity.this, "Successfully removed product from Cart", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CartActivity.this, "Failed to remove product from Cart", Toast.LENGTH_LONG);
            }
        });
    }
}

/*

        call.enqueue(new Callback<List<ProductDto>>() {
            @Override
            public void onResponse(Call<List<ProductDto>> call, Response<List<ProductDto>> response) {
                progressDialog.dismiss();

                if (response.code() == 200) {

                    ArrayList<ProductDto> tempProductArray = (ArrayList<ProductDto>) response.body();

                    //Send pid's and receive their details

                    //Insert those product objects into mProductList

                    mCartAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<ProductDto>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CartActivity.this, "Failed to Show Cart", Toast.LENGTH_LONG);
            }

        });

 */


