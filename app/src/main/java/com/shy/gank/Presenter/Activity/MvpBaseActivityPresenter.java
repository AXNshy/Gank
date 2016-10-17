package com.shy.gank.Presenter.Activity;

import android.support.v7.app.AppCompatActivity;

import com.shy.gank.Presenter.Activity.I.IPresenter;
import com.shy.gank.Vus.BaseView;

/**
 * Created by axnshy on 2016/10/17.
 */

public abstract class MvpBaseActivityPresenter<P extends IPresenter,V extends BaseView<P>> extends AppCompatActivity {

    protected V vu;

    @Override
    public final void onBackPressed() {
        if(!handleBackPressed()) {
            super.onBackPressed();
        }
    }

    public boolean handleBackPressed(){
        return false;
    }

    protected abstract Class<V> getVuClass();

    protected abstract void onBindVu();

}
