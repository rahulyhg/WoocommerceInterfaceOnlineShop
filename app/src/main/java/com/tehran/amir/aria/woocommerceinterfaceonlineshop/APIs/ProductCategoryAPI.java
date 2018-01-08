package com.tehran.amir.aria.woocommerceinterfaceonlineshop.APIs;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by amir on 1/3/2018.
 */

public interface ProductCategoryAPI {

    @POST("products/categories")
    Call<ProductCategory> createNewCategory(@Body ProductCategory productCategory);

    @GET("products/categories")
    Call<List<ProductCategory>> getAllCategories();
}
