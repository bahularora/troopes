package com.troopes.android.data.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class APIHelper {

    private static APIHelper apiHelper = new APIHelper();
    private String BASE_URL = "https://api.github.com";
    private Retrofit retrofit;
    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    private APIHelper() {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    static APIHelper getApiHelper() {
        return apiHelper;
    }


}
