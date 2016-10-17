package com.shy.gank.Presenter.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.shy.gank.Model.Bean.GanHuo;
import com.shy.gank.Presenter.Activity.I.IWebViewActivityPresenter;
import com.shy.gank.Vus.WebViewVu;

/**
 * Created by axnshy on 16/8/30.
 */
public class WebViewActivity extends BasePresenterActivity<IWebViewActivityPresenter,WebViewVu>{
    @Override
    protected Class<WebViewVu> getVuClass() {
        return WebViewVu.class;
    }

    @Override
    protected void onBindVu() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("AndroidListVu");
        GanHuo ganhuo = (GanHuo) bundle.getSerializable("data");
        vu.load(ganhuo);
        vu.setOnClickListener(this);
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
