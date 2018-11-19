package com.kowalski.damian.geiger.service.impl;

import com.kowalski.damian.geiger.model.Curiosity;
import com.kowalski.damian.geiger.model.Request.AddResultRequest;
import com.kowalski.damian.geiger.model.Result;
import com.kowalski.damian.geiger.service.IGeigerManager;
import com.kowalski.damian.geiger.service.RequestCallback;
import com.kowalski.damian.geiger.service.api.IGeigerWSApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeigerManager implements IGeigerManager {

    private RetrofitClient retrofitClient;

    private IGeigerWSApi api;

    public GeigerManager() {
        retrofitClient = new RetrofitClient();
        api = retrofitClient.getRetrofit().create(IGeigerWSApi.class);
    }

    @Override
    public void getResults(final RequestCallback<List<Result>> callback) {
        api.getResults().enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if (response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Throwable());
                }
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void getCurrentResult(final RequestCallback<Result> callback) {
        api.getCurrentResult().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Throwable());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void addResult(AddResultRequest request, RequestCallback<Void> callback) {

    }

    @Override
    public void getCuriosity(final RequestCallback<Curiosity> callback) {
        api.getCuriosity().enqueue(new Callback<Curiosity>() {
            @Override
            public void onResponse(Call<Curiosity> call, Response<Curiosity> response) {
                if (response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Throwable());
                }
            }

            @Override
            public void onFailure(Call<Curiosity> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
