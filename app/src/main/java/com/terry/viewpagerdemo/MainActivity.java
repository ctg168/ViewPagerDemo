package com.terry.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.terry.viewpagerdemo.Modules.ContactBook.ContactBookFragment;
import com.terry.viewpagerdemo.Modules.Discover.DiscoverFragment;
import com.terry.viewpagerdemo.Modules.MainPage.MainPageFragment;
import com.terry.viewpagerdemo.Modules.My.MyFragment;
import com.terry.viewpagerdemo.Modules.Offline.OfflineFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<BaseFragment> fragmentList = new ArrayList<BaseFragment>();
        fragmentList.add(new MainPageFragment());
        fragmentList.add(new ContactBookFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(OfflineFragment.newInstance());
        MainFragmentAdapter mainPageAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(mainPageAdapter);

        // to branch test.
    }
}
