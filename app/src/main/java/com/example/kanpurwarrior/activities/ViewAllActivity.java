package com.example.kanpurwarrior.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kanpurwarrior.R;
import com.example.kanpurwarrior.classes.adapters.ViewAllAdapter;
import com.example.kanpurwarrior.classes.models.ViewAllModel;

import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private String layoutTitle;
    public static List<ViewAllModel> viewAllActivityList;   ///--> Isko public hi rakhna kyuki bahar se access ki jayegi
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        recyclerView=findViewById(R.id.viewAllRV);
        layoutTitle=getIntent().getStringExtra("layout_title");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(layoutTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//ye action bar pe ek in built back button de dega

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        ViewAllAdapter adapter = new ViewAllAdapter(viewAllActivityList);
        Log.d("####","viewAllActivityList ka size inside ViewAllActivity hai  "+viewAllActivityList.size());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_action_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();//jab action bar par built in back button press ho tab is activity ko finish kar do
            return true;
        }
        else if(item.getItemId()==R.id.action_noti) {
            Toast.makeText(ViewAllActivity.this, "You have 0 notifications", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}