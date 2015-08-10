package com.aliao.newfeatures.utils;

import android.util.Log;

/**
 * Created by 丽双 on 2015/8/10.
 */
public class L {

    private final static String TAG = "happy";
    private final static boolean DEBUG = true;

    public static void d(String msg){
        d(TAG, msg);
    }

    public static void d(String tag, String msg){
        Log.d(tag, msg);
    }
}
