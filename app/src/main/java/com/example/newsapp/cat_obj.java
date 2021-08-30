package com.example.newsapp;

public class cat_obj {
    int catImg;
    String catName;
    cat_obj(int id,String name){
        catImg=id;
        catName=name;
    }
    int getCatImg(){
        return catImg;
    }
    String getCatName(){
        return catName;
    }
}
