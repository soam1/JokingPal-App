package com.akashsoam.jokesapp.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;

import com.akashsoam.jokesapp.R;
import com.akashsoam.jokesapp.model.Joke;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class CardsDataAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private boolean clicked = false;

    private JokeLikeListener mJokeLikeListener;

    private Joke mJoke;

    private SharedPreferences mSharedPreferences;

    public CardsDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        mContext = context;
        mJokeLikeListener = (JokeLikeListener) context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }


    @Override
    public View getView(int position, final View contentView, ViewGroup parent) {
        //supply the layout for your card
        TextView v = (contentView.findViewById(R.id.content));
        v.setText(getItem(position));

        ImageButton likeButton = contentView.findViewById(R.id.likeButton);

        if (mSharedPreferences.contains(getItem(position))) {
            likeButton.setImageResource(R.drawable.like_filled);

            clicked = true;

        } else {
            clicked = false;
        }
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = !clicked;
                if (clicked) {
                    likeButton.setImageResource(R.drawable.like_filled);
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(1)
                            .playOn(likeButton);
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
                Intent intent = new Intent(Intent.ACTION_SEND);
                String shareBody = ((TextView) v).getText().toString();
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Yo Mama joke");
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                v.getContext().startActivity(Intent.createChooser(intent, "Share via"));

            }
        });
        return contentView;
    }

}
