package com.tehran.amir.aria.woocommerceinterfaceonlineshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductCategory;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 1/5/2018.
 */

public class ShowCategoryFragmentAdapter extends
        RecyclerView.Adapter<ShowCategoryFragmentAdapter.CategoryViewHolder>{
    private static final String TAG = "ShowCategoryFragmentAda";
    Context mContext ;
    List<ProductCategory> mCategoryList = new ArrayList<>();
    public ShowCategoryFragmentAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ShowCategoryFragmentAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_category_fragment_adapter_view
         , parent , false) ;
        return new CategoryViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(ShowCategoryFragmentAdapter.CategoryViewHolder holder, int position) {
        if (mCategoryList.size() > 0){
            holder.title.setText(mCategoryList.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return mCategoryList != null && mCategoryList.size() > 0
                ? mCategoryList.size() : 0;
    }

    public void setCategories(List<ProductCategory> list){
        mCategoryList = list ;
        notifyDataSetChanged();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView title ;
        public CategoryViewHolder(View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.show_category_fragment_adapter_title_view) ;
        }
    }
}
