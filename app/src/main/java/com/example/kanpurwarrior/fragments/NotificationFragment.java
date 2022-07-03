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

import com.example.kanpurwarrior.R;
import com.example.kanpurwarrior.classes.adapters.NotificationAdapter;
import com.example.kanpurwarrior.classes.models.NotificationModelList;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView=view.findViewById(R.id.notificationrecycler);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<NotificationModelList> list=new ArrayList<>();
        list.add(new NotificationModelList("Grapes",35));
        list.add(new NotificationModelList("Banana",30));
        list.add(new NotificationModelList("Apple",69));
        list.add(new NotificationModelList("Gauva",20));
        list.add(new NotificationModelList("Spinach",10));

        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter=new NotificationAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}