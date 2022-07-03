package com.example.kanpurwarrior.classes.models;

public class ViewAllModel {

    private String productTitle,productSubtitle,productPrice,productNormalPrice;
    private int productImage;

    public ViewAllModel(int productImage, String productTitle, String productSubtitle, String productPrice, String productNormalPrice) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.productSubtitle = productSubtitle;
        this.productPrice = productPrice;
        this.productNormalPrice = productNormalPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductSubtitle() {
        return productSubtitle;
    }

    public void setProductSubtitle(String productSubtitle) {
        this.productSubtitle = productSubtitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductNormalPrice() {
        return productNormalPrice;
    }

    public void setProductNormalPrice(String productNormalPrice) {
        this.productNormalPrice = productNormalPrice;
    }
}
