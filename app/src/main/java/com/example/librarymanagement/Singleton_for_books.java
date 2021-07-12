package com.example.librarymanagement;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singleton_for_books {


    private static Singleton_for_books mySingleton;
    private RequestQueue requestQueue;
    private static Context context;

    private static final String TAG = "MySingleton";

    private Singleton_for_books(Context context) {
        this.context = context;
        this.requestQueue=getRequestQueue();
    }

    public  RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        Log.e(TAG, "getRequestQueue : "+requestQueue );

        return requestQueue;
    }

    static synchronized Singleton_for_books getInstance(Context context)
    {
        if(mySingleton==null)
        {
            Log.e(TAG, "getInstance: "+context );
            mySingleton=new Singleton_for_books(context);
        }
        Log.e(TAG, "getInstance: IN :"+mySingleton );
        return mySingleton;
    }

    public  <T> void addRequestQue(Request<T> r)
    {
        requestQueue.add(r);
    }
}
