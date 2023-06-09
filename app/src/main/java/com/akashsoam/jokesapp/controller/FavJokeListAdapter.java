package com.akashsoam.jokesapp.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akashsoam.jokesapp.R;
import com.akashsoam.jokesapp.model.Joke;
import com.akashsoam.jokesapp.view.FavJokeViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FavJokeListAdapter extends RecyclerView.Adapter<FavJokeViewHolder> {
    private List<Joke> mJokeList;
    private Context mContext;

    public FavJokeListAdapter(List<Joke> jokeList, Context context) {
        mJokeList = jokeList;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @NonNull
    @Override
    public FavJokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fav_joke_item, parent, false);
        return new FavJokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavJokeViewHolder holder, int position) {
        String jokeText = mJokeList.get(position).getJokeText();
        holder.getTxtFavJoke().setText(jokeText);


    }


    @Override
    public int getItemCount() {
        return mJokeList.size();
    }
}
