package com.example.projectbibleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        View view=inflater.inflate(R.layout.bible_book_item,parent,false);

        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Model_books model_books=books.get(position);
        holder.books.setText(model_books.getBooks());

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
