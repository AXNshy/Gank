package com.shy.gank.Model;

import java.io.Serializable;

/**
 * Created by axnshy on 16/8/29.
 */
public class BaseData implements Serializable {
    protected boolean error;
    int count;

    @Override
    public String toString() {
        return "BaseData{" +
                "error=" + error +
                ", count=" + count +
                '}';
    }
}
