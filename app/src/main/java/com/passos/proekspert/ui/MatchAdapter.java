package com.passos.proekspert.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.passos.proekspert.R;
import com.passos.proekspert.service.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchHolderView> {

    private final Context context;
    private final List<Match> matches;

    public MatchAdapter(@NonNull Context context, @NonNull List<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    private Match getMatchByPostion(int position) {
        return matches.get(position);
    }

    @NonNull
    @Override
    public MatchHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.match_item_view, parent, false);
        return new MatchHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchHolderView holder, int position) {
        Match match = getMatchByPostion(position);
        holder.onBind(match);
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }
}
