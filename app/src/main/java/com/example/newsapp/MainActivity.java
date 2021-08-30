package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         getSupportActionBar().hide();
         LottieAnimationView animView=findViewById(R.id.animation);
         Thread anim=new Thread(){
             @Override
             public void run() {
                 try{
                     sleep(3000);
                 }catch(Exception E){
                     Toast showMessage=Toast.makeText(getApplicationContext(),E+" this ",Toast.LENGTH_SHORT);
                     showMessage.show();
                 }finally {
                     Intent call=new Intent(MainActivity.this,SecondActivity.class);
                     startActivity(call);
                     finish();
                 }
             }
         };
         anim.start();
    }
}