package com.fairyzoro.notificationdemo.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class DownloadActivity extends ActionBarActivity {

    // 当前的进度，每次点击按钮，增加 10%
    private int currentProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

    }


    /**
     * 自动更新进度条
     * @param view
     */
    public void btnStartDown(View view) {
        // TODO 创建下载的异步任务

        DownloadTask task = new DownloadTask(this);

        String[] urls = new String[20];

        // TODO 设置下载的网址

        task.execute(urls);
    }


    /**
     * 每点击一次按钮增加一点进度条
     * @param view
     */
    public void btnShowDown(View view) {
        // 1. 创建
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);

        // 1.1 小图标
        builder.setSmallIcon(R.mipmap.ic_launcher);

        // 1.2 标题
        builder.setContentTitle("下载中...");

        // 1.3 内容文本
        builder.setContentText("下载中");

        // 1.4 设置进度
        //     第三个参数  false 才能够正常显示进度
        builder.setProgress(100, currentProgress, false);


        Notification n = builder.build();


        // 2. 显示通知

        NotificationManagerCompat manager =
                NotificationManagerCompat.from(this);

        manager.notify(888, n);

        currentProgress += 10;

        if (currentProgress >= 100) {
            currentProgress = 0;
        }
    }
}
