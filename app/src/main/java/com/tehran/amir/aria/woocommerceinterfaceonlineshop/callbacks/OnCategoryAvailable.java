package com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 1/3/2018.
 */

public interface OnCategoryAvailable {
    void onCategoryListAvailable(List<ProductCategory> list);
    void onCategoryAvailable(ProductCategory category);
    void onCategoryNotAvailable();
}
