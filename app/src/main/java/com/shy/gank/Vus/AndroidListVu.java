package com.shy.gank.Vus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shy.gank.Adapter.GanHuoAdapter;
import com.shy.gank.Model.Bean.GanHuo;
import com.shy.gank.Presenter.Activity.WebViewActivity;
import com.shy.gank.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axnshy on 16/8/28.
 */
public class AndroidListVu implements Vu, GanHuoAdapter.OnClickListener, GanHuoAdapter.OnMenuListener {

    private static final String TAG = "AndroidListVu";
    View view;
    Context context;
    private RecyclerView recycler;
    private GanHuoAdapter gAdapter;
    private List<GanHuo> list = new  ArrayList<>();



    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.recyclerview, container, false);
        context = view.getContext();
        recycler= (RecyclerView) view.findViewById(R.id.recycler);
        gAdapter = new GanHuoAdapter(context,list);
        gAdapter.setOnClickListener(this);
        gAdapter.setMenuListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(gAdapter);
    }

    @Override
    public View getView() {

        return view;
    }

    public void initList(List<GanHuo> datas){
        list.addAll(datas);
        gAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnShortClicked(View view, int position) {
        if(view instanceof ImageView){
            showPopup();
            Log.w(TAG,"show a popupwindow");
        }
        if(view instanceof LinearLayout){
            //
            Log.w(TAG,"open Article Activity");
            Intent intent = new Intent(view.getContext(), WebViewActivity.class);

            Bundle  bundle = new Bundle();
            intent.putExtra("AndroidListVu",bundle);
            bundle.putSerializable("data",list.get(position));
            view.getContext().startActivity(intent);
        }
    }

    @Override
    public void OnLongClicked(View view, int position) {

    }

    private void showPopup() {
    }
}
