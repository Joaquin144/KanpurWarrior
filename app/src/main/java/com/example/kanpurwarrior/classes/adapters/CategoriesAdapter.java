package com.example.kanpurwarrior.classes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanpurwarrior.R;
import com.example.kanpurwarrior.classes.models.CategoriesModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<CategoriesModel> list;

    public CategoriesAdapter(List<CategoriesModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        holder.setData(list.get(position).getCategoryTitle(),list.get(position).getImageAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.categoryImageIcon);
            title=itemView.findViewById(R.id.categoryTitleTv);
        }

        public void setData(String name,int imageResource){
            title.setText(name);
            image.setImageDrawable(itemView.getResources().getDrawable(imageResource));

        }
    }
}
