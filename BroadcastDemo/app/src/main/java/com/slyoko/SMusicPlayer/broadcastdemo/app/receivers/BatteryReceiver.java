package com.slyoko.SMusicPlayer.broadcastdemo.app.receivers;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import com.slyoko.SMusicPlayer.broadcastdemo.app.R;

/**
 * Created by Administrator on 2015/9/11.
 */

/**
 * 电池电量的广播接受者
 */
public class BatteryReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        //    处理电量的状态
        // 1 获取Action，进行判断
        String action = intent.getAction();
        if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
            // 电量
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

            // 电池状态 可选值 BatteryManager.BATTERY_STATUS_XXX
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);

            // 电源情况 可选值 BatteryManager.BATTERY_PLUGGED_XXX
            int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);

            //  ----  发送通知 Notification -----
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context);

            // !!! 通知小图标必须设置
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentTitle("标题-电池情况");
            String str = "未充电";

            switch (status) {
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    str = "未知";
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    str = "充电中";
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    str = "使用中";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    str = "未充电";
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    str = "已充满";
                    break;
            }

            builder.setContentText("内容：电池级别：" + level + " " + str);
            Notification notification = builder.build();
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(333,notification);
        }

    }
}
