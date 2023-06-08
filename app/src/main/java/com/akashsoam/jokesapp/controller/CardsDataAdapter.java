package com.akashsoam.jokesapp.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.akashsoam.jokesapp.R;
import com.akashsoam.jokesapp.model.Joke;

public class CardsDataAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private boolean clicked = false;

    private JokeLikeListener mJokeLikeListener;

    private Joke mJoke;

    public CardsDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        mContext = context;
        mJokeLikeListener = (JokeLikeListener) context;
    }


    @Override
    public View getView(int position, final View contentView, ViewGroup parent) {
        //supply the layout for your card
        TextView v = (contentView.findViewById(R.id.content));
        v.setText(getItem(position));

        ImageButton likeButton = contentView.findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = !clicked;
                if (clicked) {
                    likeButton.setImageResource(R.drawable.like_filled);
                    Toast.makeText(mContext, "You like it👍", Toast.LENGTH_SHORT).show();
                    mJoke = new Joke(getItem(position), clicked);
                    mJokeLikeListener.jokeIsLiked(mJoke);

                } else {
                    likeButton.setImageResource(R.drawable.like_empty);
                    Toast.makeText(mContext, "You don't like it now😒", Toast.LENGTH_SHORT).show();
                    mJoke = new Joke(getItem(position), clicked);
                    mJokeLikeListener.jokeIsLiked(mJoke);

                }

            }
        });
        ImageButton shareButton = contentView.findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "You shared it✌️", Toast.LENGTH_SHORT).show();
            }
        });
        return contentView;
    }

}
