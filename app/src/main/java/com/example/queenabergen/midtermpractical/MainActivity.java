package com.example.queenabergen.midtermpractical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.queenabergen.midtermpractical.JSONObject.Example;
import com.example.queenabergen.midtermpractical.JSONObject.Record;
import com.example.queenabergen.midtermpractical.JSONObject.VineService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vine.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VineService service = retrofit.create(VineService.class);
        Call<Example> call = service.getVineContent();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success: GOOD JOB CUE " + response.body());
                        Example vinePOJO = response.body();
                        List<Record> listOfPosts = vinePOJO.getData().getRecords();
                        int logStatement = listOfPosts.size();
                        Log.d(TAG, String.valueOf(logStatement));
                        


                    } else {
                        Log.d(TAG, "ERROR: Something Happened" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });


    }
}
