package com.example.kanpurwarrior.classes.models;

import java.util.List;

public class HomePageModel {
    //Ye baap hai :  Jo multiple RVs banenge un sabka
    public static final int BANNER=0;
    public static final int HORIZONTAL=1;
    public static final int GRID=2;

    public int type = BANNER;
    String layoutTitle;
    public List<HorizontalItemModel> horizontalList;
    public List<ViewAllModel> viewAllList;
    //todo : Ek grid model banaye phir viewAllGridList ko waise type ka banaye warna galat ayega
    public List<ViewAllModel> viewAllGridList;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLayoutTitle() {
        return layoutTitle;
    }

    public void setLayoutTitle(String layoutTitle) {
        this.layoutTitle = layoutTitle;
    }

    public List<HorizontalItemModel> getHorizontalList() {
        return horizontalList;
    }

    public void setHorizontalList(List<HorizontalItemModel> horizontalList) {
        this.horizontalList = horizontalList;
    }
    public String bgColor;

    public HomePageModel(int type, String layoutTitle, List<HorizontalItemModel> horizontalList, String bgColor,List<ViewAllModel> viewAllGridList) {
        this.type = type;
        this.layoutTitle = layoutTitle;
        this.horizontalList = horizontalList;
        this.bgColor = bgColor;
        this.viewAllGridList=viewAllGridList;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public HomePageModel(int type, String layoutTitle, List<HorizontalItemModel> horizontalList,List<ViewAllModel> viewAllList) {
        this.type = type;
        this.layoutTitle = layoutTitle;
        this.horizontalList = horizontalList;
        this.viewAllList=viewAllList;
    }

    public List<ViewAllModel> getViewAllList() {
        return viewAllList;
    }

    public void setViewAllList(List<ViewAllModel> viewAllList) {
        this.viewAllList = viewAllList;
    }

    public List<ViewAllModel> getViewAllGridList() {
        return viewAllGridList;
    }

    public void setViewAllGridList(List<ViewAllModel> viewAllGridList) {
        this.viewAllGridList = viewAllGridList;
    }
}
