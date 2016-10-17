package com.shy.gank.Presenter.Activity.I;

import android.content.Context;

/**
 * Created by axnshy on 16/9/23.
 */
public interface IPresenter {
    void showLoading();
    void hideLoading();

    //拿到ApplicationContext
    abstract Context getMApplicationContext();

    //拿到当前类的Context
    abstract Context getMContext();

    //判断有无网络
    abstract boolean hasNet();

    //显示一个吐司框
    abstract void showToast(String s);

}
