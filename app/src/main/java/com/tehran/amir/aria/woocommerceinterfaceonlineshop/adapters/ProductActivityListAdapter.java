package com.tehran.amir.aria.woocommerceinterfaceonlineshop.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.activities.ProductActivity;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.StrUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 1/6/2018.
 */

public class ProductActivityListAdapter extends
        RecyclerView.Adapter<ProductActivityListAdapter.ProductListAdapterHolder> {
    private static final String TAG = "ProductActivityListAdap";
    Context mContext ;
    List<Product> mProductList = new ArrayList<>();
    RecyclerView mRecyclerView ;

    public ProductActivityListAdapter(Context context , RecyclerView recyclerView ) {
        mContext = context;
        mRecyclerView = recyclerView ;
    }

    @Override
    public ProductActivityListAdapter.ProductListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_activity_list_adapter_view
        ,parent , false) ;
        return new ProductListAdapterHolder(v) ;
    }

    @Override
    public void onBindViewHolder(ProductActivityListAdapter.ProductListAdapterHolder holder, int position) {
        if (mProductList.size() > 0){
            Product product = mProductList.get(position) ;
            holder.title.setText(product.getName());
            holder.salePrice.setText(product.getSalePrice()+"");
            holder.regularPrice.setText(product.getRegularPrice()+"");
            holder.regularPrice.setPaintFlags(holder.regularPrice.getPaintFlags() |
                    Paint.STRIKE_THRU_TEXT_FLAG);
            String imageUrl = product.getImages().get(0).getSrc() ;
            imageUrl = StrUtils.changeHttpsToHttp(imageUrl) ;
            imageUrl = StrUtils.replaceLocalHostByValidIP(imageUrl) ;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = mRecyclerView.getChildAdapterPosition(v)  ;
                    int id = mProductList.get(position).getId() ;
                    Intent intent = new Intent(mContext , ProductActivity.class);
                    intent.putExtra(ProductActivity.EXTRA_ID , id) ;
                    mContext.startActivity(intent);
                }
            });
            if (imageUrl != null && imageUrl.length() > 0){
                Log.d(TAG, "onBindViewHolder: getting images");
                Picasso.with(mContext).load(imageUrl)
                        .resize(90 , 120)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_menu_camera)
                        .centerCrop().into(holder.image);
                Log.d(TAG, "onBindViewHolder: img src = "+imageUrl);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mProductList != null && mProductList.size() > 0
                ? mProductList.size() : 0 ;
    }

    public void setProducts(List productList){
        mProductList.addAll(productList) ;
        notifyDataSetChanged();
    }

    public class ProductListAdapterHolder extends RecyclerView.ViewHolder {
        ImageView image ;
        TextView title ;
        TextView salePrice ;
        TextView regularPrice ;
        public ProductListAdapterHolder(View v) {
            super(v);
            image = v.findViewById(R.id.product_adapter_view_image) ;
            title = v.findViewById(R.id.product_adapter_view_title) ;
            salePrice = v.findViewById(R.id.product_adapter_view_price_sale) ;
            regularPrice = v.findViewById(R.id.product_adapter_view_price_regular);
        }
    }
}
