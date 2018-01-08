package com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers;

import android.content.Context;
import android.media.MediaCodecList;
import android.util.Log;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs.OrderApi;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Order;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnOrderAvailableCallback;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amir on 1/4/2018.
 */

public class OrderController {
    private static final String TAG = "OrderController";
    Context mContext ;
    OnOrderAvailableCallback mListener ;

    public OrderController(Context context, Object listener) {
        mContext = context;
        if (listener instanceof  OnOrderAvailableCallback){
            mListener = (OnOrderAvailableCallback) listener ;
        }else {
            throw new IllegalArgumentException("caller must implement "
                    +OnOrderAvailableCallback.class.getName()) ;
        }
    }

    public void createOrder(Order order){
        OrderApi orderApi = ServiceGenerator.createService(OrderApi.class) ;
        orderApi.createOrder(order).enqueue(getOrderCallback);

    }

    public void updateOrder(Order order , int id ){
        OrderApi orderApi = ServiceGenerator.createService(OrderApi.class) ;
        orderApi.updateOrder(order , id).enqueue(getOrderCallback);

    }

    Callback<Order> getOrderCallback = new Callback<Order>() {
        @Override
        public void onResponse(Call<Order> call, Response<Order> response) {
            if (response.isSuccessful()){
                Order order = response.body() ;
                if (mListener != null){
                    Log.d(TAG, "onResponse: called");
                    mListener.onOrderAvailableCallback(order);
                }
            }else {
                Log.e(TAG, "onResponse: response not successful");
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.headers().toString());
            }
        }

        @Override
        public void onFailure(Call<Order> call, Throwable t) {
            t.printStackTrace(); ;
            Log.e(TAG, "onFailure: can't get order " , t);
        }
    };
}
