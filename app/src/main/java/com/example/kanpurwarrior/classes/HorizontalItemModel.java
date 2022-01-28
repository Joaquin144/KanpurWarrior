package com.example.kanpurwarrior.classes;

public class HorizontalItemModel {


    int imageResource;
    String title,subtitle,price;

    public HorizontalItemModel(int imageResource, String title, String subtitle, String price) {
        this.imageResource = imageResource;
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
