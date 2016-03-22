package com.thoughtworks.shoppingweb.domain;

/**
 * Created by szwang on 3/22/16.
 */
public class Product {

    private String product_id;
    private String product_name;
    private String product_city;
    private String product_image;
    private Double product_price;
    private Double product_vipprice;
    private String product_details_img;
    private String product_introduce;
    private String product_category;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_city() {
        return product_city;
    }

    public void setProduct_city(String product_city) {
        this.product_city = product_city;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Double getProduct_vipprice() {
        return product_vipprice;
    }

    public void setProduct_vipprice(Double product_vipprice) {
        this.product_vipprice = product_vipprice;
    }

    public String getProduct_details_img() {
        return product_details_img;
    }

    public void setProduct_details_img(String product_details_img) {
        this.product_details_img = product_details_img;
    }

    public String getProduct_introduce() {
        return product_introduce;
    }

    public void setProduct_introduce(String product_introduce) {
        this.product_introduce = product_introduce;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }
}
