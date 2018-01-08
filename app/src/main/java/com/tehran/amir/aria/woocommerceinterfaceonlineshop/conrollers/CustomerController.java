package com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers;

import android.content.Context;
import android.util.Log;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs.CustomerAPI;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Customer;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnCustomerAvailable;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amir on 1/3/2018.
 */

public class CustomerController {
    private static final String TAG = "CustomerController";

    Context mContext ;
    OnCustomerAvailable mListener ;

    public CustomerController(Context context, Object listener) {
        mContext = context;
        if (listener instanceof OnCustomerAvailable){
            mListener = (OnCustomerAvailable)listener ;
        }else {
            throw new IllegalArgumentException("caller must implement "
                    +OnCustomerAvailable.class.getName()) ;
        }
    }

    public void getCustomer(int id){
        CustomerAPI customerAPI = ServiceGenerator.createService(CustomerAPI.class) ;
        customerAPI.getCustomer(id).enqueue(mCustomerCallback);
    }

    public void getCustomerByEmail(String email){
        CustomerAPI customerAPI = ServiceGenerator.createService(CustomerAPI.class) ;
        customerAPI.getCustomerByEmail(email).enqueue(mCustomerListCallback);
    }
    public void getCustomerList(){
        CustomerAPI customerAPI = ServiceGenerator.createService(CustomerAPI.class) ;
        customerAPI.getCustomers().enqueue(mCustomerListCallback);
    }

    public void createCustomer(Customer customer){
        Log.d(TAG, "createCustomer: called");
        CustomerAPI customerAPI = ServiceGenerator.createService(CustomerAPI.class) ;
        customerAPI.createCustomer(customer).enqueue(mCustomerCallback);
    }


    Callback<Customer> mCustomerCallback = new Callback<Customer>() {
        @Override
        public void onResponse(Call<Customer> call, Response<Customer> response) {
            if (response.isSuccessful()){
                Customer customer = response.body() ;
                if (mListener != null){
                    Log.d(TAG, "onResponse: called");
                    mListener.onCustomerAvailable(customer);
                }
            }else {
                Log.e(TAG, "onResponse: response not successful");
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.headers().toString());
            }
        }

        @Override
        public void onFailure(Call<Customer> call, Throwable t) {
            t.printStackTrace();
            Log.e(TAG, "onFailure: can't get customer" , t);
        }
    };

    Callback<List<Customer>> mCustomerListCallback = new Callback<List<Customer>>() {
        @Override
        public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
            if (response.isSuccessful()){
                List<Customer> customerList = response.body() ;
                if (mListener != null){
                    mListener.onCustomersListAvailable(customerList);
                }else {
                    Log.e(TAG, "onResponse: response not successful");
                    Log.d(TAG, "onResponse: "+response.message());
                    Log.d(TAG, "onResponse: "+response.headers().toString());
                }
            }
        }

        @Override
        public void onFailure(Call<List<Customer>> call, Throwable t) {
            t.printStackTrace();
            Log.e(TAG, "onFailure: can't get customers list" , t);
        }
    };
}
