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

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {

    private List<ViewAllModel> list;

    public ViewAllAdapter(List<ViewAllModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_all,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTV,subtitleTV,priceTV,normalPriceTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.idItemViewAllIV);
            titleTV=itemView.findViewById(R.id.idViewAllTitleTv);
            subtitleTV=itemView.findViewById(R.id.idViewAllSubtitleTv);
            priceTV=itemView.findViewById(R.id.idViewAllPriceTV);
            normalPriceTV=itemView.findViewById(R.id.idViewAllNormalPriceTV);
        }

        public void setData(int position) {
            imageView.setImageDrawable(itemView.getResources().getDrawable(list.get(position).getProductImage()));
            titleTV.setText(list.get(position).getProductTitle());
            subtitleTV.setText(list.get(position).getProductSubtitle());
            priceTV.setText(list.get(position).getProductPrice());
            normalPriceTV.setText(list.get(position).getProductNormalPrice());
        }
    }
}
