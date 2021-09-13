package com.example.volleydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     TextView textView;
   RecyclerView recyclerView;
   private  List<Users> List;
    // private static final String Url = "https://reqres.in/api/users?page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        List = new ArrayList<>(  );
         recyclerView = findViewById( R.id.bbb );
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        final JSONObject jsonObject = new JSONObject();
        Controller.saveData( this, jsonObject, new ResultListener() {
            @Override
            public void onSuccess(JSONObject response) {
                Log.d( "call", response.toString() );
                try {
                    int page = response.getInt( "page" );
                    Log.d( "object", "" + page );
                    //GsonBuilder gsonBuilder  = new GsonBuilder();
                   // Gson gson = gsonBuilder.create();

                    JSONArray jsonArray = response.getJSONArray( "data" );
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                       // String email = object.getString( "email" );
                        //Log.d( "email", "" + email);
                       // String firstName = object.getString( "first_name" );
                       // Log.d( "firstname", "" + firstName);
                       // String lastName = object.getString( "last_name" );
                       // Log.d( "lastname", "" + lastName);
                       // String id = object.getString( "id" );
                        //Log.d( "id", "" + id);
                       // String avatar = object.getString( "avatar" );
                       // Log.d( "image", "" + avatar);

                       // Users users = new Users();
                      //  users.setEmail(email);
                        //users.setFirstName(firstName);
                       // users.setLastName(lastName);
                      //  users.setImgUrl(avatar);
                      //  users.setId(id);
                       List.add(new Users(object));

                       // textView.setText(object.getString( "email" ));
                        Log.d( "array", "" + jsonArray );
                       // Log.d( "arrayobject", "" + object );

                    }
                    UsersAdapter usersAdapter = new UsersAdapter(List,MainActivity.this);
                    recyclerView.setAdapter(usersAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable t, String response) {

            }
        } );
/*
        StringRequest request = new StringRequest( Request.Method.GET, Url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d( "call",new JSONObject( response ).toString() );
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText( MainActivity.this, "something wrong", Toast.LENGTH_SHORT ).show();
            }
        } );

        RequestQueue queue = Volley.newRequestQueue( this );
        queue.add( request );
 


 */
    }
}
