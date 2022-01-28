package com.example.kanpurwarrior.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kanpurwarrior.R;
import com.example.kanpurwarrior.classes.CategoriesAdapter;
import com.example.kanpurwarrior.classes.CategoriesModel;
import com.example.kanpurwarrior.classes.HomePageAdapter;
import com.example.kanpurwarrior.classes.HomePageModel;
import com.example.kanpurwarrior.classes.HorizontalItemModel;
import com.example.kanpurwarrior.classes.HorizontalProductAdapter;
import com.example.kanpurwarrior.classes.ViewAllModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.kanpurwarrior.classes.HomePageModel.GRID;
import static com.example.kanpurwarrior.classes.HomePageModel.HORIZONTAL;

public class HomeFragment extends Fragment {

    private RecyclerView categoriesRV,homeMainRv;
    private TextView scrollableTV;
    private List<CategoriesModel> categoryList;
    private List<HorizontalItemModel> horizontalList;
    private List<HomePageModel> homeList;
    private List<ViewAllModel> viewAllModelList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        categoriesRV=view.findViewById(R.id.categoriesRV);
        scrollableTV=view.findViewById(R.id.scrollableTV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeList=new ArrayList<>();
        homeMainRv=view.findViewById(R.id.homeRecyclerView);


        //Scrollable Text code starts
        scrollableTV.setText("Buy JEE,NEET,UPSC,SSC,AirForce,NDA,Railway group D,Bihar Staet board, UP Board, Rajasthan PCS , NDRF , Income tax all courses are available. Personal guidance availbele.  875446465461 , 46413213 , 74654541 , asufuisdgfuds, sfgsfiugsdf");
        scrollableTV.setSelected(true);
        //Scrollable Text code ends


        //Categories Recycler View Code starts
        categoryList=new ArrayList<>();
        categoryList.add(new CategoriesModel("Home",R.drawable.home_icon_image));
        categoryList.add(new CategoriesModel("Account",R.drawable.account_icon_image));
        categoryList.add(new CategoriesModel("Profile",R.drawable.account_icon_image));
        categoryList.add(new CategoriesModel("Test Series",R.drawable.test_icon_image));
        categoryList.add(new CategoriesModel("Notes",R.drawable.notes_icon_image));
        categoryList.add(new CategoriesModel("Courses",R.drawable.my_courses_icon_image));
        categoryList.add(new CategoriesModel("Syllabus",R.drawable.notes_icon_image));

        CategoriesAdapter adapter=new CategoriesAdapter(categoryList);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        categoriesRV.setLayoutManager(manager);
        categoriesRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //Categories Recycler View Code ends


        //Horizontal Recycler View Code starts
        horizontalList=new ArrayList<>();
        horizontalList.add(new HorizontalItemModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-"));
        horizontalList.add(new HorizontalItemModel(R.drawable.home_icon_image,"Live Test 2","PDF Download","Rs 999/-"));
        horizontalList.add(new HorizontalItemModel(R.drawable.info_icon_image,"Live Test 3","PDF Download","Rs 101/-"));
        horizontalList.add(new HorizontalItemModel(R.drawable.notes_icon_image,"Live Test 4","Ebook Download","Rs 599/-"));
        horizontalList.add(new HorizontalItemModel(R.drawable.account_icon_image,"Live Test 5","PDF Download","Free"));


        //ViewAll list:----
        viewAllModelList = new ArrayList<>();
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"JEE Course","Pdf download","FREE","Rs 2345/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.info_icon_image,"NEET Course","Epub download","Rs 20/-","Rs 22222/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.support_icon_image,"UPSC Course","Pdf download","Kyun bataye","Rs 0/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.youtube_icon_image,"JEE Course","Pdf download","FREE","Rs 2345/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.test_icon_image,"JEE Course","Pdf download","FREE","Rs 2345/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.support_icon_image,"Jsdgsdgurse","Pdf download","FREE","Rs 2345/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.telegram_icon_image,"Jfsdgge","Pdf download","FREE","Rs 2345/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.close_btn,"4243e","Pdf download","FREE","Rs 2345/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.telegram_icon_image,"sdsdfvCourse","Pdf download","FREE","Rs 2345/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        viewAllModelList.add(new ViewAllModel(R.drawable.account_icon_image,"Live Test 1","PDF Download","Rs 599/-","Rs 2000/-"));
        //----------------              ViewAll list:

        //Main RV's code begins
        homeList.add(new HomePageModel(HORIZONTAL,"Demo Title 1",horizontalList,viewAllModelList));
        homeList.add(new HomePageModel(GRID,"Welcome Title 2",horizontalList,"#fff333",viewAllModelList));
        homeList.add(new HomePageModel(HORIZONTAL,"Go Title 3",horizontalList,viewAllModelList));
        homeList.add(new HomePageModel(HORIZONTAL,"Get Title 4",horizontalList,viewAllModelList));
        homeList.add(new HomePageModel(HORIZONTAL,"Set Title 5",horizontalList,viewAllModelList));


        LinearLayoutManager homeLM=new LinearLayoutManager(getContext());
        homeLM.setOrientation(RecyclerView.VERTICAL);
        homeMainRv.setLayoutManager(homeLM);
        HomePageAdapter homePageAdapter=new HomePageAdapter(homeList);
        homeMainRv.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();
    }
}