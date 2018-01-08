package com.tehran.amir.aria.woocommerceinterfaceonlineshop.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductCategory;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnCategoryAvailable;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers.CategoryController;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity
        implements OnCategoryAvailable{
    private static final String TAG = "SplashActivity";
    public static final String CATEGORY_LIST = "SpalshActivity_CATEGORY_LIST";

    ProgressDialog mProgressDialog ;
    CategoryController mCategoryController ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        mCategoryController = new CategoryController(this , this) ;
        mProgressDialog = new ProgressDialog(this) ;
        getCategories();
    }

    private void getCategories(){
        mProgressDialog.show();
        mCategoryController.getCategories();
    }

    @Override
    public void onCategoryListAvailable(List<ProductCategory> list) {
        ArrayList<ProductCategory> arrayList = (ArrayList<ProductCategory>) list ;
        Intent intent = new Intent(this , MainActivity.class) ;
        if (list != null && list.size() > 0){
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(CATEGORY_LIST , arrayList);
            intent.putExtra(CATEGORY_LIST , bundle);
        }
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
        startActivity(intent);
    }

    @Override
    public void onCategoryAvailable(ProductCategory category) {
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onCategoryNotAvailable() {
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }
}
