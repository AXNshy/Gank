package com.shy.gank.Vus;

import android.view.View;

import com.shy.gank.Presenter.Activity.I.IPresenter;
import com.shy.gank.Vus.I.Vu;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by axnshy on 16/9/23.
 */
public abstract class BaseView<P extends IPresenter> implements Vu{
    Reference<P> mPresenterRef;

    public P getPresenter(){
       return mPresenterRef.get();
    }

    public void attachPresenter(P presenter) {
        mPresenterRef = new WeakReference<P>(presenter);
    }


    public boolean isPresenterAttached() {
        return mPresenterRef != null && mPresenterRef.get() != null;
    }

    public void dettachPresenter() {
        if (mPresenterRef != null) {
            mPresenterRef.clear();
            mPresenterRef = null;
        }
    }

    @Override
    public abstract View getView();
}
