说明：最基本的对话框演示，尤其是进度对话框虚有其表




组件：
MainActivity.java
-------------
ProgressDialog  进度对话框
    开始：new AlertDialog.Builder(this);
    中间：各种set
    最后：xx.show();
AlertDialog  警告对话框，主要是退出警告
    开始：new AlertDialog.Builder(this);
    中间：各种set
    最后: xx.show();
=========================
ToastActivity.java
----------
Toast.makeToast();

!!!!!!!!!!!!!!!!!!!!!!!!!!!!
new Toast(this);   主要用于自定义Toast ！！！！！！ 进去看，调用了单独的xml.


涉及命令：dialog.dismiss();

//TODO 进度条那个 后面还有实时的,写完后再回来补链接
//TODO 退出警告框，过时了，后面写了新的再补