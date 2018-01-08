package com.tehran.amir.aria.woocommerceinterfaceonlineshop.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.CategoryContracts;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Order;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnOrderAvailableCallback;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers.OrderController;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.fragments.ShowCategoryFragment;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.fragments.ShowProductListFragment;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Billing;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Customer;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.ProductCategory;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.LineItem;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Shipping;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnCustomerAvailable;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnProductAvailableCallback;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers.CustomerController;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers.ProductController;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.ShippingLine;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.CONSTANTS;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
        , OnProductAvailableCallback
        , OnCustomerAvailable
        , OnOrderAvailableCallback
        , ShowProductListFragment.OnFragmentShowProductListListener{
    private static final String TAG = "MainActivity";

    ImageView mTopSliderImage ;
    FrameLayout mTopSlider  ;
    FrameLayout mCategoryList ;
    FrameLayout mWonderFulContainer ;
    FrameLayout mPictureView1 ;
    FrameLayout mPictureView2 ;
    FrameLayout mNewList ;
    FrameLayout mSpecialList ;

    ArrayList<ProductCategory> mCategoriesList = new ArrayList<>();
    ProductController mProductController ;
    CustomerController mCustomerController ;
    OrderController mOrderController ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

//                mProductController.getProduct(38);
//                mProductController.getProducts(1 , "" );
//                mProductController.getProductByCategory(1 , "", 15);
//                mCustomerController.getCustomerList();
//                createFakeCustomer();
//                createFakeOrder();
//                updateFakeOrder();
//                mCustomerController.getCustomerByEmail("test1@gmail.com");
                setViews();
            }
        });
        processCateories();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        initViews();
        setViews();
    }

    /**
     * retrieves Category list from given intent .
     */
    private void processCateories() {
        Intent intent = getIntent() ;
        if (intent == null){
            return;
        }
        Bundle bundle =
                intent.getBundleExtra(SplashActivity.CATEGORY_LIST);
        mCategoriesList = bundle.getParcelableArrayList(SplashActivity.CATEGORY_LIST) ;
    }

    private void init() {
        mProductController = new ProductController(this , this );
        mCustomerController = new CustomerController(this , this );
        mOrderController = new OrderController(this , this) ;
    }


    private void initViews() {
        mWonderFulContainer = (FrameLayout) findViewById(R.id.main_view_wonderful_list) ;
        mTopSlider = (FrameLayout) findViewById(R.id.main_view_top_slider) ;;
        mCategoryList = (FrameLayout) findViewById(R.id.main_view_category_list) ;
        mPictureView1 = (FrameLayout) findViewById(R.id.main_view_picture_view1) ;
        mPictureView2= (FrameLayout) findViewById(R.id.main_view_picture_view2) ;
        mNewList = (FrameLayout) findViewById(R.id.main_view_new_list) ;
        mSpecialList = (FrameLayout) findViewById(R.id.main_view_special_list) ;
        mTopSliderImage = (ImageView) findViewById(R.id.main_view_top_slider_image) ;
    }

    private void setViews() {
        //setting slider
        //TODO  : should be replace by a slider lib in a fragment
        AssetManager assetManager = getAssets() ;
        try{
            InputStream inputStream = assetManager.open("banner.png") ;
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream) ;
            mTopSliderImage.setImageBitmap(bitmap);
        }catch (IOException e){
            e.printStackTrace();
            Log.e(TAG, "setViews: cant get image from assets",e );
        }
        //setting category list
        if (mCategoriesList.size() > 0){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_view_category_list ,
                            ShowCategoryFragment.newInstance(mCategoriesList))
                    .commit() ;
        }
        // setting wonderful list
        ProductCategory wonder = findCategory(CategoryContracts.Columns.CATEGORY_SLUG_WONDERFUL) ;
        if ( wonder != null){
            Log.d(TAG, "setViews: wonderFul have got");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_view_wonderful_list ,
                            ShowProductListFragment.newInstance(getString(R.string.wonderFulOffer) , "wonderfuloffers"
                                    ,ShowProductListFragment.TYPE_CATEGORY , wonder.getId() ))
                    .commit() ;
        }

        // setting new products
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_view_new_list ,
                        ShowProductListFragment.newInstance(getString(R.string.newest)
                                , ""
                                ,ShowProductListFragment.TYPE_ALL , 0 ))
                .commit() ;


    }

    private ProductCategory findCategory(String s){
        for (ProductCategory p : mCategoriesList){
            if (p.getSlug().equalsIgnoreCase(s)){
                return p ;
            }
        }
        return null ;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onProductAvailable(Product product) {
        Log.d(TAG, "onProductAvailable: called");
        Toast.makeText(this , product.getName() , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProductListAvailable(List<Product> productList) {
        Log.d(TAG, "onProductListAvailable: called");
        Toast.makeText(this , productList.size()+"" , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onProductNotAvailable() {

    }

    @Override
    public void onCustomerAvailable(Customer customer) {
        Log.d(TAG, "onCustomerAvailable: called");
        Toast.makeText(this , customer.getFirstName()
                        +" pass : "+customer.getPassword()
                , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCustomersListAvailable(List<Customer> list) {
        Customer c = list.get(0) ;
        int id = c.getId() ;
        String name = c.getFirstName() ;
        String add = c.getBilling().getAddress1() ;
        String pass = c.getPassword() ;
        String s = id + name +add +" pass : "+pass;
        Toast.makeText(this , s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onOrderAvailableCallback(Order order) {
        Log.d(TAG, "onOrderAvailableCallback: order created");
        Toast.makeText(this , order.getId()+"" , Toast.LENGTH_LONG).show();
    }


    @Override
    public void OnFragmentShowProductListListenerInteraction() {

    }

    private void createFakeCustomer(){
        Customer customer = new Customer();

        Billing billing = new Billing();
        billing.setFirstName("mammad");
        billing.setLastName("golami");
        billing.setCompany("");
        billing.setAddress1("qwe ");
        billing.setAddress2("qwe ");
        billing.setCity("eqwe");
        billing.setState("qwe");
        billing.setPostcode("6543");
        billing.setCountry("IR");
        billing.setEmail("wjohn.doe@example.com");
        billing.setPhone("(555) 555-5555");

        Shipping shipping = new Shipping();
        shipping.setFirstName("amir");
        shipping.setLastName("amiri");
        shipping.setCompany("w");
        shipping.setAddress1("w");
        shipping.setAddress2("w");
        shipping.setCity("w");
        shipping.setState("w");
        shipping.setPostcode("35166");
        shipping.setCountry("IR");

        customer.setEmail("jahaur@yahoo.com");
        customer.setFirstName("امیر");
        customer.setLastName("قلامی");
        customer.setUsername("amir_jj_okocha");
        customer.setPassword(CONSTANTS.password);

        customer.setShipping(shipping);
        customer.setBilling(billing);
        if (mCustomerController != null){
            Log.d(TAG, "createFakeCustomer: called");
            mCustomerController.createCustomer(customer);
        }
    }

    private void createFakeOrder(){
        Order order = new Order() ;
        order.setPaymentMethod("bacs");
        order.setPaymentMethodTitle("Direct Bank Transfer");
        order.setPaid(true);

        Billing billing = new Billing();
        billing.setFirstName("amir ");
        billing.setLastName("amiri");
        billing.setCompany("");
        billing.setAddress1("qwe ");
        billing.setAddress2("qwe ");
        billing.setCity("eqwe");
        billing.setState("qwe");
        billing.setPostcode("6543");
        billing.setCountry("IR");
        billing.setEmail("test1@gmail.com");
        billing.setPhone("(555) 555-5555");

        Shipping shipping = new Shipping();
        shipping.setFirstName("amir");
        shipping.setLastName("amiri");
        shipping.setCompany("w");
        shipping.setAddress1("w");
        shipping.setAddress2("w");
        shipping.setCity("w");
        shipping.setState("w");
        shipping.setPostcode("35166");
        shipping.setCountry("IR");

        order.setBilling(billing);
        order.setShipping(shipping);

        ArrayList<LineItem> lineItems = new ArrayList<>();
        LineItem item = new LineItem();
        item.setProductId(36);
        item.setQuantity(2);
        lineItems.add(item);
        order.setLineItems(lineItems);

        ShippingLine shippingLine = new ShippingLine() ;
        shippingLine.setMethodId("flat_rate");
        shippingLine.setMethodTitle("flat rate");
        shippingLine.setTotal("10");
        ArrayList<ShippingLine> sl = new ArrayList<>();
        order.setShippingLines(sl);

        if (mOrderController != null){
            mOrderController.createOrder(order);
        }
    }

    private void updateFakeOrder(){
        Order order = new Order();
        int orderid = 50 ;
        order.setId(50);
        order.setStatus("completed");
        if (mOrderController !=null){
            mOrderController.updateOrder(order , orderid);
        }
    }
}
