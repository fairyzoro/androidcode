package com.loyoko.recyclerviewdemo.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/8.
 */
//public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.MyViewHolder> {
public class StaggeredAdapter extends SimpleAdapter {
    // 因为SimpleAdapter里面的ViewHolder写在外面了，这里MyViewHolder必须要指定内部

//    private LayoutInflater inflater;
//    private Context context;
//    private List<String> datas;    // 因为该了继承，所以没用了

    private List<Integer> height;   //动态的指定高度

    public StaggeredAdapter(Context context, List<String> datas) {
        super(context, datas);    //添加了这一行
//        this.context = context;
//        this.datas = datas;
//        inflater = LayoutInflater.from(context);    //因为继承，没用了

        // 初始化的时候初始高度数值
        height = new ArrayList<Integer>();
        for (int i = 0; i < datas.size(); i++) {
            height.add((int)(100+Math.random()*300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // 设置视图高度
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = height.get(position);
        holder.itemView.setLayoutParams(layoutParams);

        holder.textView.setText(datas.get(position));  // datas 会提示错误，从提示该成protected,SimpleAdapter里面自动就换了

        // 这个要注意了，这个不写长按没效果
        setUpItemEvent(holder);
    }

}



