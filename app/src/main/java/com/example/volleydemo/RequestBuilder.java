package com.example.volleydemo;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//import static com.example.volleydemo.BasesOfUrl.baseUrl;

public class RequestBuilder extends BasesOfUrl {
    private static RequestBuilder instance;
    private static Context mContext;

    private RequestBuilder(Context context) {
        mContext = context;
    }

    public static RequestBuilder getInstance(Context context) {
        if (instance == null) {
            instance = new RequestBuilder( context );
        }
        return instance;
    }


    public JsonObjectRequest getTokenRequest(JSONObject jsonObject, Response.Listener<JSONObject> jsonObjectListener
            , Response.ErrorListener errorListener) {
        return new JsonObjectRequest( Request.Method.GET, baseUrl, jsonObject, jsonObjectListener, errorListener ) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Accept", "application/json");
                headers.put("Authorization", "Bearer " );
                return headers;
            }

        };
    }
}
