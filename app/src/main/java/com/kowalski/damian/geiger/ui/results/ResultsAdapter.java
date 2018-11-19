package com.kowalski.damian.geiger.ui.results;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kowalski.damian.geiger.R;
import com.kowalski.damian.geiger.model.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder> {

    private final List<Result> dataSet = new ArrayList<>();

    @NonNull
    @Override
    public ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_result, parent, false);
        return new ResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsViewHolder holder, int position) {
        if (getItemCount() > position) {
            final Result result = dataSet.get(position);
            holder.bindData(result);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void updateDataSet(List<Result> items) {
        dataSet.clear();
        dataSet.addAll(items);
        notifyDataSetChanged();
    }

    class ResultsViewHolder extends RecyclerView.ViewHolder {

        private TextView dose;
        private TextView doseUnit;
        private TextView voltage;
        private TextView voltageUnit;
        private TextView date;

        public ResultsViewHolder(View itemView) {
            super(itemView);
            dose = itemView.findViewById(R.id.dose_textview_item);
            doseUnit = itemView.findViewById(R.id.dose_unit_textview_item);
            voltage = itemView.findViewById(R.id.voltage_textview_item);
            voltageUnit = itemView.findViewById(R.id.voltage_unit_textview_item);
            date = itemView.findViewById(R.id.date_textview_item);
        }

        public void bindData(Result result) {
            dose.setText(result.getDose().toString());
            doseUnit.setText(result.getUnitDose());
            voltage.setText(result.getVoltage().toString());
            voltageUnit.setText(result.getUnitVoltage());
            date.setText(result.getDateOfMeasurement());
        }
    }
}
