package com.example.newsapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    List<cat_obj> catList=new ArrayList<>();
    ViewPager2 viewpager;
    private String store;
    @Override
    protected void onCreate(Bundle savedInstanceStates){
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_third);
        getSupportActionBar().hide();
        Bundle sectothird=getIntent().getExtras();
        store=sectothird.getString("from");
        catList.add(new cat_obj(R.drawable.general,"GENERAL"));
        catList.add(new cat_obj(R.drawable.science,"SCIENCE"));
        catList.add(new cat_obj(R.drawable.sports,"SPORTS"));
        catList.add(new cat_obj(R.drawable.business,"BUSINESS"));
        catList.add(new cat_obj(R.drawable.health,"HEALTH"));
        catList.add(new cat_obj(R.drawable.technology,"TECHNOLOGY"));
        catList.add(new cat_obj(R.drawable.entertain,"ENTERTAINMENT"));
        viewpager=(ViewPager2)findViewById(R.id.viewpager);
        CustomRecyclerAdapter customAdapter=new CustomRecyclerAdapter(ThirdActivity.this,catList,viewpager,store);
        viewpager.setAdapter(customAdapter);
        viewpager.setClipToPadding(false);
        viewpager.setClipChildren(false);
        viewpager.setOffscreenPageLimit(3);
        viewpager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        viewpager.setPageTransformer(compositePageTransformer);
    }
}
