package com.example.newsapp;

public class news_item {
    String author;
    String title;
    String description;
    String url;
    String urlToImage,publishedAt;
    news_item(String author,String title,String description,String url,String urlToImage,String publishedAt){
        if(author==null){
        this.author="N/A";}else{
            this.author=author;
        }
        this.title=title;
        if(description==null){this.description="Click to see details...";}else{
        this.description=description;}
        this.url=url;
        this.urlToImage=urlToImage;
        if(publishedAt==null){this.publishedAt="N/A";}else{
        this.publishedAt=publishedAt;}
    }
    String getTitle(){
        return  title;
    }
    String getDescription(){
        return description;
    }
    String getAuthor(){
        return author;
    }
    String getPublishedAt(){
        return publishedAt;
    }
    String getUrl(){
        return url;
    }
    String getUrlToImage(){
        return urlToImage;
    }
}
