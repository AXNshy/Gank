package com.shy.gank.Presenter.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.view.WindowManager;

import com.shy.gank.Presenter.Activity.I.IPresenter;
import com.shy.gank.Vus.BaseView;

public abstract class BasePresenterActivity<P extends IPresenter,V extends BaseView<P>> extends MvpBaseActivityPresenter<P,V> implements IPresenter{


    protected FragmentManager fm;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        // Translucent status bar
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        fm = getSupportFragmentManager();
        try {
            vu = getVuClass().newInstance();
            vu.init(getLayoutInflater(), null);
            vu.attachPresenter((P) this);
            setContentView(vu.getView());
            onBindVu();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected final void onPause() {
        beforePause();
        super.onPause();
    }

    protected void beforePause(){}

    @Override
    protected final void onResume() {
        super.onResume();
        afterResume();
    }

    protected void afterResume(){}

    @Override
    protected final void onDestroy() {
        onDestroyVu();
        vu = null;
        super.onDestroy();
    }


    protected void onDestroyVu() {}

}