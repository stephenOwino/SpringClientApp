package com.stephenowino.Retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;

    public RetrofitService(){
        InitializeRetrofit();

    }

    private void InitializeRetrofit() {
        retrofit = new Retrofit.Builder()
                //giving address of the server
                //ip address of my wifi(192.168.122)
                .baseUrl("http://102.135.169.116:3000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {

        return retrofit;
    }
}
