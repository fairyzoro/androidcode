package com.fairyzoro.xiaoli.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class XLNormalActivity extends XLBaseActivity {

    // 当前的Activity布局
    public LinearLayout layout;
    // 标题栏
    public TitleBar titleBar;
    // 菜单栏的layout
    public MenuBar menuBar;
    // 主题的部分
    public View body;

    // 标题栏定义
    public class TitleBar extends FrameLayout {
        public TitleBar(Context context) {
            super(context);
        }
    }
    // 菜单栏定义
    public class MenuBar extends LinearLayout{
        public MenuBar(Context context) {
            super(context);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化 Acitivity
        setContentView(R.layout.activity_xlnormal);

        layout = new LinearLayout(this);
        titleBar = new TitleBar(this);
        InitBody();
        menuBar = new MenuBar(this);
        layout.addView(titleBar);
        layout.addView(body);
        layout.addView(menuBar);

        this.setContentView(layout);
    }

    // 初始化主题内容 重用的时候好用
    public void InitBody(){
        body = new View(this);
    }
    // 返回按钮的显示状态
    public void setreturnbtnVisuale(boolean value) {
    }
    public boolean getReturnbtnVisuable() {
        return true;
    }
    // 标题信息
    public void setTitle(String titile) {
    }
    public String getTitleString() {
        return "";
    }
    // 右边按钮是否显示，和显示的内容
    public void setRightBtn(String imgkey, String imgkeydown) {
    }

    public void setRightBtnVisuable(boolean value) {
    }

    public boolean getRightBtnVisuable() {
        return false;
    }

    // 最下面菜单 TODO ---
    public void setMenuIndex(int value) {
    }
    public void getMenuindex() {
        return;
    }

}
