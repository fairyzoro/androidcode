package com.fairyzoro.xiaoli.app.data;

/**
 * Created by Administrator on 2015/8/17.
 */


import android.os.Handler;
import android.os.Message;
import com.fairyzoro.xiaoli.app.io.XLHttpManager;

import java.util.ArrayList;

/**
 * 用户数据定义
 * 包含用户的数据和操作
 */
public class UserData {

    public static int MESSAGE_LOGIN = 0X0000001;
    public static int MESSAGE_REGIST = 0x00000002;
    public static int MESSAGE_CHANGE_RPASSWD = 0X00000003;

    // 消息句柄
    public Handler handler;
    // 用户ID，存储在服务器上，可以用于标识用户的唯一编号，顺序生成（服务器）
    public int UserId;  // 每次登录都会生成新的
    // 标识是否已经登陆过
    public boolean Logined = false;
    // 网络身份识别ID
    public String TokenId = "";

    // 以下四项为个人基本信息
    public String Username;
    public String Phone;
    public String Passwd;
    public String HeadImagepath; // 头像路径


    // UserData 的构造函数
    public UserData() {             // TODO 待
        super();
        handler = new Handler( ){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
    }

    // 加载数据的函数
    public void loadUserData() {
        // 加载User ID
        // 加载Logined 状态
        // 加载UserName
        // 加载Phone
        // 加载HeadImagePath
        // 加载passwd
    }

    //保存数据的函数
    public void SaveUserData() {
        // 保存UserID
        // 保存Logined状态
        // 保存UserName
        // 保存Phone
        // 保存HeadImagePath
        // 保存Passwd
    }

    /*

    二、注册
http请求方式: POST
请求地址：http://xl.wx.21future.com/index.php?s=appapi&a=reg
参数说明
参数	是否必须	参数说明
mobile	是	用户注册手机号
password	是	用户登录的密码
pincode	是	手机短信验证码
username	否	用户昵称，如为空用手机号代替
返回结果
成功：{"status":"1","data":"注册成功！"}
失败：{"status":"0","data":"注册失败！"}


     */


    // 用户注册
    public int registUser(String phone, String passwd, String username) {
        int ret = 0;
        // TODO 打开连接，执行定义的接口
        return ret;
    }

    // 用户登录
    public int login(Handler h, String username, String passwd) {
        int ret = 0;
        // TODO 构造字符串，执行网络连接接口

        String url="";
        XLHttpManager.get(h ,url);

        return ret;
    }

    // 更改资料
    public int change(ArrayList<String> values) {
        int ret = 0;
        // TODO 转换成为网络接口字符串，执行网络接口
        return ret;
    }

    // 修改密码
    public int changePasswd(String oldPasswd, String newPasswd) {
        int ret = 0;
        // TODO 转换成为网络接口字符串，执行网络接口
        return ret;
    }

    // 短信验证
    public int getVerifyCode(String phone,String code) {
        int ret = 0;
        return ret;
    }
    // 修改绑定电话
    public int changePhone(String oldPhone , String newPhone) {
        int ret = 0;
        return ret;
    }
}
