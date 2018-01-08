package com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Image;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Links;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by amir on 1/3/2018.
 */


public class ProductCategory implements Parcelable {
    public static final long serialVersionUID = 43L;

    public ProductCategory() {
    }

    private int id;

    protected ProductCategory(Parcel in) {
        id = in.readInt();
        name = in.readString();
        slug = in.readString();
        parent = in.readInt();
        description = in.readString();
        display = in.readString();
        image = in.readParcelable(Image.class.getClassLoader());
        menu_order = in.readInt();
        count = in.readInt();
        _links = in.readParcelable(Links.class.getClassLoader());
        password = in.readString();
    }

    public static final Creator<ProductCategory> CREATOR = new Creator<ProductCategory>() {
        @Override
        public ProductCategory createFromParcel(Parcel in) {
            return new ProductCategory(in);
        }

        @Override
        public ProductCategory[] newArray(int size) {
            return new ProductCategory[size];
        }
    };

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String slug;

    public String getSlug() { return this.slug; }

    public void setSlug(String slug) { this.slug = slug; }

    private int parent;

    public int getParent() { return this.parent; }

    public void setParent(int parent) { this.parent = parent; }

    private String description;

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    private String display;

    public String getDisplay() { return this.display; }

    public void setDisplay(String display) { this.display = display; }

    private Image image;

    public Image getImage() { return this.image; }

    public void setImage(Image image) { this.image = image; }

    private int menu_order;

    public int getMenuOrder() { return this.menu_order; }

    public void setMenuOrder(int menu_order) { this.menu_order = menu_order; }

    private int count;

    public int getCount() { return this.count; }

    public void setCount(int count) { this.count = count; }

    private Links _links;

    public Links getLinks() { return this._links; }

    public void setLinks(Links _links) { this._links = _links; }

    private String password ;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(slug);
        dest.writeInt(parent);
        dest.writeString(description);
        dest.writeString(display);
        dest.writeParcelable(image , 0 );
        dest.writeInt(menu_order);
        dest.writeInt(count);
        dest.writeString(password);
        dest.writeParcelable(_links , 0);
    }
}