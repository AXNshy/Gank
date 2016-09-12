package com.shy.gank.Vus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by axnshy on 16/8/28.
 */
public interface Vu {
    void init(LayoutInflater inflater, ViewGroup container);
    View getView();
}
