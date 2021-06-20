package com.example.projectbibleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Verses extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    int chapter_number;
    TextView display_book_name,display_chapter_number;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor2;
    String book_name;
    boolean is_dark_mode_on;
    DrawerLayout drawerLayout;
    //LinearLayout linearLayout;
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

       // linearLayout=findViewById(R.id.dark_light_theme);
       // imageView.findViewById(R.id.more);
        display_book_name=findViewById(R.id.bible_book_name);
        display_chapter_number=findViewById(R.id.bible_chapter_number);
        drawerLayout=findViewById(R.id.drawer_layout);



       // darkLightTheme();
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ClickDayNight2();
//                Toast.makeText(Verses.this,"day night",Toast.LENGTH_SHORT).show();
//            }
//        });

        chapter_number = getIntent().getIntExtra("chapter_number",0);
        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        book_name= sharedPreferences.getString("book_name","");
        display_verses();
        display_book_name.setText(book_name);
        display_chapter_number.setText(Integer.toString(chapter_number));
    }


    public void ClickMenu(View view){
        openDrawer(drawerLayout);


    }
    public void ClickHome(View view){
        Toast.makeText(Verses.this,"Clicked home",Toast.LENGTH_SHORT).show();
    }
    public void ClickDailyVerses(View view){
        Toast.makeText(Verses.this,"Clicked daily verses",Toast.LENGTH_SHORT).show();
    }
    public void ClickBookmarks(View view){
        Toast.makeText(Verses.this,"Clicked bookmarks",Toast.LENGTH_SHORT).show();
    }
    public void ClickNotes(View view){

        Toast.makeText(Verses.this,"Clicked notes",Toast.LENGTH_SHORT).show();
    }
    public void ClickHighlights(View view){

        Toast.makeText(Verses.this,"Clicked highlights",Toast.LENGTH_SHORT).show();
    }
    public void ClickSettings(View view){

        Toast.makeText(Verses.this,"Clicked settings",Toast.LENGTH_SHORT).show();
    }
    public void ClickDayNight(View view){

        closeDrawer(drawerLayout);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.seekbar_container,new SeekbarFragment(),"brightness").commit();

    }
    public void ClickShareApp(View view){

        Toast.makeText(Verses.this,"Clicked shareApp",Toast.LENGTH_SHORT).show();
    }
    public void ClickFeedback(View view){

        Toast.makeText(Verses.this,"Clicked feedback",Toast.LENGTH_SHORT).show();
    }




    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void display_verses(){
        ChaptersService chaptersService=new ChaptersService(Verses.this);
        chaptersService.chapter_verses(book_name,chapter_number, new ChaptersService.GetVersesListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(Verses.this,message,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(ArrayList<VerseModel>the_verses) {
                recyclerView = findViewById(R.id.verse_recycler);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
                recyclerView.setLayoutManager(gridLayoutManager);
                VersesAdapter versesAdapter=new VersesAdapter(Verses.this,the_verses);
                recyclerView.setAdapter(versesAdapter);

            }
        });
    }

    public void ClickDayNight2(){
        if(is_dark_mode_on){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            editor2.putBoolean("isDarkModeOn",false);
            editor2.apply();

        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            editor2.putBoolean("isDarkModeOn",true);
            editor2.apply();
        }
    }
    public void darkLightTheme(){
        sharedPreferences=getSharedPreferences("darkMode",0);
        editor2=sharedPreferences.edit();
        is_dark_mode_on=sharedPreferences.getBoolean("isDarkModeOn",false);

        if(is_dark_mode_on){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
