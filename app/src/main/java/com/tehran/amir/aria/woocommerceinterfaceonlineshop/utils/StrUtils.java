package com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils;

/**
 * Created by amir on 1/4/2018.
 */

public class StrUtils {
    public static String changeHttpsToHttp(String url){
        if (url.substring(0 , 5).contains("https")){
            url = url.replace("https" , "http" ) ;
        }
        return url ;
    }

    public static String replaceLocalHostByValidIP(String url){
        if (url.contains("127.0.0.1")){
            if (CONSTANTS.BASE_URL.equalsIgnoreCase(
                    "https://10.0.2.2/projects/wordpress/wp-json/wc/v2/")){
                url = url.replace("127.0.0.1" , "10.0.2.2") ;
            }else {
                url = url.replace("127.0.0.1" , "192.168.1.101") ;
            }
        }
        return url ;
    }
}
