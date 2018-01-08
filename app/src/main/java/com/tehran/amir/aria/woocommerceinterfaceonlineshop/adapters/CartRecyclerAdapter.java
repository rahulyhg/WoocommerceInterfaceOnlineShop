package com.tehran.amir.aria.woocommerceinterfaceonlineshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;

import java.util.List;

/**
 * Created by amir on 1/7/2018.
 */

public class CartRecyclerAdapter
            extends RecyclerView.Adapter<CartRecyclerAdapter.CartViewHolder> {
    private static final String TAG = "CartRecyclerAdapter";

    public static final int VIEW_TYPE_PRIMARY = 1;
    public static final int VIEW_TYPE_EMPTY = 2 ;

    Context mContext ;
    RecyclerView mRecyclerView ;
    List<Product> mProductList ;

    public CartRecyclerAdapter(Context context, RecyclerView recyclerView) {
        mContext = context;
        mRecyclerView = recyclerView;
    }

    @Override
    public CartRecyclerAdapter.CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case VIEW_TYPE_PRIMARY :
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cart_adapter_view_primary,parent , false) ;
                break;
            case VIEW_TYPE_EMPTY :
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cart_adapter_biew_empty,parent , false) ;
                break;
        }
        return new CartViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(CartRecyclerAdapter.CartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return  mProductList != null && mProductList.size() > 0
                ? mProductList.size() + 1 : 0  ;
    }

    @Override
    public int getItemViewType(int position) {
        if (mProductList == null){
            return VIEW_TYPE_PRIMARY ;
        }
        if (position == (mProductList.size() + 1)){
            return VIEW_TYPE_EMPTY ;
        }else {
            return  VIEW_TYPE_PRIMARY ;
        }
    }

    public void setProducts(List<Product> list){
        mProductList = list ;
        notifyDataSetChanged();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        public CartViewHolder(View itemView) {
            super(itemView);
        }
    }
}
