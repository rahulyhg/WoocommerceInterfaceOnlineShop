package com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models;

import java.util.Date;

/**
 * Created by amir on 1/3/2018.
 */

public class ProductReview {
    private long id ;
    private String review ;
    private Date date_created ;
    private int rating ;
    private String name ;
    private String email ;

    public ProductReview() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
