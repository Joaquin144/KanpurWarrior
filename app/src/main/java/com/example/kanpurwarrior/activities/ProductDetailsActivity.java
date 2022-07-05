package com.example.kanpurwarrior.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.kanpurwarrior.R;
import com.example.kanpurwarrior.classes.adapters.view_pagers.ProductImagesAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    private List<String> productImageList;
    private ViewPager pager;
    private TabLayout viewPagerDots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);//Hide the title from ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show back button on ActionBar

        showProductImagesList();
        //showProductDescription();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {//Back Button ke liye
            finish();//jab action bar par built in back button press ho tab is activity ko finish kar do
            return true;
        }
        return false;
    }
    private void showProductImagesList(){
        productImageList = new ArrayList<>();
        productImageList.add("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fstatic5.businessinsider.com%2Fimage%2F5691276ee6183e46258b59b7-1190-625%2Fel-chapo-guzmn-was-caught-because-he-was-trying-to-make-a-movie-about-himself.jpg&f=1&nofb=1");
        productImageList.add("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fww2.hdnux.com%2Fphotos%2F22%2F62%2F26%2F4924857%2F3%2FrawImage.jpg&f=1&nofb=1");
        productImageList.add("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwordpress.wbur.org%2Fwp-content%2Fuploads%2F2013%2F07%2F0716_zetas-leader.jpg&f=1&nofb=1");
        //productImageList.add("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fs.hdnux.com%2Fphotos%2F34%2F04%2F37%2F7358456%2F7%2F920x920.jpg&f=1&nofb=1");

        ProductImagesAdapter adapter = new ProductImagesAdapter(productImageList);
        pager = findViewById(R.id.productImageViewPager);
        pager.setAdapter(adapter);

        viewPagerDots = findViewById(R.id.viewPagerDots);
        viewPagerDots.setupWithViewPager(pager,true);
    }
    private void showProductDescription(){

    }
}