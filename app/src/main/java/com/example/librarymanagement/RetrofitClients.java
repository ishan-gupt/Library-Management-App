package com.example.librarymanagement;

import android.content.Context;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class RetrofitClients {

    private static final String BASE_URL="http://192.168.68.1/android/" ;
    private static RetrofitClients retrofitClients;
    private Retrofit instance;

    private RetrofitClients(){
         instance=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClients getInstance()
    {
        //retrofitClients=null;
        if(retrofitClients==null)
        {
            retrofitClients=new RetrofitClients();
            Log.e(TAG, "Only One time getInstance: "+retrofitClients );
            Log.e(TAG, "BASE URL :- "+BASE_URL );
        }
        return retrofitClients;
    }

    public JsonPlaceholderApi getApi()
    {
        return instance.create(JsonPlaceholderApi.class);
    }
}