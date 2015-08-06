package com.fairyzoro.volley_imageloader_demo.app;

import android.app.Application;

/**
 * Created by Administrator on 2015/8/6.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkSingleton.createInstance(getApplicationContext());
    }
}
