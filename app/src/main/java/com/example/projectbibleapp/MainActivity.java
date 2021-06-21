package com.example.projectbibleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model_books>books;
    SharedPreferences sharedPref;
    Context context;
    String book_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PopulateOldTestamentBooks();
        init();

    }

    public void init(){
        recyclerView=findViewById(R.id.recyclerview);
        BooksAdapter booksAdapter=new BooksAdapter(getApplicationContext(),books);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(booksAdapter);

    }
    public void PopulateOldTestamentBooks(){
        books=new ArrayList<>();

        books.add(new Model_books("Genesis", Color.BLACK));
        books.add(new Model_books("Exodus",Color.BLACK));
        books.add(new Model_books("Leviticus",Color.BLACK));
        books.add(new Model_books("Numbers",Color.BLACK));
        books.add(new Model_books("Deuteronomy",Color.BLACK));
        books.add(new Model_books("Joshua",Color.BLACK));
        books.add(new Model_books("Judges",Color.BLACK));
        books.add(new Model_books("Ruth",Color.BLACK));
        books.add(new Model_books("1 Samuel",Color.BLACK));
        books.add(new Model_books("2 Samuel",Color.BLACK));
        books.add(new Model_books("1 Kings",Color.BLACK));
        books.add(new Model_books("2 Kings",Color.BLACK));
        books.add(new Model_books("1 Chronicles",Color.BLACK));
        books.add(new Model_books("2 Chronicles",Color.BLACK));
        books.add(new Model_books("Ezra",Color.BLACK));
        books.add(new Model_books("Nehemiah",Color.BLACK));
        books.add(new Model_books("Esther",Color.BLACK));
        books.add(new Model_books("Job",Color.BLACK));
        books.add(new Model_books("Psalms",Color.BLACK));
        books.add(new Model_books("Proverbs",Color.BLACK));
        books.add(new Model_books("Ecclesiastes",Color.BLACK));
        books.add(new Model_books("Song of solomon",Color.BLACK));
        books.add(new Model_books("Isiah",Color.BLACK));
        books.add(new Model_books("Jeremiah",Color.BLACK));
        books.add(new Model_books("Lamentations",Color.BLACK));
        books.add(new Model_books("Ezekiel",Color.BLACK));
        books.add(new Model_books("Daniel",Color.BLACK));
        books.add(new Model_books("Hosea",Color.BLACK));
        books.add(new Model_books("Joel",Color.BLACK));
        books.add(new Model_books("Amos",Color.BLACK));
        books.add(new Model_books("Obadiah",Color.BLACK));
        books.add(new Model_books("Jonah",Color.BLACK));
        books.add(new Model_books("Micah",Color.BLACK));
        books.add(new Model_books("Nahum",Color.BLACK));
        books.add(new Model_books("Habakkuk",Color.BLACK));
        books.add(new Model_books("Zephaniah",Color.BLACK));
        books.add(new Model_books("Haggai",Color.BLACK));
        books.add(new Model_books("Zechariah",Color.BLACK));
        books.add(new Model_books("Malachi",Color.BLACK));
        books.add(new Model_books("Matthew",Color.RED));
        books.add(new Model_books("Mark",Color.RED));
        books.add(new Model_books("Luke",Color.RED));
        books.add(new Model_books("John",Color.RED));
        books.add(new Model_books("Acts",Color.RED));
        books.add(new Model_books("Romans",Color.RED));
        books.add(new Model_books("1 Corinthians",Color.RED));
        books.add(new Model_books("2 Corinthians",Color.RED));
        books.add(new Model_books("Galatians",Color.RED));
        books.add(new Model_books("Ephesians",Color.RED));
        books.add(new Model_books("Philipians",Color.RED));
        books.add(new Model_books("Colossians",Color.RED));
        books.add(new Model_books("1 Thessalonians",Color.RED));
        books.add(new Model_books("2 Thessalonians",Color.RED));
        books.add(new Model_books("1 Timothy",Color.RED));
        books.add(new Model_books("2 Timothy",Color.RED));
        books.add(new Model_books("Titus",Color.RED));
        books.add(new Model_books("Philemon",Color.RED));
        books.add(new Model_books("Hebrews",Color.RED));
        books.add(new Model_books("James",Color.RED));
        books.add(new Model_books("1 Peter",Color.RED));
        books.add(new Model_books("2 Peter",Color.RED));
        books.add(new Model_books("1 John",Color.RED));
        books.add(new Model_books("2 John",Color.RED));
        books.add(new Model_books("3 John",Color.RED));
        books.add(new Model_books("Jude",Color.RED));
        books.add(new Model_books("Revelation",Color.RED));




    }
}