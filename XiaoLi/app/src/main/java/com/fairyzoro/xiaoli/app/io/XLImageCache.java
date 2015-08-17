package com.fairyzoro.xiaoli.app.io;

/**
 * Created by Administrator on 2015/8/17.
 */

import android.graphics.Bitmap;
import android.util.LruCache;

import java.util.logging.Handler;

/**
 * 图像缓存
 */
public class XLImageCache {

    // TODO 挪哪里去了
    private LruCache<String, Bitmap> mcache =
            new LruCache<String ,Bitmap>(0);  // api12

    // 从Assets 目录获取图像
    public void get(Handler handler, int id , String fileName) {
        return;
    }

    // 从资源文件
    // int id 可以为每一个图片添加一个id来标识
    public void get(Handler handler, int id, int redId) {
        return;
    }

    // 从SD卡,
    // fromsd = false，filename 为一个url
    // fromsd = true，filename 为一个SD卡上的文件路径
    public void get(Handler handler, int id, String filename, boolean fromSD) {
        return;
    }

    public class MemoryCache{

    }

    public class DiskCache {

    }


}
