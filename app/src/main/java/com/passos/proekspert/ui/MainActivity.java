package com.passos.proekspert.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.passos.proekspert.R;
import com.passos.proekspert.di.AppContext;
import com.passos.proekspert.service.model.Match;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements Contract.View {

    @Inject
    protected Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        AppContext.getComponent().inject(this);
        presenter.setView(this);
        presenter.load();
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (presenter.isPrediction()) {
            getMenuInflater().inflate(R.menu.menu_predictions, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_results, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.action_predictions == item.getItemId()) {
            presenter.load(true);
        } else if (R.id.action_results == item.getItemId()) {
            presenter.load(false);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoad(List<Match> matches) {
        RecyclerView recyclerView = findViewById(R.id.recycler_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(new MatchAdapter(getBaseContext(), matches));
    }

    @Override
    public void onCallStart() {

    }

    @Override
    public void onCallComplete() {

    }

    @Override
    public void onCallError(String message) {

    }
}
