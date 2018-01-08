package com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils;

import android.util.Log;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.OAuthToken;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by amir on 1/2/2018.
 */

public class GetInterceptor {
    private static final String TAG = "GetInterceptor";
    public static OkHttpClient getInterceptor(){
        final OAuthToken mOAuthToken = new OAuthToken();
        mOAuthToken.setAccessToken(CONSTANTS.WOOCOMMERCE_API_KEY);
        mOAuthToken.setTokenType(CONSTANTS.WOOCOMMERCE_SECRET_KEY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder =
                                request.newBuilder().header("Authorization" ,
                                        Credentials.basic(CONSTANTS.WOOCOMMERCE_API_KEY ,
                                                CONSTANTS.WOOCOMMERCE_SECRET_KEY));
                        Request newRequest1 = builder.build();
                        Log.d(TAG, "intercept: "+newRequest1.headers().toString());
                        return chain.proceed(newRequest1);
                    }
                }).build();
        return okHttpClient ;
    }
}
