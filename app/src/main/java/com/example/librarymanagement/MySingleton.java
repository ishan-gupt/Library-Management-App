package com.example.librarymanagement;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class MySingleton  {

     private static MySingleton mySingleton;
     private RequestQueue requestQueue;
     private static Context context;

     private static final String TAG = "MySingleton";

     private MySingleton(Context context) {
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

    static synchronized MySingleton getInstance(Context context)
     {
          if(mySingleton==null)
          {
               Log.e(TAG, "getInstance: "+context );
               mySingleton=new MySingleton(context);
          }
         Log.e(TAG, "getInstance: IN :"+mySingleton );
          return mySingleton;
     }

     public  <T> void addRequestQue(Request<T> r)
     {
          requestQueue.add(r);
     }
}
