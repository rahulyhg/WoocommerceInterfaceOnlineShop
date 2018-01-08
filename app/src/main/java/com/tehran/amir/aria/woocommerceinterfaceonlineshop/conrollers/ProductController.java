package com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers;

import android.content.Context;
import android.util.Log;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs.ProductAPI;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnProductAvailableCallback;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amir on 1/2/2018.
 */

public class ProductController {
    private static final String TAG = "ProductController";
    Context mContext ;
    OnProductAvailableCallback mListener ;
    public ProductController(Context context , Object object ) {
        mContext = context ;
        if (object instanceof  OnProductAvailableCallback){
            mListener = (OnProductAvailableCallback)object ;
        }else {
            throw new IllegalArgumentException("caller must implement "
                    +OnProductAvailableCallback.class.getName()) ;
        }
    }

    public void getProduct(int id){
        Log.d(TAG, "getProduct: called");
        ProductAPI productAPI = ServiceGenerator.createService(ProductAPI.class);
        productAPI.getProduct(id).enqueue(getProductCallback);

    }

    public void getProducts(int page , String searchPhrase , String orderby){
        ProductAPI productAPI = ServiceGenerator.createService(ProductAPI.class);
        productAPI.getProducList(page , searchPhrase , orderby)
                .enqueue(getProductsListCallbackk);
    }

    public void getProductByCategory(int page , String searchPhrase , int category){
        ProductAPI productAPI = ServiceGenerator.createService(ProductAPI.class);
        productAPI.getProducListByCategory(page , searchPhrase , category)
                .enqueue(getProductsListCallbackk);
    }


    Callback<Product> getProductCallback  = new Callback<Product>() {
        @Override
        public void onResponse(Call<Product> call, Response<Product> response) {
            if (response.isSuccessful()){
                Log.d(TAG, "onResponse: called");
                Product product = response.body() ;
                if (mListener !=null){
                    mListener.onProductAvailable(product);
                }
            }else {
                Log.e(TAG, "onResponse: response not successful");
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.headers().toString());
            }
        }

        @Override
        public void onFailure(Call<Product> call, Throwable t) {
            Log.d(TAG, "onFailure: called");
            t.printStackTrace();
            Log.e(TAG, "onFailure: can't get product", t);
        }
    };


    Callback<List<Product>> getProductsListCallbackk = new Callback<List<Product>>() {
        @Override
        public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
            if (response.isSuccessful()){
                Log.d(TAG, "onResponse: called successfully");
                List<Product> list = response.body() ;
                if (mListener != null){
                    mListener.onProductListAvailable(list);
                }
            }else {
                Log.e(TAG, "onResponse: response not successful");
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.headers().toString());
            }
        }

        @Override
        public void onFailure(Call<List<Product>> call, Throwable t) {
            Log.d(TAG, "onFailure: faild to get product list");
            t.printStackTrace();
            Log.e(TAG, "onFailure: can't get product list",t );
        }
    };


}
