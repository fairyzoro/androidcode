说明：
    Volley的最大好处就是用于ListView之类的网络图片加载，会进行本地内存缓存，
以及内存存储区，默认不会缓存到SDCard上，简单改源码便可实现，此例没实现，
在下个例子NetworkImageView使用中实现。
==========================
大致程序流程：
    1、ListView设置adapter
    2、adapter要加载资源，就要在里面用到Requestqueue 和 ImageLoader
    3、官方推荐用单例，因此 Requestqueue 和 ImageLoader 的设置就写在了单例里，adapter只获取就行
    4、在程序的开始的地方调用create单例
==========================
导入Volley
 1 src main java 下面新建package “com.android.volley”
 2 去sdk目录下，D:\sdk\android-sdk-windows\sources\android-22\com\android\volley
全选 volley 目录下的文件，复制，粘贴到工程包volley目录下
 3 rebuild，报错R文件之类的，把错误文件删了（其实就删一个，那是个单元测试文件，删了无影响）
 4 rebuild 应该是ok了

 =========================
 文件列表：
    MainActivity.java
    activity_main.xml
    NetworkSingleton.java       //imageloader的单例
    adapters/PictureAdapter.java    //listView的adapter
    adapters/PictureNetViewAdapter.java     //NetworkImageView用的adapter ！！！！！！！
    AndroidManifrest.xml        //权限的添加

    NetViewActivity.java       //NetworkImageView
    VolleyJsonActivity         //Volley的POST用法，
        这个只是简单记录，POST的写法并没写完整；POST还是交给xUtils做吧
 =========================
 命令列表：
    单例格式进文件看
    Volley.newRequestQueue(context)
    new ImageLoader(requestQueue, ImageLoader.ImageCache)
        LruCache<>
    imageLoader.get(url,lintener,长，宽)

    listView.setAdapter(adapter)
 =========================
 注意：
    1 网络权限的添加


==========================
将 内部存储缓存 改为SDCard 缓存
改动源码文件：java\com\android\volley\toolbox
进入流程：单例文件NetWorkSingleton中，点入Volley.newRequestQueue(context)，点入return newRequestQueue(context, null);
可以看到File cacheDir = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
改为：
  File cacheDir = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 外部存储路径
            cacheDir = context.getExternalCacheDir();
        }
==========================
程序已运行，无错，如果有错，应该是定义消息是有几个ErrorListener未捕获