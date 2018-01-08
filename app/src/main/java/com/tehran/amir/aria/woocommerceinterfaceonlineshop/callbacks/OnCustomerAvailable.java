package com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Customer;

import java.util.List;

/**
 * Created by amir on 1/3/2018.
 */

public interface OnCustomerAvailable {
    void onCustomerAvailable(Customer customer);
    void onCustomersListAvailable(List<Customer> list);
}
