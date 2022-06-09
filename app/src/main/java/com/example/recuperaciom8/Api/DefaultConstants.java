package com.example.recuperaciom8.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefaultConstants {

    public static final String API_KEY = "835babac7f4d7e37f8f51a1abac4fe63";
    public static final String SESSION_ID = "";

    public static final String BASE_IMG_URL = "https://openweathermap.org/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
