package com.slyoko.SMusicPlayer.broadcastdemo.app.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

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
 * 一种通过 ConnectivityManager来获取，推荐是使用第二种
 */
public class NetworkReceiver extends BroadcastReceiver {

    /**
     * 当接收到广播消息的时候，会自动回调这个方法
     * 这个方法最多可以执行的时间 10秒(Android官方说明)
     *
     * @param context Context 用来启动Service或者发通知
     * @param intent  代表广播的数据信息
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        // 标准的 BroadcastReceiver 代码实现格式

        String action = intent.getAction();

        // 判断 action 属于哪一个类型

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
            // 方式1: 使用Intent 获取广播消息数据的方式

            Log.d("Network", "网络广播 Intent: " + intent.getExtras());

            // 网络的 extra key 定义在 ConnectivityManager中
            // 获取Android可序列化的对象 NetworkInfo ，用来描述当前的网络状态
            NetworkInfo info =
                    intent.getParcelableExtra(
                            ConnectivityManager.EXTRA_NETWORK_INFO
                    );
            // 获取网络状态
            NetworkInfo.State state = info.getState();

            // 断开连接的原因。
            info.getReason();
        }
    }
}
