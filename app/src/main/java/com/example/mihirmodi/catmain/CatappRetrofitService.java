package com.example.mihirmodi.catmain;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


/**
 * Created by mihir modi on 1/11/2016.
 */
public interface CatappRetrofitService {

    @FormUrlEncoded
    @POST("/users/validate.json")
    void login(@Field("user[email]") String email,@Field("user[password]") String password,@Field("user[hash]") String hash, Callback<JsonObject> jsonObjectCallback);
}
