package com.handmark.refresh_swiperefresh.app;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * android官方的下拉刷新，v4包中
 */
public class MainActivity extends ActionBarActivity implements
        SwipeRefreshLayout.OnRefreshListener,Runnable {


    private SwipeRefreshLayout swipeRefreshLayout;

    // 注意Handler别倒错了是 os 不是logging
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            int what = msg.what;

            if (what == 998) {
                swipeRefreshLayout.setRefreshing(false);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 其他地方要用，故提为成员变量
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.id_swipe_refresh_layout);

        // 设置下拉刷新事件
        swipeRefreshLayout.setOnRefreshListener(this);


        /*  ×××××××   一些 没啥用的外观设置 （有的注释描述不准确）××××××××××××××××
        // 刷新圆圈的颜色
        swipeRefreshLayout.setColorSchemeColors(
                R.color.red, R.color.green, R.color.blue);

        //下拉刷新的距离
        swipeRefreshLayout.setDistanceToTriggerSync(80);

        //下拉刷新的背景色
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.YELLOW);

        //设置圆形初始的大小
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);

        // 设置最终接在指示器停止的位置
        swipeRefreshLayout.setProgressViewEndTarget(true,50);

        */




        ListView listView = (ListView) findViewById(R.id.id_swipe_list);
        if (listView != null) {
            ArrayList<String> strings = new ArrayList<String>();

            for (int i = 0; i < 30; i++) {
                strings.add("数字:" + i);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this,android.R.layout.simple_list_item_1,strings
            );

            listView.setAdapter(adapter);
        }

    }

    @Override
    public void onRefresh() {
        // TODO 联网，然后刷新数据,刷新之后，要关闭刷新动画
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.sendEmptyMessage(998);
    }
}
