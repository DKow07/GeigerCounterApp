package com.kowalski.damian.geiger.ui.results;

import com.kowalski.damian.geiger.model.Result;

import java.util.List;

public interface ResultsContract {

    interface View {

        void onLoadAllResultsSuccess(List<Result> results);

        void onLoadAllResultsError();
    }

    interface Presenter {

        void loadAllResults();
    }
}
