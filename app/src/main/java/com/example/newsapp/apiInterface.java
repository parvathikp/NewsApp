package com.example.newsapp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface apiInterface {
    @GET("top-headlines")
    Call<return_item> getTopNews(@QueryMap(encoded=true) Map<String,String> map,@QueryMap(encoded=true) Map<String,Integer> page);
    @GET("everything")
    Call<return_item> getAllNews(@QueryMap(encoded=true) Map<String,String> map,@QueryMap(encoded=true) Map<String,Integer> page);
}
