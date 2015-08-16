package com.fairyzoro.notificationdemo.app;

import android.app.Notification;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/6/24
 * Email: vhly@163.com
 */
public class DownloadTask extends AsyncTask<String, Integer, String> {

    private Context context;

    public DownloadTask(Context context){
        this.context = context;
    }

    /**
     * 在子线程中执行耗时的操作，返回值就是 范型第三个参数的类型
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(String... params) {

        if(params != null){
            Log.d("----",params.toString());   //[Ljava.lang.String;@535afe20

            int len = params.length;
            Log.d("----len",len + "");  // len: 20

            for(int i = 0;i<len;i++){

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 异步任务可以在 doInBackground 方法内部
                // 调用特定的更新进度的方法，通过这个方法进行
                // 下载进度的显示

                this.publishProgress(i + 1, len);

            }
        }
        return null;
    }

    /**
     * 当异步任务进度发生变化(publishProgress方法调用了)
     * 就会自动回调本方法。可以更新UI界面。
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        // TODO 发送带有进度的通知
        // 需要上下文 Context 才可以发送通知

        if(context != null){

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context);

            // 设置通知部分

            builder.setSmallIcon(R.mipmap.ic_launcher);

            builder.setContentTitle("下载中...");

            builder.setContentText("下载中");

            ////////////////////////////////

            int currentProgress = values[0];
            int max = values[1];

            ////////////////////////////////

            builder.setProgress(max, currentProgress, false);

            Notification n = builder.build();


            NotificationManagerCompat manager =
                    NotificationManagerCompat.from(context);

            manager.notify(888, n);

        }
    }
}
