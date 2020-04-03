package com.example.rcvaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<UserInfo> arrayList;
    private userInfoEvents userInfoEvents;

    public MyAdapter(ArrayList<UserInfo> arrayList, MyAdapter.userInfoEvents userInfoEvents) {
        this.arrayList = arrayList;
        this.userInfoEvents = userInfoEvents;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout .user_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UserInfo userInfo=arrayList.get(position);

        holder.fName.setText(userInfo.getfName());
        holder.lName.setText(userInfo.getlName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView fName,lName;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fName=(TextView)itemView.findViewById(R.id.tvFirstName);
            lName=(TextView)itemView.findViewById(R.id.tvLastName);
            view=itemView.findViewById(R.id.idLL);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();

            userInfoEvents.eventsClick(arrayList.get(position));
        }
    }

    public interface userInfoEvents
    {
        void eventsClick(UserInfo userInfo);
    }
}
