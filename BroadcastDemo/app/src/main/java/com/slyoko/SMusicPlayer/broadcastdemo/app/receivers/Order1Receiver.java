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
public class Order1Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("---Order", "Order1");
    }
}
