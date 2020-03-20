package com.example.lab3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3.R;

public class GroupHolder extends  RecyclerView.ViewHolder{

    final TextView groupName;

    public GroupHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.lab3_item_student, parent, false));
        groupName = itemView.findViewById(R.id.groupName);
    }
}
