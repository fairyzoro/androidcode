package com.slyoko.SMusicPlayer.broadcastdemo.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.slyoko.SMusicPlayer.broadcastdemo.app.receivers.BatteryReceiver;


public class MainActivity extends ActionBarActivity {
    // 电池电量的广播接收者
    private BatteryReceiver batteryReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使用动态注册的方式，进行电池电量的监测
        // Context.registerReceiver

        batteryReceiver = new BatteryReceiver();

        // 准备参数2，电量变化ACTION已经内置在 Intent 类的常量
        IntentFilter intentFilter =
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        // 参数1: BroadcastReceiver 的实例 new 就可以
        // 参数2: IntentFilter 描述匹配的ACTION

        Context context = getApplicationContext();
        context.registerReceiver(batteryReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        /*
        由于动态绑定，无论是否在Destroy中取消绑定，程序结束，绑定都会自动结束
        至于是否有内存泄漏，这个没测过
         */
        // 在 super.onDestroy 之前进行取消注册
//        Context context = getApplicationContext();
//        context.unregisterReceiver(batteryReceiver);

        super.onDestroy();
    }


    public void btnSendNormal(View view) {

        // TODO 发送无序广播

        // 利用上下文发送

        // 广播必须发送ACTION，接收者都是通过ACTION来收取广播的
        // 可以自定义广播的ACTION，只要有接收者就可以了。
        Intent intent = new Intent("com.suiyi.aaa.WUXU_GUANGBO");
        // 发送无序广播
        sendBroadcast(intent);
    }


    /**
     * 发送有序广播
     * @param view
     */
    public void btnSendOrdered(View view) {

        // 通过上下文发送

        Intent intent = new Intent("com.tencent.qq.FLASEINFO_CHANGED");
        intent.putExtra("sign", "学Androi");

        // 参数1: 广播的数据内容 Intent
        // 参数2: 当前广播需要接收者有什么权限
        //    权限是开发人员自己定义的，相当于一个密码
        //    这个密码（权限），在其他应用程序中必须要声明，否则无法
        //    接收这个广播, 如果指定 null 那么不需要权限
        sendOrderedBroadcast(intent, null);

    }

}
