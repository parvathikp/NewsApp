package com.example.newsapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FourthActivity extends AppCompatActivity {
    String apikey="98471a005e61439984ba6ceb482e69af";
    String category,store,lang="Any",country="Any",keyword="";
    List<temp_obj>cntry,langs;List<news_item> data;int t=0,e=0;
    EditText keywd;Spinner langchoose,cntychoose;
    TextView head;
    EditText pageNo;int pages=1,totpages=1;
    TextView totPage;
    RecyclerView recycle;
    Button apply;
    Map<String,String> query;
    Map<String, Integer> pageQuery;
    customAdapter cntryad,langad;NewsRecycleAdapter newsad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        getSupportActionBar().hide();
        Bundle fromIntent=getIntent().getExtras();
        category=fromIntent.getString("category");
        store=fromIntent.getString("from");
        cntry=new ArrayList<>();langs=new ArrayList<>();
        data=new ArrayList<>();
        pageNo=(EditText)findViewById(R.id.page);
        totPage=(TextView)findViewById(R.id.total);
        query=new HashMap<>();pageQuery=new HashMap<>();
        head=(TextView)findViewById(R.id.catTitle);
        head.setText(category);
        recycle=(RecyclerView)findViewById(R.id.newslist);
        cntry.add(new temp_obj("Any","Any"));
        cntry.add(new temp_obj("India","in"));
        cntry.add(new temp_obj("Philippines","ph"));
        cntry.add(new temp_obj("Canada","ca"));
        cntry.add(new temp_obj("United States","us"));
        cntry.add(new temp_obj("United Kingdom","gb"));
        cntry.add(new temp_obj("Japan","jp"));
        cntry.add(new temp_obj("Singapore","sg"));
        langs.add(new temp_obj("Any","Any"));
        langs.add(new temp_obj("Arabic","ar"));
        langs.add(new temp_obj("German","de"));
        langs.add(new temp_obj("Any","Any"));
        langs.add(new temp_obj("English","en"));
        langs.add(new temp_obj("Spanish","es"));
        langs.add(new temp_obj("French","fr"));
        langs.add(new temp_obj("Hebrew","he"));
        langs.add(new temp_obj("Italian","it"));
        langs.add(new temp_obj("Dutch","nl"));
        langs.add(new temp_obj("Norwegian","no"));
        langs.add(new temp_obj("Portuguese","pt"));
        langs.add(new temp_obj("Russian","ru"));
        langs.add(new temp_obj("Chinese","zh"));
        query.put("category",category);query.put("apiKey",apikey);pageQuery.put("page",1);
        newsad=new NewsRecycleAdapter(this,data);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(newsad);
        seekResults();
        cntychoose =(Spinner)findViewById(R.id.country);
        langchoose=(Spinner)findViewById(R.id.lang);
        keywd=(EditText)findViewById(R.id.key);
        customAdapter cntyadapter=new customAdapter(this,cntry);
        cntychoose.setAdapter(cntyadapter);
        customAdapter langadapter=new customAdapter(this,langs);
        langchoose.setAdapter(langadapter);
        cntychoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country=cntry.get(position).getCode();return;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        langchoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lang=langs.get(position).getCode();return;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pageNo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                }else{
                    seekResults();
                }
            }
        });
        apply=(Button)findViewById(R.id.apply);
        apply.setOnClickListener(v -> {
            if(keywd.getText()==null){
                keyword="";query.remove("q");
            }else {
                keyword = keywd.getText().toString();
                query.put("q", keyword);
            }
            if(country=="Any"){
                query.remove("country");
            }else{
                query.put("country",country);
            }
            if(lang=="Any"){
                query.remove("language");
            }else{
                query.put("language",lang);
            }
            seekResults();
        });
    }
    void seekResults(){
        apiClass apiclass=new apiClass();if(pageNo.getText()==null){recycle.setVisibility(View.GONE);return;}
        pages=Integer.parseInt(pageNo.getText().toString());
        if(pages<=0){recycle.setVisibility(View.GONE);return;}
        pageQuery.put("page",pages);pageQuery.put("pageSize",20);
                apiclass.getInterface().getTopNews(query,pageQuery).enqueue(new Callback<return_item>() {
                          @Override
                          public void onResponse(Call<return_item> call, Response<return_item> response) {
                              return_item ret=response.body();if(ret==null){
                                  recycle.setVisibility(View.GONE);return;
                              }
                              data.clear();data.addAll(ret.getArticles());
                                  if(data.size()==0){
                                      recycle.setVisibility(View.GONE);
                                  }else{
                                      recycle.setVisibility(View.VISIBLE);totPage.setText(" / "+Integer.toString((int) Math.ceil((double)(ret.totalResults)/(double)(20))));
                                      newsad.notifyDataSetChanged();
                                  }
                          }
                          @Override
                          public void onFailure(Call<return_item> call, Throwable t) {
                                    t.printStackTrace();
                          }
                      }
                );
    }
}
