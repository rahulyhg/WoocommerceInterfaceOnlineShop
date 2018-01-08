package com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Billing;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Links;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.MetaData;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Shipping;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by amir on 1/4/2018.
 */


public class Customer
{
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

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

    private String email;

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    private String first_name;

    public String getFirstName() { return this.first_name; }

    public void setFirstName(String first_name) { this.first_name = first_name; }

    private String last_name;

    public String getLastName() { return this.last_name; }

    public void setLastName(String last_name) { this.last_name = last_name; }

    private String role;

    public String getRole() { return this.role; }

    public void setRole(String role) { this.role = role; }

    private String username;

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    private Billing billing;

    public Billing getBilling() { return this.billing; }

    public void setBilling(Billing billing) { this.billing = billing; }

    private Shipping shipping;

    public Shipping getShipping() { return this.shipping; }

    public void setShipping(Shipping shipping) { this.shipping = shipping; }

    private boolean is_paying_customer;

    public boolean getIsPayingCustomer() { return this.is_paying_customer; }

    public void setIsPayingCustomer(boolean is_paying_customer) { this.is_paying_customer = is_paying_customer; }

    private int orders_count;

    public int getOrdersCount() { return this.orders_count; }

    public void setOrdersCount(int orders_count) { this.orders_count = orders_count; }

    private String total_spent;

    public String getTotalSpent() { return this.total_spent; }

    public void setTotalSpent(String total_spent) { this.total_spent = total_spent; }

    private String avatar_url;

    public String getAvatarUrl() { return this.avatar_url; }

    public void setAvatarUrl(String avatar_url) { this.avatar_url = avatar_url; }

    private ArrayList<MetaData> meta_data;

    public ArrayList<MetaData> getMetaData() { return this.meta_data; }

    public void setMetaData(ArrayList<MetaData> meta_data) { this.meta_data = meta_data; }

    private Links _links;

    public Links getLinks() { return this._links; }

    public void setLinks(Links _links) { this._links = _links; }

    private String password ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}