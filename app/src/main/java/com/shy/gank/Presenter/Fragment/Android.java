package com.shy.gank.Presenter.Fragment;

import android.util.Log;

import com.shy.gank.Model.Bean.GanHuo;
import com.shy.gank.Model.GanHuoData;
import com.shy.gank.Vus.AndroidListVu;
import com.shy.gank.net.GankClient;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by axnshy on 16/8/28.
 */
public class Android extends BasePresenterFragment<AndroidListVu> {

    private static final String TAG = "Android";
    private List<GanHuo> mList;

    @Override
    protected Class<AndroidListVu> getVuClass() {
        return AndroidListVu.class;
    }


    @Override
    protected void onBindVu() {
        super.onBindVu();
        GankClient.getGankRetrofitInstance()
                .getByType("Android", 10, 1)
                .map(new Func1<GanHuoData, List<GanHuo>>() {
                    @Override
                    public List<GanHuo> call(GanHuoData ganHuoData) {
                        return ganHuoData.getResults();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<GanHuo>>() {
                    @Override
                    public void call(List<GanHuo> datas) {
                        for (GanHuo gh : datas) {
                            Log.w(TAG, "GanHuo desc in UI thread:" + gh.toString());
                        }
                        vu.initList(datas);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.w(TAG,"Throwable :  " + throwable.toString());
                    }
                });
    }

    public static Android newInstance() {
        return new Android();
    }
}
