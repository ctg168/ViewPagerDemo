package com.jet2006.LearnApp;

import android.util.Log;

public class LogUtil {

    private static Log logger;

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }
}
