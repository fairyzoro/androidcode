package com.slyoko.SMusicPlayer.broadcastdemo.app.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA
 * User: slyoko
 * Data: 2015/9/11.
 * Email:512067072@qq.com
 */


/**
 * 用于监测手机网络变化的广播接收者
 * <p/>
 * 网络广播接受有两种方式，一种通过intent获取
 * <p/>
 * 一种通过 ConnectivityManager来获取，推荐使用第二种
 */
public class NetworkReceiver1 extends BroadcastReceiver {

    /**
     * 当接收到广播消息的时候，会自动回调这个方法
     * 这个方法最多可以执行的时间 10秒(Android官方说明)
     *
     * @param context Context 用来启动Service或者发通知
     * @param intent  代表广播的数据信息
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        // 第二种方式
        // 如果是网络变化，进行处理
        // getSystemService 返回的都是  XxxxManager
        // 参数 都是 XXXXX_SERVICE
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(
                        Context.CONNECTIVITY_SERVICE);

        // 获取当前网络信息
        // 获取活动的网络信息
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null) {

            String typeName = info.getTypeName();

            String subtypeName = info.getSubtypeName();   //小米这个获取值为空

            Toast.makeText(context, "当前连接 " + typeName + "/" + subtypeName, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "无连接", Toast.LENGTH_SHORT).show();
        }
    }
}
