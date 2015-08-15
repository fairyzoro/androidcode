package com.fairyzoro.xutils_demo.app;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import com.lidroid.xutils.BitmapUtils;

import java.util.LinkedList;

/**
 * xUtils 由于源码有冲突，就用jar包里
 */
public class BitmapUtilsActivity extends ActionBarActivity {

    private ImageView imageView;
    private BitmapUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_utils);

        imageView = (ImageView) findViewById(R.id.id_imageView);
        utils = new BitmapUtils(this);
        // 以上变量下面都要用，故提取为成员变量

        ListView listView = (ListView) findViewById(R.id.id_listView);

        if (listView != null) {
            LinkedList<String> urls = new LinkedList<String>();

            urls.add("http://static.cnbetacdn.com/newsimg/110510/0657270304679663.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/06572812092092639.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/06572821055742383.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/06572832143154119.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/0657284141410713.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/06572853202906.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/0657286356675680.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/0657287194682034.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/0657288100141150.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/06572891582276304.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/065728101511075857.jpg");
            urls.add("http://static.cnbetacdn.com/newsimg/110510/06572811161499476.jpg");


            listView.setAdapter(new PictureAdapter1(this,urls));
        }

    }


    public void btnShowPic(View view) {
        utils.display(imageView,"https://www.baidu.com/img/bd_logo1.png");
    }
}
