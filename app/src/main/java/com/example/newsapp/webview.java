package com.example.newsapp;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class webview extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weblayout);
        web=(WebView)findViewById(R.id.webContent);
        String url=getIntent().getExtras().getString("url");
        web.getSettings().setLoadsImagesAutomatically(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setAllowContentAccess(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url);
    }
}
