package com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by amir on 1/3/2018.
 */

public class UnsafeOkHttpClient {
    private static final String TAG = "UnsafeOkHttpClient";
    public static final String ADD_AUTHORIZATION_TYPE_BASIC =
            "add_authorization_type_basic";
    private static String authType ;
    public static OkHttpClient getUnsafeHttpsClient(){
        try{
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };
            final SSLContext sslContext =   SSLContext.getInstance("SSL") ;
            sslContext.init(null , trustAllCerts ,  new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory() ;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory , (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request() ;
                    Request.Builder requestBuilder =  request.newBuilder()
                            .addHeader("Authorization" , Credentials.basic(CONSTANTS.WOOCOMMERCE_API_KEY ,
                                    CONSTANTS.WOOCOMMERCE_SECRET_KEY));
                    Request newRequest = requestBuilder.build() ;
                    return chain.proceed(newRequest);
                }
            });
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(logging) ;
            OkHttpClient okHttpClient = builder.build();
            return okHttpClient ;
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAuthorizaion(String AuthType){
        authType = AuthType ;
    }
}
