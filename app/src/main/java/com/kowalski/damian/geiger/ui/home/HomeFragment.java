package com.kowalski.damian.geiger.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kowalski.damian.geiger.R;
import com.kowalski.damian.geiger.model.Curiosity;
import com.kowalski.damian.geiger.model.Result;
import com.kowalski.damian.geiger.service.impl.GeigerManager;

public class HomeFragment extends Fragment implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    private HomeContract.Presenter presenter;
    private SwipeRefreshLayout refreshLayout;
    private TextView dose;
    private TextView unitDose;
    private TextView voltage;
    private TextView unitVoltage;
    private TextView curiosityText;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        initWidgets();
        refreshLayout.setOnRefreshListener(this);
        GeigerManager manager = new GeigerManager();
        presenter = new HomePresenter(manager, this);
        onRefresh();
        return view;
    }

    @Override
    public void onLoadLastMeasurementSuccess(Result result) {
        dose.setText(result.getDose().toString());
        unitDose.setText(result.getUnitDose());
        voltage.setText(result.getVoltage().toString());
        unitVoltage.setText(result.getUnitVoltage());
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadLastMeasurementError() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadCuriositySuccess(Curiosity curiosity) {
        curiosityText.setText(curiosity.getText());
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadCuriosityError() {

    }

    @Override
    public void onRefresh() {
        presenter.loadLastMeasurement();
        presenter.loadCuriosity();
        refreshLayout.setRefreshing(true);
    }

    private void initWidgets() {
        if (view != null) {
            refreshLayout = view.findViewById(R.id.home_refresh);
            dose = view.findViewById(R.id.dose_textview);
            unitDose = view.findViewById(R.id.dose_unit_textview);
            voltage = view.findViewById(R.id.voltage_textview);
            unitVoltage = view.findViewById(R.id.voltage_unit_textview);
            curiosityText = view.findViewById(R.id.curiosity);
        }
    }
}
