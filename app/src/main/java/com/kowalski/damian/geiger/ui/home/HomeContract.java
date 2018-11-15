package com.kowalski.damian.geiger.ui.home;

import com.kowalski.damian.geiger.model.Curiosity;
import com.kowalski.damian.geiger.model.Result;

public interface HomeContract {

    interface View {
        void onLoadLastMeasurementSuccess(Result result);

        void onLoadLastMeasurementError();

        void onLoadCuriositySuccess(Curiosity curiosity);

        void onLoadCuriosityError();
    }

    interface Presenter {
        void loadLastMeasurement();

        void loadCuriosity();
    }
}
