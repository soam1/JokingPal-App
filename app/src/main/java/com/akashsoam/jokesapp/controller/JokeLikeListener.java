package com.akashsoam.jokesapp.controller;

import com.akashsoam.jokesapp.model.Joke;

public interface JokeLikeListener {
    void jokeIsLiked(Joke joke);
}
