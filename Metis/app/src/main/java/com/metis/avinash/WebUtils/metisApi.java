package com.metis.avinash.WebUtils;


import com.google.gson.JsonObject;
import com.metis.avinash.Models.GroupModel;
import com.metis.avinash.Models.LoginModel;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;


/** Created by "V Avinash" on 6/1/2016.*/
public interface metisApi {

    @FormUrlEncoded
    @POST("/login/")
    public void loginUser(@FieldMap Map<String, String> params, Callback<LoginModel> Response);

    @GET("/groups/")
    void getGroups(@Header("Authorization") String token, Callback<List<GroupModel>> Response);


    @GET("/posts/")
    void getPosts(@Header("Authorization") String token, Callback<String> Response);


//    @Multipart
//    @POST("/complaint/")
//    public void uploadBill(@Header("Authorization") String auth_token, @Part("image") TypedFile image, @Part("category") String category,
//                           @Part("location") String location, @Part("description") String description, Callback<Dummy> Response);
//
//    @GET("/complaint/")
//    public void getComplaints(@Header("Authorization") String auth_token, Callback<List<HistoryModel>> Response);
//
//    @GET("/management/{category}")
//    public void getCategoryComplaint(@Header("Authorization") String auth_token, @Path("category") String category, Callback<List<HistoryModel>> Response);
//
//    @POST("/management/assign/")
//    public  void assignTask(@Header("Authorization") String auth_token, @Body AssignModel assignModel, Callback<List<AssignModel>> Response);
//
//    @GET("/complaint/category/")
//    public void getCategory(@Header("Authorization") String auth_token, Callback<List<CategoryModel>> Response);
//
//    @GET("/management/worker/")
//    public void getWorker(@Header("Authorization") String auth_token, Callback<List<WorkerModel>> Response);
}


