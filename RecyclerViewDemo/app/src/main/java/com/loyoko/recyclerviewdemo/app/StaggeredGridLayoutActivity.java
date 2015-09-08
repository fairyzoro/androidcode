package com.loyoko.recyclerviewdemo.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class StaggeredGridLayoutActivity extends ActionBarActivity {
    private RecyclerView recyclerView;
    private List<String> datas;
    private StaggeredAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initViews();

        adapter = new StaggeredAdapter(this, datas);
        recyclerView.setAdapter(adapter);

        // 设置RecyclerView的布局管理
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));


        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {
                adapter.deleteData(position);
            }
        });

        // 设置RecyclerView的Item间分割线
        // item_single_textview.xml 设置了margin,设置分割线什么的就可以省事了
//        recyclerView.addItemDecoration(
//                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
    }

    private void initDatas() {
        datas = new ArrayList<String>();
        for (int i = 'A'; i < 'Z'; i++) {
            datas.add(" " + (char) i);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        // 这里没有功能代码，就不切换了，想看其他样式，就会退回去看
        switch (id) {
        }

        return super.onOptionsItemSelected(item);
    }
}
