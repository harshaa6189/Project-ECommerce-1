package com.example.achint.ecommerce.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.achint.ecommerce.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartButtonTest extends AppCompatActivity {

    Button btCart;
    Button btMyCart;
    IProductApi mIProductApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_button_test);

        mIProductApi = AppController.getInstance().getClient().create(IProductApi.class);

        btCart = findViewById(R.id.bt_cart);
        btMyCart = findViewById(R.id.bt_mycart);

        btCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartButtonTest.this , CartActivity.class);

                intent.putExtra("productId","123");
                intent.putExtra("productUser","Achint");
                intent.putExtra("productQuantity",1);

                startActivity(intent);
            }
        });


        btMyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartButtonTest.this , CartActivity.class);

                intent.putExtra("productUser","Achint");

                startActivity(intent);
            }
        });
    }


    private void addProductToCart()//(final String productId, final int unitStock, final String userId)
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();

        String productId = "1234";
        int productQuantity = 1;
        String userId = "xyz";

        Call<Boolean> call = mIProductApi.addToCart(productId,productQuantity,userId);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                progressDialog.dismiss();
                if (200 == response.code() && response.body() == true) {
//                    mProductList.add(new Product(userId,productId,unitStock));
//                    mCartAdapter.notifyDataSetChanged();
//                    finish();

                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CartButtonTest.this, "Failed to fetch", Toast.LENGTH_LONG);
            }
        });
    }
}
