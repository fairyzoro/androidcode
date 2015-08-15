package com.fairyzoro.xutils_demo.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/8/7.
 */
public class PictureAdapter1 extends BaseAdapter {

    private Context context;
    private List<String> pictures;  //存的网址
    private BitmapUtils utils;

    public PictureAdapter1(Context context, List<String> picture) {
        this.context = context;
        this.picture = picture;
    }


    @Override
    public int getCount() {
        int ret = 0;
        if (pictures != null) {
            ret = pictures.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        Object ret = null;
        ret = pictures.get(position);
        return ret;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;

        if (convertView != null) {
            ret = (ViewGroup)convertView;
        }else {
            ret
        }









        return ret;
    }
}
