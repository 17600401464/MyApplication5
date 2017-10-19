package com.example.myapplication;

import android.app.Application;

import com.yanzhenjie.nohttp.NoHttp;

/**
 * Created by lenovo on 2017/10/13.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);

    }
}
