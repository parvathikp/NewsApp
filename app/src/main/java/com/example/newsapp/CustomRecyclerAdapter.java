package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.customViewHolder>{
    List<cat_obj> data;Context context;
    ViewPager2 viewpager;
    String store;
    CustomRecyclerAdapter(Context context,List<cat_obj> info,ViewPager2 viewPager,String store){
        this.data=info;this.context=context;
        this.viewpager=viewPager;this.store=store;
    }
    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card,parent,false);
        return new customViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull customViewHolder holder, int position){
        cat_obj categ=data.get(position);
        holder.totalview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call=new Intent(context,FourthActivity.class);
                call.putExtra("from",store);
                call.putExtra("category",categ.getCatName());
                context.startActivity(call);
            }
        });
        holder.catImg.setImageResource(categ.getCatImg());
        holder.catName.setText(categ.getCatName());
        return;
    }
    @Override
    public int getItemCount(){
        return data.size();
    }
    class customViewHolder extends RecyclerView.ViewHolder{
        ImageView catImg;View totalview;
        TextView catName;
        public customViewHolder(View v){
            super(v);
            totalview=v;
            catImg=(ImageView)v.findViewById(R.id.catimg);
            catName=(TextView)v.findViewById(R.id.catname);
        }

        public ImageView getCatImg() {
            return catImg;
        }

        public TextView getCatName() {
            return catName;
        }
    }
}
