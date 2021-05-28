package com.example.projectbibleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model_books>books;

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

        books.add(new Model_books("Genesis"));
        books.add(new Model_books("Exodus"));
        books.add(new Model_books("Leviticus"));
        books.add(new Model_books("Numbers"));
        books.add(new Model_books("Deuteronomy"));
        books.add(new Model_books("Joshua"));
        books.add(new Model_books("Judges"));
        books.add(new Model_books("Ruth"));
        books.add(new Model_books("1 Samuel"));
        books.add(new Model_books("2 Samuel"));
        books.add(new Model_books("1 Kings"));
        books.add(new Model_books("2 Kings"));
        books.add(new Model_books("1 Chronicles"));
        books.add(new Model_books("2 Chronicles"));
        books.add(new Model_books("Ezra"));
        books.add(new Model_books("Nehemiah"));
        books.add(new Model_books("Esther"));
        books.add(new Model_books("Job"));
        books.add(new Model_books("Psalms"));
        books.add(new Model_books("Proverbs"));
        books.add(new Model_books("Ecclesiastes"));
        books.add(new Model_books("Song of solomon"));
        books.add(new Model_books("Isiah"));
        books.add(new Model_books("Jeremiah"));
        books.add(new Model_books("Lamentations"));
        books.add(new Model_books("Ezekiel"));
        books.add(new Model_books("Daniel"));
        books.add(new Model_books("Hosea"));
        books.add(new Model_books("Joel"));
        books.add(new Model_books("Amos"));
        books.add(new Model_books("Obadiah"));
        books.add(new Model_books("Jonah"));
        books.add(new Model_books("Micah"));
        books.add(new Model_books("Nahum"));
        books.add(new Model_books("Habakkuk"));
        books.add(new Model_books("Zephaniah"));
        books.add(new Model_books("Haggai"));
        books.add(new Model_books("Zechariah"));
        books.add(new Model_books("Malachi"));


    }
}