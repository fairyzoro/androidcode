package com.fairyzoro.xiaoli.app;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import com.fairyzoro.xiaoli.app.userface.XLLoginActivity;

/**
 * Created by Administrator on 2015/8/17.
 */
public class XLDialog extends AlertDialog {

    public View dialogView;

    public XLDialog(Class<XLLoginActivity> context , View v) {
        super(context);
        this.dialogView = v;
        this.setView(v);
    }


}
