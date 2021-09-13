package com.example.volleydemo;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Users  {


    String id ;

    String email;

    String firstName;

    String LastName;

    String profileImg;


    public Users(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getString("id");
            this.email = jsonObject.getString("email");
            this.firstName = jsonObject.getString("first_name");
            this.LastName = jsonObject.getString("last_name");
            this.profileImg= jsonObject.getString("avatar");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public Users(String id, String email, String firstName, String lastName, String profileImg) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        LastName = lastName;
        this.profileImg = profileImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}
