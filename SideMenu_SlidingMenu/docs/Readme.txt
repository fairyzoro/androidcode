说明：
idea+gradle  侧滑菜单  https://github.com/jfeinstein10/SlidingMenu

程序流程：
new 出来的
然后各种set  进去仔细看，列出来的命令都是精华

文件列表
mainActivity.java
main.xml 主界面
layout/ menu_left.xml menu_right.xml   左右菜单界面



意外情况：
添加库的时候，报错，依旧是清单文件提示drawable/ic_launcher 找不到
把那一句删了重新编译，又出现，再删再出现。。。
解决方法，先删，再右侧Gradle clear一下，再rebuild 不行就这几个步骤重复一下

================
程序已正常运行