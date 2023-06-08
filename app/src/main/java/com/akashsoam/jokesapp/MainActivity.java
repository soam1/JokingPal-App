package com.akashsoam.jokesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.akashsoam.jokesapp.controller.CardsDataAdapter;
import com.akashsoam.jokesapp.model.Joke;
import com.wenchao.cardstack.CardStack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardStack.CardEventListener {

    private CardStack mCardStack;
    private CardsDataAdapter mCardAdapter;
    private List<Joke> allJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allJokes = new ArrayList<>();

        Log.i("JOKES", loadJSONFromAsset());


        mCardStack = (CardStack) findViewById(R.id.container);

        mCardStack.setContentResource(R.layout.joke_card);
        mCardStack.setStackMargin(20);

        mCardAdapter = new CardsDataAdapter(getApplicationContext(), 0);
//        mCardAdapter.add("test1");
//        mCardAdapter.add("test2");
//        mCardAdapter.add("test3");
//        mCardAdapter.add("test4");
//        mCardAdapter.add("test5");


        try {

            JSONObject rootObject = new JSONObject(loadJSONFromAsset());//complete it is json object , then it has several json arrays
            JSONArray fatJokes = rootObject.getJSONArray("fat");
            addJokesToArrayList(fatJokes, allJokes);
            JSONArray stupidJokes = rootObject.getJSONArray("stupid");
            addJokesToArrayList(stupidJokes, allJokes);
            JSONArray uglyJokes = rootObject.getJSONArray("ugly");
            addJokesToArrayList(uglyJokes, allJokes);
            JSONArray nastyJokes = rootObject.getJSONArray("nasty");
            addJokesToArrayList(nastyJokes, allJokes);
            JSONArray odorJokes = rootObject.getJSONArray("odor");
            addJokesToArrayList(odorJokes, allJokes);
            JSONArray hairyJokes = rootObject.getJSONArray("hairy");
            addJokesToArrayList(hairyJokes, allJokes);
            JSONArray baldJokes = rootObject.getJSONArray("bald");
            addJokesToArrayList(baldJokes, allJokes);
            JSONArray oldJokes = rootObject.getJSONArray("old");
            addJokesToArrayList(oldJokes, allJokes);
            JSONArray poorJokes = rootObject.getJSONArray("poor");
            addJokesToArrayList(poorJokes, allJokes);
            JSONArray shortJokes = rootObject.getJSONArray("short");
            addJokesToArrayList(shortJokes, allJokes);
            JSONArray skinnyJokes = rootObject.getJSONArray("skinny");
            addJokesToArrayList(skinnyJokes, allJokes);
            JSONArray tallJokes = rootObject.getJSONArray("tall");
            addJokesToArrayList(tallJokes, allJokes);
            JSONArray gotJokes = rootObject.getJSONArray("got");
            addJokesToArrayList(gotJokes, allJokes);
            JSONArray likeJokes = rootObject.getJSONArray("like");
            addJokesToArrayList(likeJokes, allJokes);
            JSONArray miscJokes = rootObject.getJSONArray("misc");
            addJokesToArrayList(miscJokes, allJokes);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (Joke joke :
                allJokes) {
            mCardAdapter.add(joke.getJokeText());

        }
        mCardStack.setAdapter(mCardAdapter);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("jokes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void addJokesToArrayList(JSONArray jsonArray, List<Joke> arrayList) {
        try {
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(new Joke(jsonArray.getString(i), false));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean swipeEnd(int section, float distance) {
        return  distance > 300;

    }

    @Override
    public boolean swipeStart(int section, float distance) {
        return true;
    }

    @Override
    public boolean swipeContinue(int section, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void discarded(int mIndex, int direction) {

    }

    @Override
    public void topCardTapped() {

    }
}