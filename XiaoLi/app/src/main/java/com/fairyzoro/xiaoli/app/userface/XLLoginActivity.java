package com.fairyzoro.xiaoli.app.userface;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.fairyzoro.xiaoli.app.R;
import com.fairyzoro.xiaoli.app.XLDialog;
import com.fairyzoro.xiaoli.app.XLNormalActivity;


public class XLLoginActivity extends XLNormalActivity {

    public EditText phone;
    public EditText passwd;
    public Button login;
    public Button Regist;
    public TextView forgetpass;
    public Handler handler;

    // 初始化主体内容
    public void InitBody() {
        LinearLayout l = new LinearLayout(this);
        // 加载xml文件或者代码生成
        body = l;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.userData.login(handler,
                        phone.getEditableText().toString(),
                        passwd.getEditableText().toString());
            }

        });
        XLDialog dlg =
                new XLDialog(XLLoginActivity.class,
                        new DialogLayout(XLLoginActivity.this));
    }

    // DialogLayout 二级人脉那里能用的到对话框
    public class DialogLayout extends FrameLayout {
        public DialogLayout(Context context) {
            super(context);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xllogin);
    }


}
