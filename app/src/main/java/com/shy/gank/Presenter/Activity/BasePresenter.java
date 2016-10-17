package com.shy.gank.Presenter.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.shy.gank.Presenter.Activity.I.IPresenter;
import com.shy.gank.Vus.BaseView;

/**
 * Created by axnshy on 16/9/23.
 */
public abstract class BasePresenter<P extends IPresenter,V extends BaseView<P>> extends MvpBaseActivityPresenter<P,V> implements IPresenter{

    protected V view;
    protected LayoutInflater mInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mInflater=LayoutInflater.from(this);
            view = getVClass().newInstance();
            view.init(mInflater,null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected V getView(){
        return view;
    }

    protected abstract Class<V> getVClass();

}
