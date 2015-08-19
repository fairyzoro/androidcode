package com.example.FragmentTest1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * example:Created by Administrator on 2015/6/25.
 * Project: com.example.FragmentTest1
 * User: S
 * Date: 2015/6/25
 */

//这个文件是怎么被调用的
public class TimeFragment extends Fragment {

    public static final String TAG = "TimeFragment";

    //Fragment 使用的时候  必须写无参构造方法
    //  ！！！ 仅允许 这个无参 ，不能有其他构造方法

    public TimeFragment(){}     //构造

    // 1 最早的声明周期方法


    /**
     * 当Fragment 被添加到Activity中时，进行调用
     * @param activity
     */

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "onAttach");
    }

    /**
     * 第二个声明周期方法
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

/*    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
    }*/
    //onCreateView
    // 这是第三个  怎么没有 .... createView已经有了,所以就不能再写了


    //第四个方法
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    //对应onCreateView 在Freagment销毁前自动调用OnDestroyView
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * 对应onAttach 方法 。彻底从Activity移走
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    /*
    当Fragment要显示的时候  会调用onCreateView方法，
        此方法返回值View 就是用来显示界面的
    @param  inflater    方便加载布局用的，布局加载器
    @param  container   当前Fragment内容要在哪里显示
    @param  savedInstanceState  存储的一些状态
    @return View  要显示的界面
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG,"onCreateView");

        //通用的布局加载方式，一定是 三 个参数的 ，第二个参数是【容器】 ，第三个是【false】
        // 因为返回的 View 也会自动的添加到 container 中
        View ret = inflater.inflate(R.layout.fragment_time, container, false);

        TextView txtDate = (TextView) ret.findViewById(R.id.text_date);
        if (txtDate != null) {
            //TODO 显示 日期 时间 星期

            //例子  显示日期 星期几


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
            Date date = new Date();
            String str = format.format(date);
            txtDate.setText(str);

        }

        return   ret;
    }
}
