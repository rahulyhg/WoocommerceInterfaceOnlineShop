package com.tehran.amir.aria.woocommerceinterfaceonlineshop.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.asksira.loopingviewpager.LoopingPagerAdapter;
import com.asksira.loopingviewpager.LoopingViewPager;
import com.squareup.picasso.Picasso;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Attributes;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnProductAvailableCallback;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers.ProductController;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Image;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.CONSTANTS;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.StrUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements
        OnProductAvailableCallback{
    private static final String TAG = "ProductActivity";

    public static final String EXTRA_ID = "EXTRA_ID" ;

    private int mId = 0;
    private ProductController mProductController ;
    LoopingViewPager slider ;
    Product mProduct ;
    ProgressDialog mProgressDialog ;
    AppBarLayout mAppBarLayout ;

    TextView title ;
    TextView regularPrice ;
    TextView salePrice ;
    TextView description ;
    TextView color ;
    TextView material ;
    TextView weight ;
    TextView dimens ;
    EditText commentTitle ;
    EditText Comment ;
    CardView addComment ;
    CardView attrButton ;
    CardView CommentsPage ;
    CardView addToCard ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Intent intent = getIntent() ;
        if (intent != null){
            mId = intent.getIntExtra(EXTRA_ID , 0) ;
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbarLayout1);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int intColorCode=0;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                intColorCode=-(verticalOffset);
                if(intColorCode>255)
                    intColorCode=255;
                toolbar.getBackground().setAlpha(intColorCode);
                toolbar.setAlpha(intColorCode);
            }
        });

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        init();
        getProducts();
    }

    private void init(){
        mProductController = new ProductController(this , this);
        slider = (LoopingViewPager) findViewById(R.id.product_activity_slider) ;
        title = (TextView) findViewById(R.id.prodcut_info_name);
        regularPrice= (TextView) findViewById(R.id.prodcut_info_regular_price) ;
        salePrice = (TextView) findViewById(R.id.prodcut_info_sale_price);
        description = (TextView) findViewById(R.id.product_indo_description);
        color = (TextView) findViewById(R.id.product_attr_color);
        material = (TextView) findViewById(R.id.product_attr_material);
        weight = (TextView) findViewById(R.id.product_attr_weight);
        dimens = (TextView) findViewById(R.id.product_attr_dimen);
        EditText commentTitle = (EditText) findViewById(R.id.product_comment_comment_title);
        EditText Comment = (EditText) findViewById(R.id.product_comment_comment);
        CardView addComment = (CardView)findViewById(R.id.product_comment_button) ;
        CardView attrButton = (CardView)findViewById(R.id.product_attr_button);
        CardView CommentsPage = (CardView)findViewById(R.id.product_comments_button);
        CardView addToCard = (CardView)findViewById(R.id.product_add_to_card);
    }

    public void getProducts() {
        Log.d(TAG, "getProducts: called " +mId);
        mProductController.getProduct(mId);
    }

    private void setSliderImage( ){
        if (mProduct == null){
            Log.d(TAG, "setSliderImage: product null");
            return;
        }
        String url ;
        ArrayList<String> urls = new ArrayList<>();
        for (Image i : mProduct.getImages()){
            url = i.getSrc() ;
            url = StrUtils.replaceLocalHostByValidIP(url);
            url = StrUtils.changeHttpsToHttp(url) ;
            urls.add(url) ;
        }
        slider.setAdapter(new infinitSliderAdapter(this , urls , true));
    }

    private void setData(){
        if (mProduct == null){
            return;
        }
        title.setText(mProduct.getName());
         regularPrice.setText(mProduct.getRegularPrice() + "");
         regularPrice.setPaintFlags( regularPrice.getPaintFlags()
                 |Paint.STRIKE_THRU_TEXT_FLAG);
         salePrice.setText(mProduct.getSalePrice() + "") ;
         description .setText(mProduct.getShortDescription());
         for (Attributes a : mProduct.getAttributes()){
             if (a == null){
                 continue;
             }
             if (a.getSlug() != null &&
                     a.getSlug().equalsIgnoreCase(CONSTANTS.ATTR_SLUG_COLOR)){
                 color.setText(a.getValue());
             }
             if (a.getSlug() != null &&
                     a.getSlug().equalsIgnoreCase(CONSTANTS.ATTR_SLUG_MATERIAL)){
                 material.setText(a.getValue());
             }
             if (a.getSlug() != null &&
                     a.getSlug() != null && a.getSlug().equalsIgnoreCase(CONSTANTS.ATTR_SLUG_WEIGH)){
                 weight.setText(a.getValue());
             }
             if (a.getSlug() != null &&
                     a.getSlug().equalsIgnoreCase(CONSTANTS.ATTR_SLUG_DIMEN)){
                 dimens.setText(a.getValue());
             }
         }
    }


    class infinitSliderAdapter extends LoopingPagerAdapter<String>{

        public infinitSliderAdapter(Context context, ArrayList<String> itemList, boolean isInfinite) {
            super(context, itemList, isInfinite);
        }

        @Override
        protected View inflateView(int viewType, int listPosition) {
            return LayoutInflater.from(ProductActivity.this ).inflate(R.layout.slider_image_view
            ,null , false) ;
        }

        @Override
        protected void bindView(View convertView, int listPosition, int viewType) {
            Log.d(TAG, "bindView: on bid view called");
            String url = itemList.get(listPosition) ;
            Log.d(TAG, "bindView url : "+url);
            ImageView view = convertView.findViewById(R.id.slider_image) ;
            Picasso.with(ProductActivity.this).load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_menu_camera)
                    .into(view);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        slider.resumeAutoScroll();
    }

    @Override
    protected void onResume() {
        super.onResume();
        slider.pauseAutoScroll();
    }

    @Override
    public void onProductAvailable(Product product) {
        Log.d(TAG, "onProductAvailable: called");
        if (mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
        mAppBarLayout.setExpanded(true);
        mProduct = product ;
        setSliderImage();
        setData();
    }

    @Override
    public void onProductListAvailable(List<Product> productList) {

    }

    @Override
    public void onProductNotAvailable() {
        Log.d(TAG, "onProductNotAvailable: no products");
    }


}

// slider : inifinit auto scroll
// https://android-arsenal.com/details/1/6576
