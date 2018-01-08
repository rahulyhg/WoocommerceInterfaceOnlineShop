package com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Order;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by amir on 1/4/2018.
 */

public interface OrderApi {

    @POST("orders")
    Call<Order> createOrder(@Body Order order);

    @PUT("orders/{id}")
    Call<Order> updateOrder(@Body Order order , @Path("id") int id);

}
