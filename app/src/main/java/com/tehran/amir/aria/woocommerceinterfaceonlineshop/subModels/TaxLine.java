package com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels;

import java.util.ArrayList;

/**
 * Created by amir on 1/4/2018.
 */

public class TaxLine
{
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String rate_code;

    public String getRateCode() { return this.rate_code; }

    public void setRateCode(String rate_code) { this.rate_code = rate_code; }

    private int rate_id;

    public int getRateId() { return this.rate_id; }

    public void setRateId(int rate_id) { this.rate_id = rate_id; }

    private String label;

    public String getLabel() { return this.label; }

    public void setLabel(String label) { this.label = label; }

    private boolean compound;

    public boolean getCompound() { return this.compound; }

    public void setCompound(boolean compound) { this.compound = compound; }

    private String tax_total;

    public String getTaxTotal() { return this.tax_total; }

    public void setTaxTotal(String tax_total) { this.tax_total = tax_total; }

    private String shipping_tax_total;

    public String getShippingTaxTotal() { return this.shipping_tax_total; }

    public void setShippingTaxTotal(String shipping_tax_total) { this.shipping_tax_total = shipping_tax_total; }

    private ArrayList<MetaData> meta_data;

    public ArrayList<MetaData> getMetaData() { return this.meta_data; }

    public void setMetaData(ArrayList<MetaData> meta_data) { this.meta_data = meta_data; }
}