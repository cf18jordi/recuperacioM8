package com.example.recuperaciom8.Api.Interfice;

import com.example.recuperaciom8.Api.Model.ModelApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("/weather?q=Barcelona&appid=835babac7f4d7e37f8f51a1abac4fe63")
    Call<ModelApi> getData(String name);

}
