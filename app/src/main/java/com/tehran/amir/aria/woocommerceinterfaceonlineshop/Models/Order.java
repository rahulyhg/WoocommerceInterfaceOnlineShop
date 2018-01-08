package com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Billing;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.CouponLine;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.FeeLine;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.LineItem;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Links;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.MetaData;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Shipping;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.ShippingLine;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.TaxLine;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by amir on 1/4/2018.
 */





public class Order
{
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private int parent_id;

    public int getParentId() { return this.parent_id; }

    public void setParentId(int parent_id) { this.parent_id = parent_id; }

    private String number;

    public String getNumber() { return this.number; }

    public void setNumber(String number) { this.number = number; }

    private String order_key;

    public String getOrderKey() { return this.order_key; }

    public void setOrderKey(String order_key) { this.order_key = order_key; }

    private String created_via;

    public String getCreatedVia() { return this.created_via; }

    public void setCreatedVia(String created_via) { this.created_via = created_via; }

    private String version;

    public String getVersion() { return this.version; }

    public void setVersion(String version) { this.version = version; }

    private String status;

    public String getStatus() { return this.status; }

    public void setStatus(String status) { this.status = status; }

    private String currency;

    public String getCurrency() { return this.currency; }

    public void setCurrency(String currency) { this.currency = currency; }

    private Date date_created;

    public Date getDateCreated() { return this.date_created; }

    public void setDateCreated(Date date_created) { this.date_created = date_created; }

    private Date date_created_gmt;

    public Date getDateCreatedGmt() { return this.date_created_gmt; }

    public void setDateCreatedGmt(Date date_created_gmt) { this.date_created_gmt = date_created_gmt; }

    private Date date_modified;

    public Date getDateModified() { return this.date_modified; }

    public void setDateModified(Date date_modified) { this.date_modified = date_modified; }

    private Date date_modified_gmt;

    public Date getDateModifiedGmt() { return this.date_modified_gmt; }

    public void setDateModifiedGmt(Date date_modified_gmt) { this.date_modified_gmt = date_modified_gmt; }

    private String discount_total;

    public String getDiscountTotal() { return this.discount_total; }

    public void setDiscountTotal(String discount_total) { this.discount_total = discount_total; }

    private String discount_tax;

    public String getDiscountTax() { return this.discount_tax; }

    public void setDiscountTax(String discount_tax) { this.discount_tax = discount_tax; }

    private String shipping_total;

    public String getShippingTotal() { return this.shipping_total; }

    public void setShippingTotal(String shipping_total) { this.shipping_total = shipping_total; }

    private String shipping_tax;

    public String getShippingTax() { return this.shipping_tax; }

    public void setShippingTax(String shipping_tax) { this.shipping_tax = shipping_tax; }

    private String cart_tax;

    public String getCartTax() { return this.cart_tax; }

    public void setCartTax(String cart_tax) { this.cart_tax = cart_tax; }

    private String total;

    public String getTotal() { return this.total; }

    public void setTotal(String total) { this.total = total; }

    private String total_tax;

    public String getTotalTax() { return this.total_tax; }

    public void setTotalTax(String total_tax) { this.total_tax = total_tax; }

    private boolean prices_include_tax;

    public boolean getPricesIncludeTax() { return this.prices_include_tax; }

    public void setPricesIncludeTax(boolean prices_include_tax) { this.prices_include_tax = prices_include_tax; }

    private int customer_id;

    public int getCustomerId() { return this.customer_id; }

    public void setCustomerId(int customer_id) { this.customer_id = customer_id; }

    private String customer_ip_address;

    public String getCustomerIpAddress() { return this.customer_ip_address; }

    public void setCustomerIpAddress(String customer_ip_address) { this.customer_ip_address = customer_ip_address; }

    private String customer_user_agent;

    public String getCustomerUserAgent() { return this.customer_user_agent; }

    public void setCustomerUserAgent(String customer_user_agent) { this.customer_user_agent = customer_user_agent; }

    private String customer_note;

    public String getCustomerNote() { return this.customer_note; }

    public void setCustomerNote(String customer_note) { this.customer_note = customer_note; }

    private Billing billing;

    public Billing getBilling() { return this.billing; }

    public void setBilling(Billing billing) { this.billing = billing; }

    private Shipping shipping;

    public Shipping getShipping() { return this.shipping; }

    public void setShipping(Shipping shipping) { this.shipping = shipping; }

    private String payment_method;

    public String getPaymentMethod() { return this.payment_method; }

    public void setPaymentMethod(String payment_method) { this.payment_method = payment_method; }

    private String payment_method_title;

    public String getPaymentMethodTitle() { return this.payment_method_title; }

    public void setPaymentMethodTitle(String payment_method_title) { this.payment_method_title = payment_method_title; }

    private String transaction_id;

    public String getTransactionId() { return this.transaction_id; }

    public void setTransactionId(String transaction_id) { this.transaction_id = transaction_id; }

    private Date date_paid;

    public Date getDatePaid() { return this.date_paid; }

    public void setDatePaid(Date date_paid) { this.date_paid = date_paid; }

    private Date date_paid_gmt;

    public Date getDatePaidGmt() { return this.date_paid_gmt; }

    public void setDatePaidGmt(Date date_paid_gmt) { this.date_paid_gmt = date_paid_gmt; }

    private Date date_completed;

    public Date getDateCompleted() { return this.date_completed; }

    public void setDateCompleted(Date date_completed) { this.date_completed = date_completed; }

    private Date date_completed_gmt;

    public Date getDateCompletedGmt() { return this.date_completed_gmt; }

    public void setDateCompletedGmt(Date date_completed_gmt) { this.date_completed_gmt = date_completed_gmt; }

    private String cart_hash;

    public String getCartHash() { return this.cart_hash; }

    public void setCartHash(String cart_hash) { this.cart_hash = cart_hash; }

    private ArrayList<MetaData> meta_data;

    public ArrayList<MetaData> getMetaData() { return this.meta_data; }

    public void setMetaData(ArrayList<MetaData> meta_data) { this.meta_data = meta_data; }

    private ArrayList<LineItem> line_items;

    public ArrayList<LineItem> getLineItems() { return this.line_items; }

    public void setLineItems(ArrayList<LineItem> line_items) { this.line_items = line_items; }

    private ArrayList<TaxLine> tax_lines;

    public ArrayList<TaxLine> getTaxLines() { return this.tax_lines; }

    public void setTaxLines(ArrayList<TaxLine> tax_lines) { this.tax_lines = tax_lines; }

    private ArrayList<ShippingLine> shipping_lines;

    public ArrayList<ShippingLine> getShippingLines() { return this.shipping_lines; }

    public void setShippingLines(ArrayList<ShippingLine> shipping_lines) { this.shipping_lines = shipping_lines; }

    private ArrayList<FeeLine> fee_lines;

    public ArrayList<FeeLine> getFeeLines() { return this.fee_lines; }

    public void setFeeLines(ArrayList<FeeLine> fee_lines) { this.fee_lines = fee_lines; }

    private ArrayList<CouponLine> coupon_lines;

    public ArrayList<CouponLine> getCouponLines() { return this.coupon_lines; }

    public void setCouponLines(ArrayList<CouponLine> coupon_lines) { this.coupon_lines = coupon_lines; }

    private ArrayList<Refund> refunds;

    public ArrayList<Refund> getRefunds() { return this.refunds; }

    public void setRefunds(ArrayList<Refund> refunds) { this.refunds = refunds; }

    private Links _links;

    public Links getLinks() { return this._links; }

    public void setLinks(Links _links) { this._links = _links; }

    private boolean paid ;

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}

