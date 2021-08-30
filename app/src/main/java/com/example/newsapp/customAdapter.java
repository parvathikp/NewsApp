package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class customAdapter extends BaseAdapter {
    List<temp_obj> data;Context ctx;
    public customAdapter(Context context,List<temp_obj> list){
        this.data=list;
        this.ctx=context;
    }
    @Override
    public int getCount() {
        return data.size();
    }
    @Override
    public temp_obj getItem(int i){
        return data.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null){
            v=LayoutInflater.from(ctx).inflate(R.layout.adapter,parent,false);
        }
        temp_obj obj=getItem(position);
        TextView txt=(TextView)v.findViewById(R.id.name11);
        txt.setText(obj.getName());return v;
    }
}
