package com.aliao.newfeatures;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by 丽双 on 2015/8/14.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


//        Logger.init("happy");               // default PRETTYLOGGER or use just init()
//                .setMethodCount(3)            // default 2
//                .hideThreadInfo()             // default shown
//                .setLogLevel(LogLevel.NONE);  // default LogLevel.FULL
//                .setMethodOffset(2)           // default 0
    }
}
