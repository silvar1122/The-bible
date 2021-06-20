package com.example.projectbibleapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.viewHolder> {
    Context context;
    ArrayList<ChapterModel>chapterSize;

    public ChaptersAdapter(Context context, ArrayList<ChapterModel> chapterSize) {
        this.context = context;
        this.chapterSize = chapterSize;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.bible_book_item,parent,false);

        return new ChaptersAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {
        final ChapterModel chapterModel=chapterSize.get(position);
        holder.button.setText( Integer.toString(chapterModel.getChapter()));



        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),Verses.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("chapter_number",chapterModel.getChapter());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return chapterSize.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        Button button;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.book);
        }
    }
}
