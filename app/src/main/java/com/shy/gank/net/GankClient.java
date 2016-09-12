package com.shy.gank.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shy.gank.Utils.API;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by axnshy on 16/8/29.
 */
public class GankClient {
    public static final String HOST = "http://gank.io/api/";
    private static GankRetrofit gankRetrofit;
    protected static final Object monitor = new Object();
    private static Retrofit retrofit;

    private GankClient(){

    }

    static {
        Gson gson = new GsonBuilder()
                 .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                 .create();
         retrofit =  new Retrofit.Builder()
                 .baseUrl(API.GANHUO_SERVER)
                 .addConverterFactory(GsonConverterFactory.create())
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .build();
    }


    public static GankRetrofit getGankRetrofitInstance() {
        synchronized (monitor) {
            if (gankRetrofit == null) {
                gankRetrofit = retrofit.create(GankRetrofit.class);
            }
            return gankRetrofit;
        }
    }
}
