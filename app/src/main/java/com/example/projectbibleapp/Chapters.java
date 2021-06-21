package com.example.projectbibleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Chapters extends AppCompatActivity {
    int the_length=0;
    //ArrayList<ChapterModel> chapters;
    Integer[]chapters;
    Integer[]the_chapters;
    Context context;
    RecyclerView recyclerView;
    TextView text_book_name;
    String book_name,new_book_name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        text_book_name=findViewById(R.id.the_text_book_name);
        recyclerView=findViewById(R.id.recyclerview);
        Rearranging_book_name();
        text_book_name.setText(new_book_name);
        SharedPreferences sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("book_name",new_book_name);
        editor.apply();
        requestingFunction();

    }



    public void requestingFunction() {
        ChaptersService chaptersService = new ChaptersService(Chapters.this);
        chaptersService.book_chapters(new_book_name, new ChaptersService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(Chapters.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(ArrayList<ChapterModel> chapterSize) {

                recyclerView = findViewById(R.id.recyclerview);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                recyclerView.setLayoutManager(gridLayoutManager);
                ChaptersAdapter chaptersAdapter = new ChaptersAdapter(context, chapterSize);
                recyclerView.setAdapter(chaptersAdapter);


            }
        });


    }

    public void Rearranging_book_name() {
        String book_name = getIntent().getStringExtra("the_book");
        String trimed_book_name=book_name.trim();
        if(trimed_book_name.startsWith("1") || trimed_book_name.startsWith("2")||trimed_book_name.startsWith("3")) {
                String firstLetStr = book_name.substring(0, 2);
                String remLetStr = book_name.substring(1);
                remLetStr = remLetStr.toLowerCase();
                new_book_name=firstLetStr+remLetStr;
        }
            else{
                String firstLetStr = book_name.substring(0, 1);
                String remLetStr =book_name.substring(1);
                remLetStr = remLetStr.toLowerCase();
                new_book_name=firstLetStr+remLetStr;

            }



}

}
