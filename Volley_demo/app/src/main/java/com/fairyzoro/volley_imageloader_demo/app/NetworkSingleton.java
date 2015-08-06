package com.fairyzoro.volley_imageloader_demo.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2015/8/6.
 */

/**
 * 参考官方文档，对Volley进行单例封装
 */
public class NetworkSingleton {
    private static NetworkSingleton ourInstance ;

    public static NetworkSingleton createInstance(Context context){
        if (ourInstance == null){
            ourInstance = new NetworkSingleton(context);
        }
        return ourInstance;
    }

    public static NetworkSingleton getInstance() {
        return ourInstance;
    }


    //**************   构造函数 和 新加成员变量 *****************
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    private NetworkSingleton(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        imageLoader = new ImageLoader(
                requestQueue,
                new ImageLoader.ImageCache() {

                    /**
                     * LruCache
                     */
                    private LruCache<String, Bitmap> lruCache =
                            new LruCache<String, Bitmap>(20);  //API 12

                    @Override
                    public Bitmap getBitmap(String url) {
                        return lruCache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        lruCache.put(url, bitmap);
                    }
                }
        );
    }

    // *********    get  ********************
    public ImageLoader getImageLoader(){
        return imageLoader;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }

}
