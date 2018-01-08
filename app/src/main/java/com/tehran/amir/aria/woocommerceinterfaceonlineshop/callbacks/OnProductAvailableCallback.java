package com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;

import java.util.List;

/**
 * Created by amir on 1/2/2018.
 */

public interface OnProductAvailableCallback {
    void onProductAvailable(Product product);
    void onProductListAvailable(List<Product> productList);
    void onProductNotAvailable() ;

}
