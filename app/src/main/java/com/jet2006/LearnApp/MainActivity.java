package com.jet2006.LearnApp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.jet2006.LearnApp.Modules.ContactBook.ContactBookFragment;
import com.jet2006.LearnApp.Modules.Discover.DiscoverFragment;
import com.jet2006.LearnApp.Modules.MainPage.MainPageFragment;
import com.jet2006.LearnApp.Modules.My.MyFragment;
import com.jet2006.LearnApp.Modules.Offline.OfflineFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

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
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void initialized() {

    }
}
