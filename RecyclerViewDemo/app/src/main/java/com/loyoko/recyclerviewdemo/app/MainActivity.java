package com.loyoko.recyclerviewdemo.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private RecyclerView recyclerView;
    private List<String> datas;
    private SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initViews();

        adapter = new SimpleAdapter(this, datas);
        recyclerView.setAdapter(adapter);

        // 设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 设置RecyclerView的动画效果，使用的默认效果,其他看git
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 点击事件,设置是在adapter里面设置的
        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"click: " + position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,"Long click: " + position,Toast.LENGTH_SHORT).show();
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


        switch (id) {

            case R.id.action_add:
                adapter.addData(1);
                break;
            case R.id.action_delete:
                adapter.deleteData(1);
                break;

            case R.id.action_gridview:
                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_listview:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_staggered:
                Intent intent = new Intent(this, StaggeredGridLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.action_hor_gridview:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(
                        5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
