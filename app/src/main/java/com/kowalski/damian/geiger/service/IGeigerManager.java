package com.kowalski.damian.geiger.service;

import com.kowalski.damian.geiger.model.Curiosity;
import com.kowalski.damian.geiger.model.Request.AddResultRequest;
import com.kowalski.damian.geiger.model.Result;

import java.util.List;

public interface IGeigerManager {

    void getResults(RequestCallback<List<Result>> callback);

    void getCurrentResult(RequestCallback<Result> callback);

    void addResult(AddResultRequest request, RequestCallback<Void> callback);

    void getCuriosity(RequestCallback<Curiosity> callback);
}
