package com.kowalski.damian.geiger.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kowalski.damian.geiger.R;
import com.kowalski.damian.geiger.model.Curiosity;
import com.kowalski.damian.geiger.model.Result;
import com.kowalski.damian.geiger.service.impl.GeigerManager;

public class HomeActivity extends AppCompatActivity implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    private HomeContract.Presenter presenter;
    private SwipeRefreshLayout refreshLayout;
    private TextView dose;
    private TextView unitDose;
    private TextView voltage;
    private TextView unitVoltage;
    private TextView curiosityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initWidgets();
        refreshLayout.setOnRefreshListener(this);
        GeigerManager manager = new GeigerManager();
        presenter = new HomePresenter(manager, this);
        onRefresh();
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
        refreshLayout = findViewById(R.id.home_refresh);
        dose = findViewById(R.id.dose_textview);
        unitDose = findViewById(R.id.dose_unit_textview);
        voltage = findViewById(R.id.voltage_textview);
        unitVoltage = findViewById(R.id.voltage_unit_textview);
        curiosityText = findViewById(R.id.curiosity);
    }
}
