package com.example.newsapp;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiClass {
    private Retrofit retrofit=null;
    String baseUrl="https://newsapi.org/v2/";
    public apiInterface getInterface(){
        retrofit=new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(apiInterface.class);
    }
}
