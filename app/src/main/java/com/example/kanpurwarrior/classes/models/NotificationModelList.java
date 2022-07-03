package com.example.kanpurwarrior.classes.models;

public class NotificationModelList {

    String fruitName;
    int qty;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public NotificationModelList(String s, int i) {
        this.fruitName=s;
        this.qty=i;
    }
}
