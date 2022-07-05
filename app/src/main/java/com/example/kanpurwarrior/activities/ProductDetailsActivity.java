package com.example.kanpurwarrior.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.kanpurwarrior.R;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);//Hide the title from ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show back button on ActionBar
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {//Back Button ke liye
            finish();//jab action bar par built in back button press ho tab is activity ko finish kar do
            return true;
        }
        return false;
    }
}