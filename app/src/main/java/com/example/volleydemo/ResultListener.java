package com.example.volleydemo;

import org.json.JSONObject;

public interface ResultListener {
    void onSuccess (JSONObject response);
    void onError(Throwable t,String response);
}
