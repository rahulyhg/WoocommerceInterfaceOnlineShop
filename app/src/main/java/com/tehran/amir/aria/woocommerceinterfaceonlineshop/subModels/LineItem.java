package com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels;

import java.util.ArrayList;

/**
 * Created by amir on 1/4/2018.
 */


public class LineItem
{
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private int product_id;

    public int getProductId() { return this.product_id; }

    public void setProductId(int product_id) { this.product_id = product_id; }

    private int variation_id;

    public int getVariationId() { return this.variation_id; }

    public void setVariationId(int variation_id) { this.variation_id = variation_id; }

    private int quantity;

    public int getQuantity() { return this.quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    private String tax_class;

    public String getTaxClass() { return this.tax_class; }

    public void setTaxClass(String tax_class) { this.tax_class = tax_class; }

    private String subtotal;

    public String getSubtotal() { return this.subtotal; }

    public void setSubtotal(String subtotal) { this.subtotal = subtotal; }

    private String subtotal_tax;

    public String getSubtotalTax() { return this.subtotal_tax; }

    public void setSubtotalTax(String subtotal_tax) { this.subtotal_tax = subtotal_tax; }

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

    private String sku;

    public String getSku() { return this.sku; }

    public void setSku(String sku) { this.sku = sku; }

    private int price;

    public int getPrice() { return this.price; }

    public void setPrice(int price) { this.price = price; }
}
