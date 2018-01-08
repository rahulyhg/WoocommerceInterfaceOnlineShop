package com.tehran.amir.aria.woocommerceinterfaceonlineshop.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.CategoryContracts;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductCategory;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.adapters.ShowCategoryFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowCategoryFragment extends Fragment {
    private static final String TAG = "ShowCategoryFragment";
    public static final String EXTRA_TITLE = "extra_title" ;
    public static final String EXTRA_LIST = "extra_LIST" ;

    List<ProductCategory> mCategoryList ;
    RecyclerView mRecyclerView ;
    ShowCategoryFragmentAdapter mAdapter ;

    public ShowCategoryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShowCategoryFragment newInstance(ArrayList<ProductCategory> list) {
        ShowCategoryFragment fragment = new ShowCategoryFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_LIST , list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategoryList = getArguments().getParcelableArrayList(EXTRA_LIST) ;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_show_category, container, false);
        mRecyclerView = v.findViewById(R.id.fragment_show_category_revyvler) ;
        mAdapter = new ShowCategoryFragmentAdapter(getContext()) ;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL , false));
        mRecyclerView.setAdapter(mAdapter);
        processCategoryList();
        return  v ;
    }

    private void processCategoryList(){
        ArrayList<ProductCategory> l = new ArrayList<>();
        for (ProductCategory p : mCategoryList){
            if ( p.getParent() == 0 &&
                  (!CategoryContracts.Columns.
                         CATEGORY_SLUG_WONDERFUL.equalsIgnoreCase(p.getSlug())) ){
                l.add(p) ;
            }
        }
        mAdapter.setCategories(l);
    }

}
