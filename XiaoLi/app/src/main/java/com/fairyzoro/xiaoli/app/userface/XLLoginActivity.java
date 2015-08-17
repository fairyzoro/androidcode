package com.fairyzoro.xiaoli.app.userface;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fairyzoro.xiaoli.app.R;
import com.fairyzoro.xiaoli.app.XLNormalActivity;


public class XLLoginActivity extends XLNormalActivity {

    public EditText phone;
    public EditText passwd;
    public Button login;
    public Button Regist;
    public TextView forgetpass;
    public Handler handler;

    // 初始化主题
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xllogin);
    }


}
