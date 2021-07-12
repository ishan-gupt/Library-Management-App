package com.example.librarymanagement;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class News extends Fragment {

    private RecyclerView recyclerView;
    StringRequest stringRequest;
    String url="http://192.168.68.1/android/login.php";
    String urlimage="http://192.168.68.1/android/";

    private RecyclerView.Adapter adapter;
    private static final String TAG = "News";
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news,container,false);
        this.v=view;
        Reload();
        recyclerView=(RecyclerView)v.findViewById(R.id.recycle1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void Reload() {

        stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            JSONObject jsonObject= jsonArray.getJSONObject(0);

                            String news_name=jsonObject.getString("news_name");

                            JSONArray news_jsonArray=new JSONArray(news_name);

                            String arr[] = new String[news_jsonArray.length()];
                            String arr1[] = new String[news_jsonArray.length()];
                            String img[]=new String[news_jsonArray.length()];

                            for(int i=0; i<news_jsonArray.length();i++){
                                JSONObject news_jsonObject= news_jsonArray.getJSONObject(i);
                                arr[i] = news_jsonObject.getString("description");
                                arr1[i] = news_jsonObject.getString("title");
                                img[i]=urlimage.concat(news_jsonObject.getString("img"));
                                Log.e(TAG, "onResponse: "+img[i] );
                            }

                            adapter=new NewsAdapter(arr1,arr,img,getContext());

                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ERROR"+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> stringStringMap=new HashMap<String,String>();
                stringStringMap.put("enroll",Shareprefences.getInstance(getContext()).getEnroll());
                stringStringMap.put("pass",Shareprefences.getInstance(getContext()).getPass());
                return stringStringMap;
            }
        };

        MySingleton.getInstance(getContext()).addRequestQue(stringRequest);

    }

}