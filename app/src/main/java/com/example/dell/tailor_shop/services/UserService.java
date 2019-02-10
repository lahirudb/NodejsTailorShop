package com.example.dell.tailor_shop.services;

import com.example.dell.tailor_shop.models.Login;
import com.example.dell.tailor_shop.models.User;
import com.example.dell.tailor_shop.models.User_Profile;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserService {

//    @GET("tlrshp/setupuser")
//    Call<User_Profile> userLoggedDetails();

    @POST("/tlrshp/setupuser")
    @Headers({"Content-Type:application/json", "Cache-Control: max-age=640000"})//x-www-form-urlencoded, "Cache-Control: max-age=640000", "Content-Type: application/json"
    Call<User_Profile> userLoginChanges(@Body Login body);//String
}
