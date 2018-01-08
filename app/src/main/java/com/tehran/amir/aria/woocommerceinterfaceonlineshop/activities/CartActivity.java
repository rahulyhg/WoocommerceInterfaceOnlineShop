package com.tehran.amir.aria.woocommerceinterfaceonlineshop.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;

public class CartActivity extends AppCompatActivity {
    private static final String TAG = "CartActivity";

    CardView mFinilizeButton ;
    RecyclerView mRecyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }
}
