package com.shy.gank.Vus;

/**
 * Created by axnshy on 16/8/28.
 */

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shy.gank.Model.Controls.DropDownPupTextView;
import com.shy.gank.R;

import java.util.ArrayList;
import java.util.List;


public class MainVu implements Vu {

    View view;
    DropDownPupTextView title;
    private Toolbar toolbar;
    private CoordinatorLayout coordinator;
    private TabLayout tabs;
    private CollapsingToolbarLayout collapsingToolbar;
    private ViewPager viewpager;
    private FragmentPagerAdapter fAdapter;
    List<Fragment> mList = new ArrayList<>();
    public static String[] tab={"Android,福利,IOS,前端,趣事"};

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_main, container, false);
    }

    public  void initMain(){
        coordinator = (CoordinatorLayout) view.findViewById(R.id.coordinator);
        toolbar = (Toolbar) coordinator.findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) coordinator.findViewById(R.id.collapsing_toolbar);
        viewpager = (ViewPager) coordinator.findViewById(R.id.viewpager);
        title= (DropDownPupTextView) coordinator.findViewById(R.id.tv_title);
        tabs = (TabLayout) coordinator.findViewById(R.id.tabs);
    }

    public void initViewPager(FragmentManager fm){
        fAdapter=new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return mList.get(position);
            }

            @Override
            public int getCount() {
                return mList.size();
            }
        };
        viewpager.setAdapter(fAdapter);
        tabs.setupWithViewPager(viewpager);

    }

    public void addFragment(Fragment fg,String title){
        tabs.addTab(tabs.newTab().setText(title));
        mList.add(fg);
        fAdapter.notifyDataSetChanged();
    }

    @Override
    public View getView() {
        return view;
    }

}
