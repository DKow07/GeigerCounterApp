package com.kowalski.damian.geiger.service.api;

import com.kowalski.damian.geiger.model.Curiosity;
import com.kowalski.damian.geiger.model.Request.AddResultRequest;
import com.kowalski.damian.geiger.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IGeigerWSApi {

    @GET("v1/result")
    Call<List<Result>> getResults();

    @GET("v1/result/current")
    Call<Result> getCurrentResult();

    @POST("v1/result")
    Call<Void> addResult(@Body AddResultRequest request);

    @GET("v1/curiosity/one")
    Call<Curiosity> getCuriosity();
}
