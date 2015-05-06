package com.terry.viewpagerdemo.Framework.Util;

/**
 * Created by Terry on 2015/5/6.
 */
public class StringHelper {

    public static String getFileName(String pathandname) {

        int start = pathandname.lastIndexOf("/");
        int end = pathandname.lastIndexOf(".");
        if (start != -1 && end != -1) {
            return pathandname.substring(start + 1, end);
        } else {
            return null;
        }

    }
}
