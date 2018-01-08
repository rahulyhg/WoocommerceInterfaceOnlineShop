package com.tehran.amir.aria.woocommerceinterfaceonlineshop.Models;

import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Dimensions;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Download;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Image;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Links;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.MetaData;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Tag;
import com.tehran.amir.aria.woocommerceinterfaceonlineshop.subModels.Variation;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by amir on 1/4/2018.
 */

public class Product
{
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String slug;

    public String getSlug() { return this.slug; }

    public void setSlug(String slug) { this.slug = slug; }

    private String permalink;

    public String getPermalink() { return this.permalink; }

    public void setPermalink(String permalink) { this.permalink = permalink; }

    private Date date_created;

    public Date getDateCreated() { return this.date_created; }

    public void setDateCreated(Date date_created) { this.date_created = date_created; }

    private Date date_created_gmt;

    public Date getDateCreatedGmt() { return this.date_created_gmt; }

    public void setDateCreatedGmt(Date date_created_gmt) { this.date_created_gmt = date_created_gmt; }

    private Date date_modified;

    public Date getDateModified() { return this.date_modified; }

    public void setDateModified(Date date_modified) { this.date_modified = date_modified; }

    private Date date_modified_gmt;

    public Date getDateModifiedGmt() { return this.date_modified_gmt; }

    public void setDateModifiedGmt(Date date_modified_gmt) { this.date_modified_gmt = date_modified_gmt; }

    private String type;

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private String status;

    public String getStatus() { return this.status; }

    public void setStatus(String status) { this.status = status; }

    private boolean featured;

    public boolean getFeatured() { return this.featured; }

    public void setFeatured(boolean featured) { this.featured = featured; }

    private String catalog_visibility;

    public String getCatalogVisibility() { return this.catalog_visibility; }

    public void setCatalogVisibility(String catalog_visibility) { this.catalog_visibility = catalog_visibility; }

    private String description;

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    private String short_description;

    public String getShortDescription() { return this.short_description; }

    public void setShortDescription(String short_description) { this.short_description = short_description; }

    private String sku;

    public String getSku() { return this.sku; }

    public void setSku(String sku) { this.sku = sku; }

    private String price;

    public String getPrice() { return this.price; }

    public void setPrice(String price) { this.price = price; }

    private String regular_price;

    public String getRegularPrice() { return this.regular_price; }

    public void setRegularPrice(String regular_price) { this.regular_price = regular_price; }

    private String sale_price;

    public String getSalePrice() { return this.sale_price; }

    public void setSalePrice(String sale_price) { this.sale_price = sale_price; }

    private Date date_on_sale_from;

    public Date getDateOnSaleFrom() { return this.date_on_sale_from; }

    public void setDateOnSaleFrom(Date date_on_sale_from) { this.date_on_sale_from = date_on_sale_from; }

    private Date date_on_sale_from_gmt;

    public Date getDateOnSaleFromGmt() { return this.date_on_sale_from_gmt; }

    public void setDateOnSaleFromGmt(Date date_on_sale_from_gmt) { this.date_on_sale_from_gmt = date_on_sale_from_gmt; }

    private Date date_on_sale_to;

    public Date getDateOnSaleTo() { return this.date_on_sale_to; }

    public void setDateOnSaleTo(Date date_on_sale_to) { this.date_on_sale_to = date_on_sale_to; }

    private Date date_on_sale_to_gmt;

    public Date getDateOnSaleToGmt() { return this.date_on_sale_to_gmt; }

    public void setDateOnSaleToGmt(Date date_on_sale_to_gmt) { this.date_on_sale_to_gmt = date_on_sale_to_gmt; }

    private String price_html;

    public String getPriceHtml() { return this.price_html; }

    public void setPriceHtml(String price_html) { this.price_html = price_html; }

    private boolean on_sale;

    public boolean getOnSale() { return this.on_sale; }

    public void setOnSale(boolean on_sale) { this.on_sale = on_sale; }

    private boolean purchasable;

    public boolean getPurchasable() { return this.purchasable; }

    public void setPurchasable(boolean purchasable) { this.purchasable = purchasable; }

    private int total_sales;

    public int getTotalSales() { return this.total_sales; }

    public void setTotalSales(int total_sales) { this.total_sales = total_sales; }

    private boolean virtual;

    public boolean getVirtual() { return this.virtual; }

    public void setVirtual(boolean virtual) { this.virtual = virtual; }

    private boolean downloadable;

    public boolean getDownloadable() { return this.downloadable; }

    public void setDownloadable(boolean downloadable) { this.downloadable = downloadable; }

    private ArrayList<Download> downloads;

    public ArrayList<Download> getDownloads() { return this.downloads; }

    public void setDownloads(ArrayList<Download> downloads) { this.downloads = downloads; }

    private int download_limit;

    public int getDownloadLimit() { return this.download_limit; }

    public void setDownloadLimit(int download_limit) { this.download_limit = download_limit; }

    private int download_expiry;

    public int getDownloadExpiry() { return this.download_expiry; }

    public void setDownloadExpiry(int download_expiry) { this.download_expiry = download_expiry; }

    private String external_url;

    public String getExternalUrl() { return this.external_url; }

    public void setExternalUrl(String external_url) { this.external_url = external_url; }

    private String button_text;

    public String getButtonText() { return this.button_text; }

    public void setButtonText(String button_text) { this.button_text = button_text; }

    private String tax_status;

    public String getTaxStatus() { return this.tax_status; }

    public void setTaxStatus(String tax_status) { this.tax_status = tax_status; }

    private String tax_class;

    public String getTaxClass() { return this.tax_class; }

    public void setTaxClass(String tax_class) { this.tax_class = tax_class; }

    private boolean manage_stock;

    public boolean getManageStock() { return this.manage_stock; }

    public void setManageStock(boolean manage_stock) { this.manage_stock = manage_stock; }

    private int stock_quantity;

    public int getStockQuantity() { return this.stock_quantity; }

    public void setStockQuantity(int stock_quantity) { this.stock_quantity = stock_quantity; }

    private boolean in_stock;

    public boolean getInStock() { return this.in_stock; }

    public void setInStock(boolean in_stock) { this.in_stock = in_stock; }

    private String backorders;

    public String getBackorders() { return this.backorders; }

    public void setBackorders(String backorders) { this.backorders = backorders; }

    private boolean backorders_allowed;

    public boolean getBackordersAllowed() { return this.backorders_allowed; }

    public void setBackordersAllowed(boolean backorders_allowed) { this.backorders_allowed = backorders_allowed; }

    private boolean backordered;

    public boolean getBackordered() { return this.backordered; }

    public void setBackordered(boolean backordered) { this.backordered = backordered; }

    private boolean sold_individually;

    public boolean getSoldIndividually() { return this.sold_individually; }

    public void setSoldIndividually(boolean sold_individually) { this.sold_individually = sold_individually; }

    private String weight;

    public String getWeight() { return this.weight; }

    public void setWeight(String weight) { this.weight = weight; }

    private Dimensions dimensions;

    public Dimensions getDimensions() { return this.dimensions; }

    public void setDimensions(Dimensions dimensions) { this.dimensions = dimensions; }

    private boolean shipping_required;

    public boolean getShippingRequired() { return this.shipping_required; }

    public void setShippingRequired(boolean shipping_required) { this.shipping_required = shipping_required; }

    private boolean shipping_taxable;

    public boolean getShippingTaxable() { return this.shipping_taxable; }

    public void setShippingTaxable(boolean shipping_taxable) { this.shipping_taxable = shipping_taxable; }

    private String shipping_class;

    public String getShippingClass() { return this.shipping_class; }

    public void setShippingClass(String shipping_class) { this.shipping_class = shipping_class; }

    private int shipping_class_id;

    public int getShippingClassId() { return this.shipping_class_id; }

    public void setShippingClassId(int shipping_class_id) { this.shipping_class_id = shipping_class_id; }

    private boolean reviews_allowed;

    public boolean getReviewsAllowed() { return this.reviews_allowed; }

    public void setReviewsAllowed(boolean reviews_allowed) { this.reviews_allowed = reviews_allowed; }

    private String average_rating;

    public String getAverageRating() { return this.average_rating; }

    public void setAverageRating(String average_rating) { this.average_rating = average_rating; }

    private int rating_count;

    public int getRatingCount() { return this.rating_count; }

    public void setRatingCount(int rating_count) { this.rating_count = rating_count; }

    private ArrayList<Integer> related_ids;

    public ArrayList<Integer> getRelatedIds() { return this.related_ids; }

    public void setRelatedIds(ArrayList<Integer> related_ids) { this.related_ids = related_ids; }

    private ArrayList<Integer> upsell_ids;

    public ArrayList<Integer> getUpsellIds() { return this.upsell_ids; }

    public void setUpsellIds(ArrayList<Integer> upsell_ids) { this.upsell_ids = upsell_ids; }

    private ArrayList<Integer> cross_sell_ids;

    public ArrayList<Integer> getCrossSellIds() { return this.cross_sell_ids; }

    public void setCrossSellIds(ArrayList<Integer> cross_sell_ids) { this.cross_sell_ids = cross_sell_ids; }

    private int parent_id;

    public int getParentId() { return this.parent_id; }

    public void setParentId(int parent_id) { this.parent_id = parent_id; }

    private String purchase_note;

    public String getPurchaseNote() { return this.purchase_note; }

    public void setPurchaseNote(String purchase_note) { this.purchase_note = purchase_note; }

    private ArrayList<ProductCategory> categories;

    public ArrayList<ProductCategory> getCategories() { return this.categories; }

    public void setCategories(ArrayList<ProductCategory> categories) { this.categories = categories; }

    private ArrayList<Tag> tags;

    public ArrayList<Tag> getTags() { return this.tags; }

    public void setTags(ArrayList<Tag> tags) { this.tags = tags; }

    private ArrayList<Image> images;

    public ArrayList<Image> getImages() { return this.images; }

    public void setImages(ArrayList<Image> images) { this.images = images; }

    private ArrayList<Attributes> attributes;

    public ArrayList<Attributes> getAttributes() { return this.attributes; }

    public void setAttributes(ArrayList<Attributes> attributes) { this.attributes = attributes; }

    private ArrayList<Attributes> default_attributes;

    public ArrayList<Attributes> getDefaultAttributes() { return this.default_attributes; }

    public void setDefaultAttributes(ArrayList<Attributes> default_attributes) { this.default_attributes = default_attributes; }

    private ArrayList<Variation> variations;

    public ArrayList<Variation> getVariations() { return this.variations; }

    public void setVariations(ArrayList<Variation> variations) { this.variations = variations; }

    private ArrayList<Product> grouped_products;

    public ArrayList<Product> getGroupedProducts() { return this.grouped_products; }

    public void setGroupedProducts(ArrayList<Product> grouped_products) { this.grouped_products = grouped_products; }

    private int menu_order;

    public int getMenuOrder() { return this.menu_order; }

    public void setMenuOrder(int menu_order) { this.menu_order = menu_order; }

    private ArrayList<MetaData> meta_data;

    public ArrayList<MetaData> getMetaData() { return this.meta_data; }

    public void setMetaData(ArrayList<MetaData> meta_data) { this.meta_data = meta_data; }

    private Links _links;

    public Links getLinks() { return this._links; }

    public void setLinks(Links _links) { this._links = _links; }
}
