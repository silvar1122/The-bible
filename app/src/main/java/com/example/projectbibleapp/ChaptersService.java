package com.example.projectbibleapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChaptersService {
    Context context;
    int chapter_size;
    ArrayList<ChapterModel> the_chapter_list=new ArrayList<>();
    ArrayList<VerseModel> the_verses=new ArrayList<>();

    public ChaptersService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(ArrayList<ChapterModel> chapterSize);
    }

    public void book_chapters(String book, final VolleyResponseListener volleyResponseListener){
        //RequestQueue requestQueue= Volley.newRequestQueue();

        String url ="https://getbible.net/json?p="+book;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String response2 = response.substring(1, response.length() - 2);


                        try {
                            JSONObject jsonObject=new JSONObject(response2);
                            JSONObject jsonObject11=jsonObject.getJSONObject("book");
                            chapter_size=jsonObject11.length();
                            for(int i=1;i<=chapter_size;i++){
                                the_chapter_list.add(new ChapterModel(i));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        volleyResponseListener.onResponse(the_chapter_list);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"failed to _database",Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError(error.toString());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(stringRequest);

    }
    public interface GetVersesListener{
        void onError(String message);
        void onResponse(ArrayList<VerseModel>the_verses);
//void onResponse(int verse);
    }
    public void chapter_verses(String book, final int chapter_number, final GetVersesListener getVersesListener){
        String url ="https://getbible.net/json?p="+book;
        final Object object1=new Object();
        StringRequest stringRequest8 = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String response2 = response.substring(1, response.length() - 2);
                        String verse="";
                        int verses_number=0;

                        try {
                            JSONObject jsonObject=new JSONObject(response2);
                            JSONObject jsonObject1=jsonObject.getJSONObject("book");
                            JSONObject jsonObject2=jsonObject1.getJSONObject(Integer.toString(chapter_number));
                            JSONObject jsonObject3=jsonObject2.getJSONObject("chapter");
                            verses_number=jsonObject3.length();
//
//
                            for(int i=1;i<=verses_number;i++){
                                JSONObject jsonObject4=jsonObject3.getJSONObject(Integer.toString(i));
//
                                the_verses.add(new VerseModel(jsonObject4.getString("verse"),i));
                            }
//
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        getVersesListener.onResponse(the_verses);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              getVersesListener.onError(error.getMessage());
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(stringRequest8);



    }
}
