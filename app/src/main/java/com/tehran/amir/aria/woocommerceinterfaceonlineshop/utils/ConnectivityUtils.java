package com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by amir on 1/5/2018.
 */

public class ConnectivityUtils {
    public static boolean checkConnection(Context context){
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null ;
    }
}
