package com.kowalski.damian.geiger.ui.results;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kowalski.damian.geiger.R;
import com.kowalski.damian.geiger.model.Result;
import com.kowalski.damian.geiger.service.impl.GeigerManager;

import java.util.List;

public class ResultsFragment extends Fragment implements ResultsContract.View, SwipeRefreshLayout.OnRefreshListener {

    private View view;
    private ResultsContract.Presenter presenter;
    private ResultsAdapter adapter;
    private RecyclerView resultsRecyclerView;
    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_results, container, false);
        GeigerManager geigerManager = new GeigerManager();
        presenter = new ResultsPresenter(geigerManager, this);
        adapter = new ResultsAdapter();
        resultsRecyclerView = view.findViewById(R.id.results_recycler);
        refreshLayout = view.findViewById(R.id.results_refresh);
        refreshLayout.setOnRefreshListener(this);
        setupRecyclerView();
        onRefresh();
        return view;
    }

    @Override
    public void onLoadAllResultsSuccess(List<Result> results) {
        refreshLayout.setRefreshing(false);
        adapter.updateDataSet(results);
    }

    @Override
    public void onLoadAllResultsError() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(true);
        presenter.loadAllResults();
    }

    private void setupRecyclerView() {
        if (isAdded() && getContext() != null) {
            resultsRecyclerView.setAdapter(adapter);
            resultsRecyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        }
    }
}
