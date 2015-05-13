package com.jet2006.LearnApp;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

public class BaseApplication extends Application {

    private static ArrayList<BaseActivity> activitys = new ArrayList<BaseActivity>();

    @Override
    public void onCreate() {
        super.onCreate();
        //this.setTheme(R.style.AppTheme);
    }


    /**
     * 添加Activity到ArrayList<Activity>管理集合
     * @param activity
     */
    public void addActivity(BaseActivity activity) {
        String className = activity.getClass().getName();
        for (Activity at : activitys) {
            if (className.equals(at.getClass().getName())) {
                activitys.remove(at);
                break;
            }
        }
        activitys.add(activity);
    }

    /**
     * 退出应用程序的时候，手动调用
     */
    @Override
    public void onTerminate() {
        for (BaseActivity activity : activitys) {
            activity.defaultFinish();
        }
    }


}
