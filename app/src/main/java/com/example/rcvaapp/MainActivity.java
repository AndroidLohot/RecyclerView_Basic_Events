package com.example.rcvaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRCV;
    private ArrayList<UserInfo> userInfosList;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRCV=(RecyclerView)findViewById(R.id.mainRCV);
        mainRCV.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        mainRCV.setLayoutManager(layoutManager);
        userInfosList=new ArrayList<>();
        UserInfo userInfo=new UserInfo("Yogesh","Lohot");

        userInfosList.add(userInfo);

        adapter=new MyAdapter(userInfo,userInfosList);

        mainRCV.setAdapter(adapter);


    }
}
