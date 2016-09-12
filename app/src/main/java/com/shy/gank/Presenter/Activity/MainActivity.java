package com.shy.gank.Presenter.Activity;

import com.shy.gank.Presenter.Fragment.Android;
import com.shy.gank.Vus.MainVu;

public class MainActivity extends BasePresenterActivity<MainVu> {


    @Override
    protected Class<MainVu> getVuClass() {
        return MainVu.class;
    }

    @Override
    protected void onBindVu() {
        super.onBindVu();
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

}
