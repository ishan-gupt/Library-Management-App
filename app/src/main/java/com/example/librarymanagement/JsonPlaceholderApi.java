package com.example.librarymanagement;

import org.json.JSONObject;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceholderApi {

    @GET("/posts")
    Call<List<Post>> getPost();

    @FormUrlEncoded
    @POST("Registertion")
    Call<JSONObject> createuser(
            @Field("ssenroll") String email,
            @Field("ssname") String name,
            @Field("sssurname") String surname,
            @Field("sspass") String pass,
            @Field("ssdept") int depart,
            @Field("sssem") int sem,
            @Field("ssmobile") String mobile
    );

}