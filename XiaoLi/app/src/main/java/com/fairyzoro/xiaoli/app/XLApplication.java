package com.fairyzoro.xiaoli.app;

import android.app.Application;
import com.fairyzoro.xiaoli.app.data.UserData;

/**
 * Created by Administrator on 2015/8/17.
 */
public class XLApplication extends Application{

    public UserData userData;

    @Override
    public void onCreate() {
        super.onCreate();
        userData = new UserData();
        userData.loadUserData();
    }
}
