package com.terry.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.terry.viewpagerdemo.Modules.ContactBookFragment;
import com.terry.viewpagerdemo.Modules.DiscoverFragment;
import com.terry.viewpagerdemo.Modules.MainPageAdapter;
import com.terry.viewpagerdemo.Modules.MainPageFragment;
import com.terry.viewpagerdemo.Modules.MyFragment;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    private ArrayList<BaseFragment> fragmentList;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fragmentList = new ArrayList<BaseFragment>();
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new MainPageFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new ContactBookFragment());
        MainPageAdapter mainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(mainPageAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
