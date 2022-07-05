package com.example.kanpurwarrior.classes.adapters.view_pagers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductImagesAdapter extends PagerAdapter {

    private List<String> list;

    public ProductImagesAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());//here we are creating an ImageView through code and not XML
        Glide.with(container.getContext()).load(list.get(position)).into(imageView);
        container.addView(imageView,0);//officially adding our custom created view in ViewPager conatiner
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
