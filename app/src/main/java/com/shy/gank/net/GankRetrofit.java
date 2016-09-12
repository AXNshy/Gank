package com.shy.gank.net;

import com.shy.gank.Model.GanHuoData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by axnshy on 16/8/29.
 */

public interface GankRetrofit {
    @GET("day/{year}/{mouth}/{day}")
    public Observable<GanHuoData> getToday(@Path("year") int year,@Path("mouth") int mouth,@Path("day") int day);
    @GET("search/query/listview/category/{type}/count/{count}/page/{page} ")
    public Observable<GanHuoData> getByType(@Path("type") String type,@Path("count") int count,@Path("page") int page);
}
