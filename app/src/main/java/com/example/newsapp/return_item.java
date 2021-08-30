package com.example.newsapp;

import java.util.List;

public class return_item {
    String status;
    public int totalResults;
    List<news_item> articles;
    return_item(String status,int totalResults,List<news_item> articles){
        this.status=status;
        this.totalResults=totalResults;
        this.articles=articles;
    }
    List<news_item> getArticles(){
        return articles;
    }
}
