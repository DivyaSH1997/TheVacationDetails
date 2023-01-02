package com.example.vacation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products;
    RecyclerView recyclerProducts;
    ProductsAdapter productsAdapter;
    String[] placenames;
    TypedArray imageplaces;
    int[] srno;
    int[] placeprice;
    Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDetailsofResources();

        initProducts();
        initViews();

    }

    public void getDetailsofResources()
    {
        resources=getResources();
        placenames=resources.getStringArray(R.array.placesnames);
        imageplaces=resources.obtainTypedArray(R.array.picslist);
        srno=resources.getIntArray(R.array.srno);
        placeprice=resources.getIntArray(R.array.placeprices);

    }

    private void initViews(){
        recyclerProducts = findViewById(R.id.recycleritems);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        productsAdapter = new ProductsAdapter(products);
        recyclerProducts.setAdapter(productsAdapter);
    }


    private void initProducts(){
        products = new ArrayList<>();
        int length=srno.length;
        for(int i = 0; i<length;i++){

            products.add(
                    new Product(srno[i], placenames[i],placeprice[i],imageplaces.getResourceId(i,0)));

        }
    }
}