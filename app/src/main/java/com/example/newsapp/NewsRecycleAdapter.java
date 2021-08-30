package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class NewsRecycleAdapter extends RecyclerView.Adapter<NewsRecycleAdapter.customHolder> {
    List<news_item> data;
    Context ctx;
    NewsRecycleAdapter(Context context,List<news_item> data){
        super();
        this.ctx=context;
        this.data=data;
    }
    @NonNull
    @Override
    public NewsRecycleAdapter.customHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          return new customHolder(LayoutInflater.from(ctx).inflate(R.layout.newsitem,parent,false));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecycleAdapter.customHolder holder, int position){
        news_item obj=data.get(position);
        holder.title.setText(obj.getTitle());
        holder.author.setText(obj.getAuthor());
        holder.desc.setText(obj.getDescription());
        holder.date.setText(obj.getPublishedAt());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web=new Intent(ctx,webview.class);
                web.putExtra("url",obj.getUrl());
                ctx.startActivity(web);
            }
        });
        Glide.with(ctx).load(obj.getUrlToImage()).into(holder.img);
    }
    public class customHolder extends RecyclerView.ViewHolder{
        CardView card;
        ImageView img;
        TextView title,desc,author,date;
        public customHolder(View v){
            super(v);
            card=v.findViewById(R.id.cardnews);
            img=v.findViewById(R.id.image);
            title=v.findViewById(R.id.headline);
            desc=v.findViewById(R.id.description);
            author=v.findViewById(R.id.author);
            date=v.findViewById(R.id.time);
        }
    }
}
