package com.example.newsapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
        CardView topNewscard=(CardView)findViewById(R.id.topcard);
        CardView allNewscard=(CardView)findViewById(R.id.allcard);
        topNewscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNext("top-headlines");
            }
        });
        allNewscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextinDataBase("everything");
            }
        });
    }
    void startNext(String store){
        Intent call=new Intent(SecondActivity.this,ThirdActivity.class);
        call.putExtra("from",store);
        startActivity(call);
    }
    void startNextinDataBase(String store){
        Intent call=new Intent(SecondActivity.this,AllNewsFourth.class);
        call.putExtra("from",store);
        startActivity(call);
    }
}
