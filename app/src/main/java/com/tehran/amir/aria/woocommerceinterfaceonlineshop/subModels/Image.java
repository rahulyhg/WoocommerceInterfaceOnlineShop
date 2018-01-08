package com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by amir on 1/4/2018.
 */

public class Image implements Parcelable
{

    protected Image(Parcel in) {
        id = in.readInt();
        src = in.readString();
        name = in.readString();
        alt = in.readString();
        position = in.readInt();
    }
    private int id;

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

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

    private String src;

    public String getSrc() { return this.src; }

    public void setSrc(String src) { this.src = src; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String alt;

    public String getAlt() { return this.alt; }

    public void setAlt(String alt) { this.alt = alt; }

    private int position;

    public int getPosition() { return this.position; }

    public void setPosition(int position) { this.position = position; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(src);
        dest.writeString(name);
        dest.writeString(alt);
        dest.writeInt(position);
    }
}