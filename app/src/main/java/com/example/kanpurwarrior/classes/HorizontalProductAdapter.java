package com.example.kanpurwarrior.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanpurwarrior.R;

import java.util.List;

public class HorizontalProductAdapter extends RecyclerView.Adapter<HorizontalProductAdapter.ViewHolder> {

    private List<HorizontalItemModel> list;

    public HorizontalProductAdapter(List<HorizontalItemModel> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public HorizontalProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_product_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductAdapter.ViewHolder holder, int position) {

        holder.setData(list.get(position).getImageResource(),list.get(position).getTitle(),list.get(position).getSubtitle(),list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTv,subttitleTv,priceTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.productImageView);
            titleTv=itemView.findViewById(R.id.titleTv);
            subttitleTv=itemView.findViewById(R.id.subtitleTv);
            priceTv=itemView.findViewById(R.id.priceTv);
        }

        public void setData(int imageResource,String title,String subtitle,String price)
        {
            titleTv.setText(title);
            subttitleTv.setText(subtitle);
            priceTv.setText(price);
            imageView.setImageDrawable(itemView.getResources().getDrawable(imageResource));
        }
    }
}
