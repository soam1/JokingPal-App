package com.akashsoam.jokesapp.model;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JokeManager {
    private Context mContext;
    SharedPreferences mSharedPreferences;

    public JokeManager(Context context) {
        this.mContext = context;
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void saveJoke(Joke joke) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(joke.getJokeText(), joke.isJokeLiked());
        editor.apply();
    }

    public void deleteJoke(Joke joke) {
        if (mSharedPreferences.contains(joke.getJokeText())) {
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.remove(joke.getJokeText()).apply();
        }
    }

    public List<Joke> retreiveJokes() {
        Map<String, ?> data = mSharedPreferences.getAll();
        List<Joke> jokes = new ArrayList<>();
        for (Map.Entry<String, ?> entry :
                data.entrySet()) {
            Joke joke = new Joke(entry.getKey(), (Boolean) entry.getValue());
            if (entry.getKey().matches("variations_seed_native_stored")) continue;
            jokes.add(joke);
        }
        return jokes;
    }
}
