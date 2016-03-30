package com.example.mihirmodi.catmain.interfaces;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


/**
 *
 */
public interface CatappRetrofitService {

    @FormUrlEncoded
    @POST("/users/validate.json")
    void login(@Field("user[email]") String email,@Field("user[password]") String password,@Field("user[hash]") String hash, Callback<JsonObject> jsonObjectCallback);

    @FormUrlEncoded
    @POST("/users.json")
    void signup(@Field("user[name]") String name,@Field("user[email]") String email,@Field("user[password]") String password,@Field("user[platform]") String platform,@Field("user[hash]") String hash, Callback<JsonObject> jsonObjectCallback);
}
