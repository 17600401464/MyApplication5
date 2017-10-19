package com.example.myapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by lenovo on 2017/9/25.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
