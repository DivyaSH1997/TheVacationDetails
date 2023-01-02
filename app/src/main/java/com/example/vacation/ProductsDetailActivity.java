package com.example.vacation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProductsDetailActivity extends AppCompatActivity {

    TextView txtProductTitle,txtProductPrice;
    ImageView imgProduct;
    Button btnback;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        initViews();
        inputExtraction();
        initListeners();
    }
    public void initListeners()
    {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initViews(){

        imgProduct = findViewById(R.id.imgpic);
        txtProductTitle = findViewById(R.id.txtplace);
        txtProductPrice = findViewById(R.id.txtprice);
        btnback=findViewById(R.id.btnback);
    }

    private void inputExtraction(){
        Intent intent = getIntent();

        Product product = (Product) intent.getSerializableExtra("product");
        imgProduct.setImageResource(product.getImageId());
        txtProductTitle.setText(product.getTitle());
        txtProductPrice.setText(product.getPrice()+"");
    }
}
