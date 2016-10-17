package com.shy.gank.Presenter.Activity;

import android.content.Context;

import com.shy.gank.Presenter.Activity.I.IMainActivityPresenter;
import com.shy.gank.Presenter.Fragment.Android;
import com.shy.gank.Vus.MainVu;

public class MainActivity extends BasePresenterActivity<IMainActivityPresenter,MainVu> implements IMainActivityPresenter {


    @Override
    protected Class<MainVu> getVuClass() {
        return MainVu.class;
    }

    @Override
    protected void onBindVu() {
        vu.initMain();
        bindViewPager();
    }


    public void bindViewPager(){
        vu.initViewPager(fm);
        vu.addFragment(Android.newInstance(),"Android");
        vu.addFragment(Android.newInstance(),"福利");
        vu.addFragment(Android.newInstance(),"ios");
        vu.addFragment(Android.newInstance(),"前端");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public Context getMApplicationContext() {
        return getApplicationContext();
    }

    @Override
    public Context getMContext() {
        return this;
    }

    @Override
    public boolean hasNet() {
        return false;
    }

    @Override
    public void showToast(String s) {

    }
}
