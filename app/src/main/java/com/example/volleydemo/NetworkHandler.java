package com.example.volleydemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkHandler {

    private static NetworkHandler instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    public NetworkHandler(Context context) {
        ctx = context;

    }
           //solve data inconsistency
    public static synchronized NetworkHandler getInstance(Context context){
        if (instance == null){
            instance = new NetworkHandler(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue (){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

        //generic support all data type
    public <T> void adToRequestQueue (Request <T> request){
        getRequestQueue().add( request );


    }

}
