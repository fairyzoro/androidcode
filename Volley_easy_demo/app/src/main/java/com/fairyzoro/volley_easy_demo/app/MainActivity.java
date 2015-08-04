package com.fairyzoro.volley_easy_demo.app;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;


/**
 * Volley的简单应用Demo
 * 一定要先阅读docs目录下的readme，省时省力
 */
public class MainActivity extends ActionBarActivity {

    /**
     * 整个Volley的联网请求的实现 管理  都是通过这个RequestQueue来完成实现的<br/>
     * 是一个自己管理的队列，内部包含了多个线程，来进行网络的并发请求<br/>
     * 请求网络的速度非常快<br/>
     * 一个RequestQueue可以支持连续的，多个网络请求<br/>
     */
    private RequestQueue requestQueue;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 创建队列，并且自动启动
         */
        requestQueue = Volley.newRequestQueue(this);
        imageView = (ImageView) findViewById(R.id.id_imageView);
    }


    /**
     * 点击按钮 使用Volley 连接网络
     * !!!!!!!!! 需要网络权限
     * @param view
     */
    public void btnAccessNet(View view) {

        StringRequest request = new StringRequest(
                "http://www.baidu.com",     // url
                //-------------
                new Response.Listener<String>() {    // 数据返回之后接收数据的接口，能够运行在主线程，可以更新UI
                    @Override
                    public void onResponse(String response) {
                        Log.d("---VolleyTest", "response=" + response);
                    }
                },
                //-------------
                new Response.ErrorListener() {     // 当网络请求失败的时候，回调这个接口
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("---Error",""+error.getMessage());
                    }
                }
        );

        // 添加队列，进行联网   !!!!!!!!! 需要网络权限
        requestQueue.add(request);
    }

    /**
     * 点击按钮 使用Volley 获取 Json 数据
     * @param view
     */
    public void btnGetJson(View view) {

        // 参数1 请求网址
        //http://mobile.ximalaya.com/m/category_tag_menu
        // 参数2 JSONObject 对象，提交给服务器的JSON信息
        // 参数3 相应回调
        // 参数4 错误回调
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                "http://mobile.ximalaya.com/m/category_tag_menu",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("---MainActivity","json-"+response);
                    }
                },
                null

        );

        requestQueue.add(jsonObjectRequest);
    }

    /**
     * 使用Volley的ImageRequest获取网络图片
     * !!!!!!!这种加载方式是最笨的，后面的Volley Demo里有更高级的
     * @param view
     */
    public void btnGetImage(View view) {
        final ImageRequest imageRequest = new ImageRequest(
                "http://static.cnbetacdn.com/newsimg/110510/0657270304679663.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        // 显示图片
                        imageView.setImageBitmap(response);
                    }
                },
                512,
                480,
                Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 网络加载图片失败
                        Toast.makeText(MainActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                        Log.d("----","网络连接错误");
                    }
                }
        );

        requestQueue.add(imageRequest);
    }
}


//        DefaultRetryPolicy retryPolicy = new DefaultRetryPolicy();//重试失败的请求
//        request.setRetryPolicy(retryPolicy);

//        request.setTag();
//        requestQueue.cancelAll();
//        request.setShouldCache();