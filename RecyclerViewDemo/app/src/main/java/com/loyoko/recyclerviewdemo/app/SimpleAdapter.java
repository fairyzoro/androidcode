package com.loyoko.recyclerviewdemo.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/9/8.
 */
public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    protected List<String> datas;

    // 全手动定义点击事件接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    // private了，就设置一个public调用接口,回调在下面的bind触发
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public SimpleAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_single_textview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }


    //***********************   BindViewHolder   ****************
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView.setText(datas.get(position));

        setUpItemEvent(holder);
    }

    protected void setUpItemEvent(final MyViewHolder holder) {
        if (onItemClickListener != null) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int layoutPosition = holder.getLayoutPosition();
                    // 如果下面第二个参数用的是position，会出现点击事件显示错误,
                    // 所以添加上面一行命令，position也改成了layoutPosition
                    onItemClickListener.onItemClick(holder.itemView,layoutPosition);
//                    onItemClickListener.onItemClick(holder.itemView, position);  //这里为什么是itemview 不是textview呢，两个的区别

                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int layoutPosition = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
//                    onItemClickListener.onItemLongClick(holder.itemView, position);
                    return false;
                }
            });
        }
    }


    //   添加删除
    public void addData(int position) {
        datas.add(position, "Insert One");
//        notifyDataSetChanged(); //这个没有动画效果
        notifyItemInserted(position);
    }

    public void deleteData(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.id_textview);
    }
}