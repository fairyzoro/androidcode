package com.fairyzoro.dialogdemo1.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 15/6/24
 * Email: vhly@163.com
 */
public class ToastActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

    }

    /**
     * 显示图片的 Toast
     * @param view
     */
    public void btnPicToast(View view) {

        // 1. 创建 Toast

        Toast t = new Toast(this);

        // 2. 加载布局（自定义的布局）或者自己创建控件
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.toast_exit, null);

        // 3. Toast 设置视图
        t.setView(v);

        // !!! 一定要设置 位置、时长
        t.setGravity(Gravity.CENTER, 0, 0);
        // 设置时长
        t.setDuration(Toast.LENGTH_SHORT);

        // 4. 显示
        t.show();

    }

    /**
     * 普通Toast，只是加了位置变化，没什么用
     * @param view
     */
    public void btnNToast(View view) {
        Toast t = Toast.makeText(this, "你好", Toast.LENGTH_SHORT);
        // 设置Toast的位置
        // 位置参数第一个，需要使用 Gravity 类中的常量
        // 进行设置
        t.setGravity(Gravity.RIGHT | Gravity.TOP, 0, 50);
        t.show();
    }
}