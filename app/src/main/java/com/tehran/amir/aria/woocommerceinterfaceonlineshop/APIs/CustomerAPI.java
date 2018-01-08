package com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amir on 1/3/2018.
 */

public interface CustomerAPI {
    @POST("customers/")
    Call<Customer> createCustomer(@Body Customer customer);

    @GET("customers/{id}")
    Call<Customer> getCustomer(@Path("id") int id) ;

    @GET("customers")
    Call<List<Customer>> getCustomerByEmail(@Query("email") String email);

    @GET("customers")
    Call<List<Customer>> getCustomers() ;


}
