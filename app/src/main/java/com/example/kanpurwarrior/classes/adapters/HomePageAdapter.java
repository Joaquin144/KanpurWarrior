package com.example.kanpurwarrior.classes.adapters;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kanpurwarrior.R;
import com.example.kanpurwarrior.activities.ProductDetailsActivity;
import com.example.kanpurwarrior.activities.ViewAllActivity;
import com.example.kanpurwarrior.classes.models.HomePageModel;
import com.example.kanpurwarrior.classes.models.HorizontalItemModel;
import com.example.kanpurwarrior.classes.models.ViewAllModel;

import java.util.List;

import static com.example.kanpurwarrior.activities.ViewAllActivity.viewAllActivityList;
import static com.example.kanpurwarrior.classes.models.HomePageModel.BANNER;
import static com.example.kanpurwarrior.classes.models.HomePageModel.GRID;
import static com.example.kanpurwarrior.classes.models.HomePageModel.HORIZONTAL;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> list;

    public HomePageAdapter(List<HomePageModel> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        switch(list.get(position).getType())
        {
            case BANNER: return 0;
            case HORIZONTAL: return 1;
            case GRID: return 2;
            default: return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType)
        {
            case HORIZONTAL:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_slider_layout,parent,false);
                return new HorizontalProductView(view1);


            case GRID:View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout,parent,false);
                return new GridProductView(view2);

            //case BANNER:


            default: Log.e("####","HomePageAdapter : inside RecyclerView.ViewHolder onCreateViewHolder(...) ->default case: returning null Bhatt the Phook?");
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Yaad rakhein onBindViewHolder(...) ka kaam hota hai sabhi data ko set karna
        switch(list.get(position).getType())
        {
            case HORIZONTAL:
                ((HorizontalProductView)holder).setHorizontalData(list.get(position).getLayoutTitle(),list.get(position).getHorizontalList(),list.get(position).getViewAllList());break;
            case GRID:
                ((GridProductView)holder).setGridData(list.get(position).getBgColor(),list.get(position).getLayoutTitle(),list.get(position).getHorizontalList(),list.get(position).getViewAllGridList());
        }
    }

    @Override
    public int getItemCount() { return list.size(); }

    public class HorizontalProductView extends RecyclerView.ViewHolder
    {
        private TextView layoutTitleTv;
        private RecyclerView recyclerView;
        private Button viewAllBtn;

        public HorizontalProductView(@NonNull View itemView) {
            super(itemView);
            layoutTitleTv = itemView.findViewById(R.id.layoutTitle);
            recyclerView = itemView.findViewById(R.id.horizontalScrollRecyclerView);
            viewAllBtn = itemView.findViewById(R.id.viewAllBtn);
        }
        public void setHorizontalData(String title, List<HorizontalItemModel> horizontalList, List<ViewAllModel> viewAllList)
        {
            layoutTitleTv.setText(title);
            LinearLayoutManager horizontalRvManager=new LinearLayoutManager(itemView.getContext());
            horizontalRvManager.setOrientation(RecyclerView.HORIZONTAL);
            recyclerView.setLayoutManager(horizontalRvManager);
            HorizontalProductAdapter horiAdapter=new HorizontalProductAdapter(horizontalList);
            recyclerView.setAdapter(horiAdapter);
            horiAdapter.notifyDataSetChanged();

            viewAllBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //to do: take me to the new activity where full list is being shown to me
                    viewAllActivityList = viewAllList;
                    Intent viewAllIntent=new Intent(itemView.getContext(), ViewAllActivity.class);
                    viewAllIntent.putExtra("layout_title",title);
                    itemView.getContext().startActivity(viewAllIntent);
                }
            });
        }
    }

    public class GridProductView extends RecyclerView.ViewHolder
    {
        private ConstraintLayout rootLayout;
        private GridLayout gridLayout;
        private TextView layoutTitle;
        private Button viewAllGridBtn;

        public GridProductView(@NonNull View itemView) {
            super(itemView);
            rootLayout=itemView.findViewById(R.id.gridParentLayout);
            gridLayout=itemView.findViewById(R.id.gridProdLayout);
            layoutTitle=itemView.findViewById(R.id.layoutTitle);
            viewAllGridBtn=itemView.findViewById(R.id.viewAllBtn);
        }
        public void setGridData(String backgroundColor,String title,List<HorizontalItemModel> gridList,List<ViewAllModel> viewList){
            rootLayout.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(backgroundColor)));
            layoutTitle.setText(title);
            for(int x=0;x<4;x++) {
                TextView prodTitle = gridLayout.getChildAt(x).findViewById(R.id.titleTv);
                TextView prodSubtitle = gridLayout.getChildAt(x).findViewById(R.id.subtitleTv);
                TextView prodPrice = gridLayout.getChildAt(x).findViewById(R.id.priceTv);
                ImageView prodImage=gridLayout.getChildAt(x).findViewById(R.id.productImageView);

                prodTitle.setText(gridList.get(x).getTitle());
                prodSubtitle.setText(gridList.get(x).getSubtitle());
                prodPrice.setText(gridList.get(x).getPrice());

                Glide.with(itemView.getContext()).load(itemView.getResources().getDrawable(gridList.get(x).getImageResource())).into(prodImage);
                prodImage.setImageDrawable(itemView.getResources().getDrawable(gridList.get(x).getImageResource()));

                //Set onClickListener on grid items and intent to ProductDetailsActivity by passing productId
                gridLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                        itemView.getContext().startActivity(intent);
                    }
                });

            }
            viewAllGridBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewAllActivityList = viewList;
                    Intent intent =new Intent(itemView.getContext(),ViewAllActivity.class);
                    intent.putExtra("layout_title",title);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

    }

}
