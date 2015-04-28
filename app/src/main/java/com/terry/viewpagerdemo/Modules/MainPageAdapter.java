package com.terry.viewpagerdemo.Modules;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.terry.viewpagerdemo.BaseFragment;

import java.util.List;


public class MainPageAdapter extends FragmentPagerAdapter{
    private List<BaseFragment> fragmentList;

    public MainPageAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
