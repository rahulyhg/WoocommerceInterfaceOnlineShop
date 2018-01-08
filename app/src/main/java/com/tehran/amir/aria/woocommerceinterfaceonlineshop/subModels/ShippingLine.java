package com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels;

import java.util.ArrayList;

/**
 * Created by amir on 1/4/2018.
 */

public class ShippingLine
{
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String method_title;

    public String getMethodTitle() { return this.method_title; }

    public void setMethodTitle(String method_title) { this.method_title = method_title; }

    private String method_id;

    public String getMethodId() { return this.method_id; }

    public void setMethodId(String method_id) { this.method_id = method_id; }

    private String total;

    public String getTotal() { return this.total; }

    public void setTotal(String total) { this.total = total; }

    private String total_tax;

    public String getTotalTax() { return this.total_tax; }

    public void setTotalTax(String total_tax) { this.total_tax = total_tax; }

    private ArrayList<Tax> taxes;

    public ArrayList<Tax> getTaxes() { return this.taxes; }

    public void setTaxes(ArrayList<Tax> taxes) { this.taxes = taxes; }

    private ArrayList<MetaData> meta_data;

    public ArrayList<MetaData> getMetaData() { return this.meta_data; }

    public void setMetaData(ArrayList<MetaData> meta_data) { this.meta_data = meta_data; }
}

