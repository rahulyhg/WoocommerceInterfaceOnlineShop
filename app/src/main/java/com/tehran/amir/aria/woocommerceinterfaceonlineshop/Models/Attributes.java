package com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Links;

import java.util.ArrayList;

/**
 * Created by amir on 1/4/2018.
 */

public class Attributes implements Parcelable
{




    private int id;

    protected Attributes(Parcel in) {
        id = in.readInt();
        name = in.readString();
        value = in.readString();
        slug = in.readString();
        type = in.readString();
        order_by = in.readString();
        has_archives = in.readByte() != 0;
        _links = in.createTypedArrayList(Links.CREATOR);
    }

    public static final Creator<Attributes> CREATOR = new Creator<Attributes>() {
        @Override
        public Attributes createFromParcel(Parcel in) {
            return new Attributes(in);
        }

        @Override
        public Attributes[] newArray(int size) {
            return new Attributes[size];
        }
    };

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String value ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String slug;

    public String getSlug() { return this.slug; }

    public void setSlug(String slug) { this.slug = slug; }

    private String type;

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private String order_by;

    public String getOrderBy() { return this.order_by; }

    public void setOrderBy(String order_by) { this.order_by = order_by; }

    private boolean has_archives;

    public boolean getHasArchives() { return this.has_archives; }

    public void setHasArchives(boolean has_archives) { this.has_archives = has_archives; }

    private ArrayList<Links> _links;

    public ArrayList<Links> get_links() {
        return _links;
    }

    public void set_links(ArrayList<Links> _links) {
        this._links = _links;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(value);
        dest.writeString(slug);
        dest.writeString(type);
        dest.writeString(order_by);
        dest.writeByte((byte) (has_archives ? 1 : 0));
        dest.writeTypedList(_links);
    }
}

