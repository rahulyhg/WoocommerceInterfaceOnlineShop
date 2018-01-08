package com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.CONSTANTS;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.UnsafeOkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amir on 1/3/2018.
 */

public class ServiceGenerator {
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();
    private static Retrofit.Builder builder  =
            new Retrofit.Builder()
            .baseUrl(CONSTANTS.BASE_URL)
            .client(UnsafeOkHttpClient.getUnsafeHttpsClient())
            .addConverterFactory(GsonConverterFactory.create(gson)) ;

    private static Retrofit retrofit = builder.build() ;

    public static <S> S createService(Class<S>  serviceClass ){
        return retrofit.create(serviceClass) ;
    }


}
