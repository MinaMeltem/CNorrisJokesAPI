package com.example.c4q.chucknorrisjokes.network;

import com.example.c4q.chucknorrisjokes.model.Jokes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by C4Q on 12/25/16.
 */

public interface ChuckNorrisApi {
    @GET("jokes/random")
    Call<Jokes> getRandomJoke();
}

