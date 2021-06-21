package com.example.projectbibleapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.viewHolder> {
    Context context;
    ArrayList<VerseModel>the_verses;
    boolean background_changed=false;

    public VersesAdapter(Context context, ArrayList<VerseModel> the_verses) {
        this.context = context;
        this.the_verses = the_verses;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.verse_display,parent,false);

        return new VersesAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {

        final VerseModel verseModel=the_verses.get(position);
        holder.text_verse.setText( verseModel.getVerse());
        holder.verse_number.setText(Integer.toString(verseModel.getVerse_number()));

        holder.the_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!background_changed){
                    v.setBackgroundResource(R.drawable.verse_background_onclick);
                   // v.findViewById(R.id.the_verse_layout).setBackgroundResource(R.drawable.verse_background_onclick);
                    //Toast.makeText(context,Boolean.toString(background_changed),Toast.LENGTH_SHORT).show();
                  //  holder.the_layout.setBackgroundResource(R.drawable.verse_background_onclick);
                    background_changed=true;
                }
                else {
                   // v.findViewById(R.id.the_verse_layout).setBackgroundResource(R.drawable.verse_background_normal);

                    v.setBackgroundResource(R.drawable.verse_background_normal);
                    // Toast.makeText(context,Boolean.toString(background_changed),Toast.LENGTH_SHORT).show();
                  //holder.the_layout.setBackgroundResource(R.drawable.verse_background_normal);
                    background_changed=false;
                }



            }
        });

    }

    @Override
    public int getItemCount() {
        return the_verses.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView text_verse,verse_number;
        LinearLayout the_layout;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            text_verse=itemView.findViewById(R.id.text_verse);
            verse_number=itemView.findViewById(R.id.verse_number);
            the_layout=itemView.findViewById(R.id.the_verse_layout);
        }
    }
}
