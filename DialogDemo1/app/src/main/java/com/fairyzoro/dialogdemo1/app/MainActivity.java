package com.fairyzoro.dialogdemo1.app;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    // 进度对话框
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 创建进度对话框
        progressDialog = new ProgressDialog(this);

        // 设置显示的信息
        progressDialog.setMessage("正在加载中...");

        progressDialog.setTitle("请稍等");

        // 设置是否可以取消
        progressDialog.setCancelable(false);

        // 设置是否点击外部区域，取消
        progressDialog.setCanceledOnTouchOutside(false);

        // 对话框的按钮设置：
        // 参数1: 按钮的类型，参考 DialogInterface 通常使用常量
        //       可选值: ProgressDialog.BUTTON_POSITIVE 确认
        //              ProgressDialog.BUTTON_NEGATIVE 取消
        //              ProgressDialog.BUTTON_NEUTRAL  忽略

        progressDialog.setButton(
                ProgressDialog.BUTTON_NEGATIVE,
                "取消",
                new DialogInterface.OnClickListener() {
                    /**
                     * 哪一个对话框的，那个按钮点击了。
                     * @param dialog
                     * @param which
                     */
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO 取消加载
                        // 对话框取消显示
                        dialog.dismiss();
                    }
                }
        );

        // 水平进度条需要使用 Android 自带的属性来设置
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog.setMax(100);

        progressDialog.setProgress(50);

        progressDialog.setIndeterminate(false);

        // 显示进度对话框
        progressDialog.show();

    }


    /**
     * 当用户点击返回键的时候，执行相应的回调
     */
    @Override
    public void onBackPressed() {
        // Activity 的 onBackPressed() 默认是 finish() 不要调用父类的
        // 显示AlertDialog ，提示是否退出

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        // 设置是否允许取消对话框
        builder.setCancelable(true);
        builder.setMessage("您在多留一会吧，是否退出?");
        builder.setTitle("确认");
        // 设置“确认”按钮的部分
        builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 1. 先关闭对话框
                dialog.dismiss();
                // 2. Activity退出
                finish();
            }
        });

        // 设置“取消“按钮的部分
        builder.setNegativeButton("再看一会", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("无所谓", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // builder 创建对话框


        // builder.create() 只进行对话框的创建，不主动显示
        // show() 会创建对话框并且显示
        builder.show();
    }


    public void btnShowToast(View view) {
        Intent intent = new Intent(this, ToastActivity.class);
        startActivity(intent);
    }
}
