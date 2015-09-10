package com.slyoko.SMusicPlayer.broadcastdemo.app.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * User: slyoko
 * Data: 2015/9/11.
 * Email:512067072@qq.com
 */

/**
 * 短信接收者
 */
public class MessageReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.provider.Telephony.SMS_RECEIVED".equals(action)) {
            // 收到短信
            Bundle extras = intent.getExtras();

            if (extras != null) {
                Set<String> keySet = extras.keySet();
                for (String key : keySet) {
                    Object value = extras.get(key);
                    Log.d("---Message",key + "--" + value);
                }

                // 短信中 pdu 代表 短信的内部的数据结构
                // pdus 代表多个 pdu
                Object[] pdus = (Object[])extras.get("pdus");
                String format = extras.getString("format");
                if (pdus != null) {
                    for (Object pdu : pdus) {
                        Log.d("---Message", "PDU:" + pdu);

                        // TODO 每一个PDU 就是一个字节数组，需要解析
                        // 通过 SmsMessage.createFromPDU() 来创建对象
                        SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);

                        // 发件人号码
                        String address = message.getOriginatingAddress();
                        String body = message.getDisplayMessageBody();

                        Log.d("---Message", address + ": " + body);
                    }
                }
            }
        }
    }
}
