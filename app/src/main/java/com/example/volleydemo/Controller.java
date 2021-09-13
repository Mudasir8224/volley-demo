package com.example.volleydemo;

import android.content.Context;
import android.net.sip.SipSession;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class Controller {

    public static void saveData(Context context, JSONObject jsonObject, final ResultListener listener) {
        NetworkHandler.getInstance( context ).adToRequestQueue( RequestBuilder.getInstance( context )
                .getTokenRequest( jsonObject, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        listener.onSuccess( response );

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError( error.fillInStackTrace(), error.getMessage() );

                    }
                } )

        );

    }
}
