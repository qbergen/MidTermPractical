package com.example.queenabergen.midtermpractical.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by queenabergen on 12/10/16.
 */

public interface VineService {
    @GET("api/timelines/users/918753190470619136")
    Call<Example> getVineContent();
}
