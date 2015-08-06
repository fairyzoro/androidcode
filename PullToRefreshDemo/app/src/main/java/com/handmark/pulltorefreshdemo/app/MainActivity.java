package com.handmark.pulltorefreshdemo.app;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements PullToRefreshBase.OnRefreshListener2{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取PullToRefreshListView
        PullToRefreshListView pullToRefreshListView =
                (PullToRefreshListView) findViewById(R.id.id_pulltorefresh);

        // 1、设置PullToRefreshListView支持的方向，上拉、下拉、还是上下都支持
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        // 2、设置数据Adapter
        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < 20; i++) {
            strings.add("数字:" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, strings
        );

        pullToRefreshListView.setAdapter(adapter);

        // 3、设置PullToRefresh 的刷新接口
        pullToRefreshListView.setOnRefreshListener(this);
        // 自己手写上面的implements

        // 4. 获取下拉刷新内部的内容控件
        // 因为 PullToRefreshListView 内部包裹ListView，那么返回的也是ListView
//        ListView listView = pullToRefresh.getRefreshableView();

//        listView.setAdapter(adapter);
        // TODO 这里并没有对listView做进一步尝试,留待以后了
    }

    @Override
    public void onPullDownToRefresh(final PullToRefreshBase refreshView) {
        Toast.makeText(this, "下拉", Toast.LENGTH_SHORT).show();

        AsyncTask<String, Integer, String> task =
                new AsyncTask<String, Integer, String>() {

                    @Override
                    protected String doInBackground(String... params) {

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        return "";
                    }

                    @Override
                    protected void onPostExecute(String s) {

                        // 关闭加载动画,清除状态
                        // 让另一个方向的刷新动画可以显示
                        refreshView.onRefreshComplete();
                        //super.onPostExecute(s);
                    }
                }.execute();

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        Toast.makeText(this,"上拉",Toast.LENGTH_SHORT).show();
    }
}
