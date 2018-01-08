package com.tehran.amir.aria.woocommerceinterfaceonlineshop.contracts;

/**
 * Created by amir on 1/7/2018.
 */

public class CartOrderContract {
    public static final String TABLE_NAME = "order" ;

    public class Columns{
        private Columns() {
        }

        public static final String _ID = "id" ;
        public static final String ORDER_PRODUCT_ID  = "productID" ;
        public static final String ORDER_PRODUCTNAME  = "productName" ;
        public static final String ORDER_PRODUCT_PRICE  = "price" ;
        public static final String ORDER_PRODUCT_QUANTITY  = "quantity" ;
        public static final String ORDER_PRODUCT_URL  = "url" ;
        public static final String ORDER_PRODUCT_IMAGE  = "image" ;
    }


}
