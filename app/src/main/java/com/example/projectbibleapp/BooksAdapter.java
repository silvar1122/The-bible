package com.example.projectbibleapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.viewHolder> {
    Context context;
    ArrayList<Model_books>books;

    public BooksAdapter(Context context, ArrayList<Model_books> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        final View view=inflater.inflate(R.layout.bible_book_item,parent,false);


        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {
        final Model_books model_books=books.get(position);
        holder.books.setText(model_books.getBooks());
        holder.books.setTextColor(model_books.getColor());


        holder.books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,Chapters.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("the_book",model_books.getBooks());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        Button books;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            books=itemView.findViewById(R.id.book);
        }
    }
}
