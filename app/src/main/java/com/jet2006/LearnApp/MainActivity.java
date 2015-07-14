package com.jet2006.LearnApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jet2006.LearnApp.Modules.ContactBook.ContactBookFragment;
import com.jet2006.LearnApp.Modules.Discover.DiscoverFragment;
import com.jet2006.LearnApp.Modules.Lesson.LessonFragment;
import com.jet2006.LearnApp.Modules.MainPage.MainPageFragment;
import com.jet2006.LearnApp.Modules.My.MyFragment;
import com.jet2006.LearnApp.Modules.Offline.OfflineFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupViews() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<BaseFragment> fragmentList = new ArrayList<BaseFragment>();

        fragmentList.add(new MainPageFragment());
        fragmentList.add(new ContactBookFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(OfflineFragment.newInstance());
        fragmentList.add(new LessonFragment());

        MainFragmentAdapter mainPageAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(mainPageAdapter);

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                //半透明效果
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setAlpha(normalizedposition);


                //缩放效果
//                final float normalizedposition = Math.abs(Math.abs(position) - 1);
//                page.setScaleX(normalizedposition / 2 + 0.5f);
//                page.setScaleY(normalizedposition / 2 + 0.5f);


                //窗户效果
//                page.setRotationY(position * -30);

            }
        });
    }

    @Override
    protected void initialized() {

    }
}
