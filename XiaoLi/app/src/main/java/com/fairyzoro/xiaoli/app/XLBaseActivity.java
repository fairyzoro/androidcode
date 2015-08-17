package com.fairyzoro.xiaoli.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by Administrator on 2015/8/17.
 */
public class XLBaseActivity extends Activity{

        public  XLApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = (XLApplication) getApplication();  // TODO  待

    }
}
