package com.example.c4q.chucknorrisjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c4q.chucknorrisjokes.model.Jokes;
import com.example.c4q.chucknorrisjokes.network.ChuckNorrisApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokesResponseActivity extends AppCompatActivity {
    private static final String TAG = "ChuckNorrisActivity";
    private Button jokeGeneratorBTN;
    private TextView jokeDisplayerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_response);

        jokeGeneratorBTN = (Button) findViewById(R.id.joke_btn);
        jokeDisplayerTV = (TextView) findViewById(R.id.joke_tv);

        jokeGeneratorBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadJoke();

            }
        });
    }

    public void loadJoke() {


        Call<Jokes> jokeCall = ChuckNorrisApi.getRandomJoke();

        jokeCall.enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes> call, Response<Jokes> response) {

                try {
                    // Get the response body, which will be your object class
                    if (response.isSuccessful()) {
                        Jokes jokes = response.body();
                        // Do something with the object (display the stuff etc...)
                        jokeDisplayerTV.setText(jokes.getValue());

                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }


                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
            @Override
            public void onFailure(Call<Jokes> call, Throwable t) {
                Log.d("Error", t.getMessage());
                // Show a failure message to the user.
                Toast.makeText(JokesResponseActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
