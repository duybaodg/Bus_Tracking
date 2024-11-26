package com.example.api_with_header.api;

import com.example.api_with_header.objects.Entity;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {
    Interceptor interceptor = chain -> {
        Request request = chain.request();
        Request.Builder builder =request.newBuilder();
        builder.addHeader("accept","application/json");
        builder.addHeader("Accept","application/x-protobuf");
        builder.addHeader("x-api-key","JOGAohGfLg1ewaGYIKGwr13zVF3mqqgw1fVTsLl2");
        return chain.proceed(builder.build());
    };

    HttpLoggingInterceptor loggingIntercept0r = new HttpLoggingInterceptor()
                                                .setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient.Builder okBuilder = new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingIntercept0r)
            .addInterceptor(interceptor);
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://api.opendata.metlink.org.nz/v1/gtfs-rt/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build())
            .build()
            .create(ApiService.class);
    /*
    @Headers({
            "accept: application/json",
            "Accept: application/x-protobuf",
            "x-api-key: JOGAohGfLg1ewaGYIKGwr13zVF3mqqgw1fVTsLl2"
    })*/
    @GET("vehiclepositions")
    Call<Entity> callApi();
}
