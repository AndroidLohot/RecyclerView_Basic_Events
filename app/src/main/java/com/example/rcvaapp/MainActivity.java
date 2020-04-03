package com.example.rcvaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.userInfoEvents{

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

        adapter=new MyAdapter(userInfosList,this);

        mainRCV.setAdapter(adapter);


    }

    @Override
    public void eventsClick(UserInfo userInfo) {

        Intent intent=new Intent(MainActivity.this, SecondeActivity.class);
        Toast.makeText(MainActivity.this,userInfo.getfName(),Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
}
