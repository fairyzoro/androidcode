说明:
下拉刷新，官方v4

文件列表：
mainActivity
main.xml  <-  color.xml

流程：
0 listView设置数据
1、xml里一个swipeRefresh 包裹一个listView
2、主函数里findViewById 找到swipeRefresh
3、setOnRefreshListener
4、listener接口里写线程启动，
5、线程里写入要做的事和handler传递消息
6、传递的消息要回到成员变量那里定义的Handler接受消息

==============
idea14 gradle
以正常运行
