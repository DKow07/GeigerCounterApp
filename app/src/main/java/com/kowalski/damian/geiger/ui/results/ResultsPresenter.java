package com.kowalski.damian.geiger.ui.results;

import com.kowalski.damian.geiger.model.Result;
import com.kowalski.damian.geiger.service.RequestCallback;
import com.kowalski.damian.geiger.service.impl.GeigerManager;

import java.util.List;

public class ResultsPresenter implements ResultsContract.Presenter {

    private GeigerManager manager;
    private ResultsContract.View view;

    public ResultsPresenter(GeigerManager manager, ResultsContract.View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public void loadAllResults() {
        manager.getResults(new RequestCallback<List<Result>>() {
            @Override
            public void onSuccess(List<Result> data) {
                view.onLoadAllResultsSuccess(data);
            }

            @Override
            public void onError(Throwable throwable) {
                view.onLoadAllResultsError();
            }

            @Override
            public void onCancel() {

            }
        });
    }
}
