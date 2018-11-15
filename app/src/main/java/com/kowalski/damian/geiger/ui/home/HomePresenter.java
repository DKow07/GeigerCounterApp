package com.kowalski.damian.geiger.ui.home;

import android.util.Log;

import com.kowalski.damian.geiger.model.Curiosity;
import com.kowalski.damian.geiger.model.Result;
import com.kowalski.damian.geiger.service.RequestCallback;
import com.kowalski.damian.geiger.service.impl.GeigerManager;

public class HomePresenter implements HomeContract.Presenter {

    private final GeigerManager geigerManager;
    private final HomeContract.View view;

    public HomePresenter(GeigerManager manager, HomeContract.View view) {
        this.geigerManager = manager;
        this.view = view;
    }

    @Override
    public void loadLastMeasurement() {
        geigerManager.getCurrentResult(new RequestCallback<Result>() {
            @Override
            public void onSuccess(Result data) {
                view.onLoadLastMeasurementSuccess(data);
            }

            @Override
            public void onError(Throwable throwable) {
                view.onLoadLastMeasurementError();
            }

            @Override
            public void onCancel() {
                //not implemented
            }
        });
    }

    @Override
    public void loadCuriosity() {
        geigerManager.getCuriosity(new RequestCallback<Curiosity>() {
            @Override
            public void onSuccess(Curiosity data) {
                Log.e("curiosity", data.getText());
                view.onLoadCuriositySuccess(data);
            }

            @Override
            public void onError(Throwable throwable) {
                view.onLoadCuriosityError();
            }

            @Override
            public void onCancel() {
                //not implemented
            }
        });
    }
}
