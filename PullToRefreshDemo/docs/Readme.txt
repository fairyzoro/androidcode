PullToRefresh  可以直接在xml里面写，就像listView一样
在java文件里  findViewById 找到

setMode（设置上下拉的方向）
setAdapter（）  设置适配器就当是listView就行
setOnRefresh（this）   手动在文件上面添加implements
	Listener里面写要处理的任务，比如联网什么的
	refreshView.onRefreshComplete()  结束转圈

xml文件应该看看,里面有ptr

！！！！！ 至于 PullToRefresh 怎么加入到工程里,暂时不知道怎么在github上写图文教程

=========
环境：idea14 + Gradle
程序正常运行