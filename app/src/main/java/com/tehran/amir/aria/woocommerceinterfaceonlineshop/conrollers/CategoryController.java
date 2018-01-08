package com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers;

import android.content.Context;
import android.util.Log;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs.ProductCategoryAPI;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductCategory;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnCategoryAvailable;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by amir on 1/3/2018.
 */

public class CategoryController {
    private static final String TAG = "CategoryController";
    Context mContext ;
    OnCategoryAvailable mListener;

    public CategoryController(Context context, Object listener) {
        mContext = context;
        if (listener instanceof OnCategoryAvailable){
            mListener = (OnCategoryAvailable)listener;
        }else {
            throw new IllegalArgumentException("caller must implement "
                    +OnCategoryAvailable.class.getName()) ;
        }
    }

    public void getCategories(){
        ProductCategoryAPI productCategoryAPI =
                ServiceGenerator.createService(ProductCategoryAPI.class) ;
        productCategoryAPI.getAllCategories().enqueue(getProductCallback);
    }

    public void createNewCategory(ProductCategory productCategory){
        Log.d(TAG, "createNewCategory: called");
        ProductCategoryAPI productCategoryAPI =
                ServiceGenerator.createService(ProductCategoryAPI.class) ;
        productCategoryAPI.createNewCategory(productCategory)
                .enqueue(mProductCategoryCallback);
    }

    Callback<List<ProductCategory>> getProductCallback  =
            new Callback<List<ProductCategory>>(){

                @Override
                public void onResponse(Call<List<ProductCategory>> call, Response<List<ProductCategory>> response) {
                    if (response.isSuccessful()){
                        Log.d(TAG, "onResponse: called");
                        List<ProductCategory> product = response.body() ;
                        if (mListener !=null){
                            mListener.onCategoryListAvailable(product);
                        }
                    }else {
                        Log.e(TAG, "onResponse: response not successful");
                        Log.d(TAG, "onResponse: "+response.message());
                        Log.d(TAG, "onResponse: "+response.headers().toString());
                        mListener.onCategoryNotAvailable();
                    }
                }

                @Override
                public void onFailure(Call<List<ProductCategory>> call, Throwable t) {
                    Log.d(TAG, "onFailure: can't get category list");
                    mListener.onCategoryNotAvailable();
                }
            };

    Callback<ProductCategory> mProductCategoryCallback =
            new Callback<ProductCategory>() {
                @Override
                public void onResponse(Call<ProductCategory> call, Response<ProductCategory> response) {
                    if (response.isSuccessful()){
                        Log.d(TAG, "onResponse: called");
                        ProductCategory product = response.body() ;
                        if (mListener !=null){
                            mListener.onCategoryAvailable(product);
                        }
                    }else {
                        Log.e(TAG, "onResponse: response not successful");
                        Log.d(TAG, "onResponse: "+response.message());
                        Log.d(TAG, "onResponse: "+response.headers().toString());
                    }
                }

                @Override
                public void onFailure(Call<ProductCategory> call, Throwable t) {
                    Log.e(TAG, "onFailure: can't find category",t );
                }
            };

}
