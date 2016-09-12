package com.shy.gank.Model;


import com.shy.gank.Model.Bean.GanHuo;

import java.util.List;

/**
 * Created by axnshy on 16/8/29.
 */
public class GanHuoData extends BaseData{
    private List<String> category;
    private List<GanHuo> results;

    @Override
    public String toString() {
        return "GanHuoData{" +
                "category=" + category +
                ", results=" + results +
                '}';
    }

    public List<GanHuo> getResults() {
        return results;
    }
}
