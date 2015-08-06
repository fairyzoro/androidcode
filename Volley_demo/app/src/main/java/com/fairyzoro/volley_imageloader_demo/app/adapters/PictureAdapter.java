package com.fairyzoro.volley_imageloader_demo.app.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.fairyzoro.volley_imageloader_demo.app.NetworkSingleton;

import java.util.List;

/**
 * Created by Administrator on 2015/8/6.
 */
public class PictureAdapter extends BaseAdapter{

    private Context context;
    private List<String> pictures;  //存的网址

    public PictureAdapter(Context context, List<String> pictures) {
        this.context = context;
        this.pictures = pictures;
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
        Object ret = pictures.get(position);
        return ret;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView ret = null;
        if (convertView != null) {
            ret = (ImageView)convertView;
        }else {
            ret = new ImageView(context);
        }

        String url = pictures.get(position);

        //------ ImageLoader 来加载图片
        final ImageLoader imageLoader = NetworkSingleton.getInstance().getImageLoader();

        final  ImageView img = ret;

        // 获取图片内容
        imageLoader.get(
                // ---参数1 图片网址
                url,

                // ---参数2 用来接收图片和处理错误
                new ImageLoader.ImageListener() {
                    // -----用来设置 ImageView的图像
                    @Override
                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                        Bitmap bitmap = response.getBitmap();
                        if (bitmap != null) {
                            img.setImageBitmap(bitmap);
                        }
                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                },

                256,
                128
        );


        return ret;
    }
}
