package com.fairyzoro.notificationdemo.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 点击进行通知的显示
     * 多次点击只有一个，不会重复（因为下面的id没有重复）
     * 点击通知不会消失
     * @param view
     */
    public void btnShowNotification(View view) {

        // 1. 创建通知

        // Builder 用来创建通知的
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);


        // 1.1 通知必须要设置小图标属性，否则程序崩溃
        builder.setSmallIcon(R.mipmap.ic_launcher);

        // 1.2 设置标题
        builder.setContentTitle("第一个通知");

        // 1.3 设置内容信息
        builder.setContentText("今天有雨，注意收衣服");

//        builder.setAutoCancel(true);    //   单独写这么一句是没效果的，点击取消通知，看最下面的button消息。

        // 1.4 生成通知，通知类型 Notification
        Notification n = builder.build();

        // 2. 使用NotificationManagerCompat 来进行通知显示
        //    from 方法获取实例
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);


        // 通知的方法分为两种：
        //   1) 采用 id 进行通知的。notify(int id, Notification n)
        //      当 ID 是相同的，不会显示多个通知，只有一个
        //      当 ID 不同时，每次显示增加新的通知。
        //   2) 采用 tag标签，进行通知的 notify(String tag, int id, Notification n)
//        manager.notify((int)System.currentTimeMillis(), n);
        manager.notify(998, n);

    }


    /**
     * 带有声音提醒和数量的通知
     *   -----!!!!!   声音 要 权限 ！！！------
     *
     * @param view
     */
    public void btnShowSoundNotification(View view) {

        // 1. 创建
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);

        // 1.1 小图标 ！！！
        builder.setSmallIcon(R.mipmap.ic_launcher);

        // 1.2 标题
        builder.setContentTitle("有新的短信");

        // 1.3 内容
        builder.setContentText("您有3个新短信");

        // 1.4 设置数量
        builder.setNumber(3);                //!!!!!!!!!!!!!!!!

        // 1.5 设置声音提示 Defaults 属性来设置
        //     通常 NotificationCompat 中定义
        builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);   //  !!!!!!!!!!

        // 1.6 生成 Notification
        Notification n = builder.build();

        // 2. 显示
        NotificationManagerCompat manager =
                NotificationManagerCompat.from(this);

        manager.notify(199, n);


    }


    /**
     * 显示不能够被清除的通知(运行中通知)
     * 应用场景：下载提示、音乐播放
     *
     * @param view
     */
    public void btnShowGoing(View view) {

        // 1. 创建
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);

        // 1.1 小图标 ！！！
        builder.setSmallIcon(R.mipmap.ic_launcher);

        // 1.2 标题
        builder.setContentTitle("下载中");

        // 1.3 内容
        builder.setContentText("正在下载");

        // 1.5 设置声音提示 Defaults 属性来设置
        //     通常 NotificationCompat 中定义
        builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);

        // 设置运行中，当前通知不能够被清除
        builder.setOngoing(true);                 //  !!!!!!!!!!!!!!


        // 1.6 生成 Notification
        Notification n = builder.build();

        // 2. 显示
        NotificationManagerCompat manager =
                NotificationManagerCompat.from(this);

        manager.notify(198, n);

    }


    /**
     * 带有点击查看详情的通知
     *
     * @param view
     */
    public void btnShowDetailNotification(View view) {

        // 1. 创建
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);

        // 1.1 小图标 ！！！
        builder.setSmallIcon(R.mipmap.ic_launcher);

        // 1.2 标题
        builder.setContentTitle("您有新消息");

        // 1.3 内容
        builder.setContentText("校长发了消息");

        // 1.5 设置声音提示 Defaults 属性来设置
        //     通常 NotificationCompat 中定义
        builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);


        //   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        // 设置点击启动Activity的功能，相当于点击查看详情
        // setContentIntent() 设置启动的Intent的内容

        // PendingIntent 用来包裹 标准的 startActivity 中
        // 使用的Intent

        Intent intent = new Intent(this, MainActivity.class);    //重新new了一个自己，如果设置singleTop，总共就一个了

        // 内部包裹了一个 Intent
        // 所有通过 getActivity 获取的PendingIntent                 //   !!!!!!!!!!!!!!!!!!
        // 能够自动的执行startActivity
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        // 设置通知点击的时候，执行的操作，通过PendingIntent来定义
        builder.setContentIntent(pi);

        // 设置通知点击之后自动消失
        builder.setAutoCancel(true);

        //  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        // 1.6 生成 Notification
        Notification n = builder.build();

        // 2. 显示
        NotificationManagerCompat manager =
                NotificationManagerCompat.from(this);

        manager.notify(298, n);
    }

    /**
     * 动态演示下载消息
     * @param view
     */
    public void btnDown(View view) {
        Intent intent = new Intent(this, DownloadActivity.class);
        startActivity(intent);
    }
}
