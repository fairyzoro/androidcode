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
    AndroidManifrest.xml  权限的添加
 =========================
 本程序中Volley 命令的使用流程
    1 创建请求队列requestQueue = Volley.newRequestQueue(this)
 注意不是new出来的，由于下面要多次调用，将变量提取为成员变量
    2 生成 请求消息，比如new StringRequest、jsonObjectRequest、ImageRequest
    3 将消息添加到1中生成的队列里，Volley会自动运行消息。 requestQueue.add(xxxRequest)

 =========================
 注意：
    1 网络权限的添加
    2 MainActivity最后写了几个命令，自行baidu google 简单看下就ok

==========================
程序已运行，无错，如果有错，应该是定义消息是有几个ErrorListener未捕获