package com.tehran.amir.aria.woocommerceinterfaceonlineshop.activities;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.adapters.ProductActivityListAdapter;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnProductAvailableCallback;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers.ProductController;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.CONSTANTS;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity
        implements OnProductAvailableCallback{
    private static final String TAG = "ProductListActivity";

    public static final int TYPE_CATEGORY = 1 ;
    public static final int TYPE_SEARCH = 2 ;
    public static final int TYPE_TAG = 3 ;
    public static final int TYPE_ALL = 4;
    public static final String EXTRA_CATEGORY = "ProductListActivity_EXTRA_CATEGORY" ;
    public static final String EXTRA_CATEGORY_SLUG = "ProductListActivity_EXTRA_CATEGORY_SLUG" ;
    public static final String EXTRA_TAG = "ProductListActivity_EXTRA_TAG" ;
    public static final String EXTRA_SEARCH = "ProductListActivity_EXTRA_SEARCH" ;
    public static final String EXTRA_SORT_ORDER = "ProductListActivity_EXTRA_SORT_ORDER " ;
    public static final String EXTRA_TYPE = "ProductListActivity_TYPE" ;



    private static int mPage = 1;
    RecyclerView mRecyclerView ;
    CardView mfilter ;
    CardView mSort ;
    List<Product> mProductList = new ArrayList<>() ;
    ProductController mProductController ;
    ProductActivityListAdapter mAdapter ;
    enum TypeOfAdapter {GRID , LINEAR}
    TypeOfAdapter mTypeOfAdapter  = TypeOfAdapter.GRID;

    int type ;
    int category ;
    String categorySlug = "";
    String tag = "";
    String searchPhrase ;
    String sortOrder = "date" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getInfo();
        init();
        prepareRecycler();
        getProducts();
    }

    private void getInfo(){
        Intent intent = getIntent() ;
        if (intent != null){
            category = intent.getIntExtra(EXTRA_CATEGORY , 0) ;
            categorySlug = intent.getStringExtra(EXTRA_CATEGORY_SLUG ) ;
            tag = intent.getStringExtra(EXTRA_TAG) ;
            searchPhrase = intent.getStringExtra(EXTRA_SEARCH) ;
            sortOrder = intent.getStringExtra(EXTRA_SORT_ORDER) ;
            type = intent.getIntExtra(EXTRA_TYPE , 1) ;
        }
    }
    private void init() {
        mProductController = new ProductController(this , this ) ;
        mRecyclerView = (RecyclerView) findViewById(R.id.product_list_recycler_view) ;
        mSort = (CardView) findViewById(R.id.activity_product_sort) ;
        mfilter = (CardView) findViewById(R.id.activity_product_filter);
    }

    private void prepareRecycler(){
        mAdapter = new ProductActivityListAdapter(this , mRecyclerView) ;
        mRecyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (recyclerView.canScrollVertically(1)){
                    mPage+=1 ;
                    getProducts();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        int space = getResources().getDimensionPixelSize(R.dimen.grid_layout_spacing) ;
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(space , space , space , space*2));
    }

    private void getProducts(){
        switch (type){
            case TYPE_CATEGORY :
                mProductController.getProductByCategory(mPage , searchPhrase , category);
                break;
            case TYPE_SEARCH :
                break;
            case TYPE_TAG:
                break;
            case TYPE_ALL:
                mProductController.getProducts(mPage , searchPhrase , CONSTANTS.SORT_ORDER_DATE);
        }
    }

    @Override
    public void onProductAvailable(Product product) {

    }

    @Override
    public void onProductListAvailable(List<Product> productList) {
        if (productList != null && productList.size() > 0){
            Log.d(TAG, "onProductListAvailable: called");
            mAdapter.setProducts(productList);
        }
    }

    @Override
    public void onProductNotAvailable() {
        Log.d(TAG, "onProductNotAvailable: no Products");
    }
}
