package com.tehran.amir.aria.woocommerceinterfaceonlineshop.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models.Product;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.R;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.activities.ProductListActivity;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.adapters.ShowProductListFragmentRecyclerAdapter;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.callbacks.OnProductAvailableCallback;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.conrollers.ProductController;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils.CONSTANTS;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowProductListFragment.OnFragmentShowProductListListener} interface
 * to handle interaction events.
 * Use the {@link ShowProductListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowProductListFragment extends Fragment implements
        OnProductAvailableCallback {
    private static final String TAG = "ShowProductListFragment";
    public static final String EXTRA_TYPE =
            "showProductListFragment_EXTRA_TYPE" ;
    public static final String EXTRA_PHRASE
            = "showProductListFragment_EXTRA_PHRASE" ;
    public static final String EXTRA_TITLE = "ShowProductListFragment_EXTRA_TITLE";
    public static final String EXTRA_ID = "ShowProductListFragment_EXTRA_ID" ;
    public static final String EXTRA_SORT_ORDER = "ShowProductListFragment_EXTRA_SORT" ;

    public static final int TYPE_ALL = 1;
    // retrieve product by category
    public static final int TYPE_CATEGORY = 2;
    public static final int TYPE_CATEGORY_WITHOUT_OPEN_ALL = 3 ;
    // retrieve product by tag
    public static final int TYPE_TAG = 4;
    // retrieve product by search
    public static final int TYPE_SEARCH = 5;

    RecyclerView mRecyclerView ;
    TextView mShowAll ;
    TextView mTitle ;
    ImageView mImageTitle ;
    FrameLayout widgetContainer ;
    ShowProductListFragmentRecyclerAdapter mAdapter ;
    ProductController mProductController ;


    enum TypeOfFragment {ALL, CATEGORY , TAG , SEARCH}
    TypeOfFragment mTypeOfFragment ;
    String mPhrase ;
    String mTitleText ;
    int mId= 0 ;
    String sortOrder ;
    static int mPage  ;
    private OnFragmentShowProductListListener mListener;

    public ShowProductListFragment() {
        // Required empty public constructor
    }


    /**
     * @param phrase  the phrase that use to retrieve products from  online shop.
     * @param type  type that indicate which way 'phrase' should be used
     *             , e.g category or search
     * @return
     */
    public static ShowProductListFragment newInstance(String title, String phrase
            , int type , int id ) {
        ShowProductListFragment fragment = new ShowProductListFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_PHRASE , phrase);
        args.putInt(EXTRA_TYPE , type);
        args.putString(EXTRA_TITLE , title);
        args.putInt(EXTRA_ID , id);
        fragment.setArguments(args);
        return fragment;
    }

    public static ShowProductListFragment newInstance(String search , String sortOrder) {
        ShowProductListFragment fragment = new ShowProductListFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_PHRASE , search);
        args.putString(EXTRA_TYPE , sortOrder);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int type = TYPE_ALL ;
        String phrase = "" ;
        if (getArguments() != null) {
            type = getArguments().getInt(EXTRA_TYPE , TYPE_ALL) ;
            phrase = getArguments().getString(EXTRA_PHRASE) ;
            mTitleText = getArguments().getString(EXTRA_TITLE , getString(R.string.products));
            mId = getArguments().getInt(EXTRA_ID , 0) ;
            sortOrder =  phrase = getArguments().getString(EXTRA_SORT_ORDER , "") ;
        }
        mPage = 1;
        mProductController = new ProductController(getContext() , this) ;
        mPhrase = phrase ;
        switch (type){
            case TYPE_ALL :
                mTypeOfFragment = TypeOfFragment.ALL ;
                break;
            case TYPE_CATEGORY :
                mTypeOfFragment = TypeOfFragment.CATEGORY ;
                break;
            case TYPE_SEARCH :
                mTypeOfFragment =TypeOfFragment.SEARCH;
                break;
            case TYPE_TAG :
                mTypeOfFragment = TypeOfFragment.TAG ;
                break;
            default:
                throw new IllegalArgumentException("unknown type int " +type);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_show_product_list, container, false);
        mRecyclerView = v.findViewById(R.id.listOfProductContainer_recyclerview) ;
        mShowAll =  v.findViewById(R.id.listOfProductContainer_complete_list_button) ;
        mTitle = v.findViewById(R.id.listOfProductContainer_title);
        mImageTitle = v.findViewById(R.id.listOfProductContainer_imageview);
        widgetContainer = v.findViewById(R.id.listOfProductContainer_widget_container);
        mTitle.setText(mTitleText);
        mShowAll.setText(R.string.show_all);
        mAdapter = new ShowProductListFragmentRecyclerAdapter(getContext() , this
        , mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL , false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollHorizontally(-1)) {
                    mPage+=1 ;
                    getProducts();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        setListeners();
        getProducts();
        return v ;
    }

    private void setListeners(){
        mShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext() , ProductListActivity.class) ;
                switch (mTypeOfFragment){
                    case CATEGORY:
                        intent.putExtra(ProductListActivity.EXTRA_TYPE
                                , ProductListActivity.TYPE_CATEGORY);
                        intent.putExtra(ProductListActivity.EXTRA_CATEGORY , mId);
                        startActivity(intent);
                        break;
                    case ALL:
                        intent.putExtra(ProductListActivity.EXTRA_TYPE ,
                                ProductListActivity.TYPE_ALL);
                        startActivity(intent);

                }
            }
        });
    }

    private void getProducts(){
        switch (mTypeOfFragment){
            case ALL:
                mProductController.getProducts(mPage , "" ,
                        CONSTANTS.SORT_ORDER_DATE);
                break;
            case TAG :
                break;
            case CATEGORY:
                mProductController.getProductByCategory(mPage , "" , mId);
                break;
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentShowProductListListener) {
            mListener = (OnFragmentShowProductListListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onProductAvailable(Product product) {

    }


    @Override
    public void onProductListAvailable(List<Product> productList) {
        Log.d(TAG, "onProductListAvailable: called");
        mAdapter.setProductItems(productList);
    }

    @Override
    public void onProductNotAvailable() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentShowProductListListener {
        // TODO: Update argument type and name
        void OnFragmentShowProductListListenerInteraction();
    }
}
