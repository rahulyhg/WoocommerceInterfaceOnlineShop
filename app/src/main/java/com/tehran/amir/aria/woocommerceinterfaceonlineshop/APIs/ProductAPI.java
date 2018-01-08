package com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductReview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amir on 1/2/2018.
 */


public interface ProductAPI {

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") long id) ;

    @GET("products")
    Call<List<Product>> getProducList(
            @Query("page") int page ,
            @Query("search") String search,
            @Query("orderby") String orderBy
    );

    @GET("products")
    Call<List<Product>> getProducListByCategory(
            @Query("page") int page ,
            @Query("search") String search ,
            @Query("category") int category
    );



    @GET("products/<product_id>/reviews")
    Call<List<ProductReview>> getProductReviews(@Path("product_id") long id) ;
}
