package com.terry.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.terry.viewpagerdemo.Modules.ContactBook.ContactBookFragment;
import com.terry.viewpagerdemo.Modules.Discover.DiscoverFragment;
import com.terry.viewpagerdemo.Modules.MainPage.MainPageFragment;
import com.terry.viewpagerdemo.Modules.My.MyFragment;

import java.util.ArrayList;

//terry edit on server web page. 20150505
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //yes.
        //ok.


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<BaseFragment> fragmentList = new ArrayList<BaseFragment>();
        fragmentList.add(new MainPageFragment());
        fragmentList.add(new ContactBookFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new MyFragment());
        MainFragmentAdapter mainPageAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragmentList);

//sure, it's a bug. change on server.
        viewPager.setAdapter(mainPageAdapter);
    }

//more code in here.
//这里有一个改动



    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
