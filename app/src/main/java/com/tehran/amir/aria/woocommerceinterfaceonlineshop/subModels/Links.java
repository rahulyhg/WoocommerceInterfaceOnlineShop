package com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Self;

import java.util.ArrayList;

/**
 * Created by amir on 1/4/2018.
 */


public class Links implements Parcelable{
    public Links() {
        this.self = new ArrayList<>() ;
        this.collection = new ArrayList<>() ;
    }

    private ArrayList<Self> self;

    protected Links(Parcel in) {
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    public ArrayList<Self> getSelf() { return this.self; }

    public void setSelf(ArrayList<Self> self) { this.self = self; }

    private ArrayList<Collection> collection;

    public ArrayList<Collection> getCollection() { return this.collection; }

    public void setCollection(ArrayList<Collection> collection) { this.collection = collection; }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

}