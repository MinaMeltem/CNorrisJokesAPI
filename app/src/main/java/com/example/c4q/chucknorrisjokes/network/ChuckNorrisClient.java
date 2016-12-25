package com.example.c4q.chucknorrisjokes.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by C4Q on 12/25/16.
 */

public class ChuckNorrisClient {


    public static final String BASE_URL = "https://api.chucknorris.io/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder = new Retrofit.Builder()
                                                  .baseUrl(BASE_URL)
                                                  .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }
}
