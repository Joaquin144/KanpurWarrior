package com.example.kanpurwarrior.classes;

import com.example.kanpurwarrior.R;

public class CategoriesModel {
    public String categoryTitle;
    public int imageAddress=R.drawable.account_icon_image;

    public CategoriesModel(String categoryTitle, int imageAddress) {
        this.categoryTitle = categoryTitle;
        this.imageAddress = imageAddress;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(int imageAddress) {
        this.imageAddress = imageAddress;
    }
}
