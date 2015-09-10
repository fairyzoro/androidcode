package com.slyoko.SMusicPlayer.broadcastdemo.app.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created with IntelliJ IDEA
 * User: slyoko
 * Data: 2015/9/11.
 * Email:512067072@qq.com
 */
public class Normal2Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("---Nomral", "Normal2 Received");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("---Nomral", "Normal2 Finished");

    }
}
