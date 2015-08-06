package com.fairyzoro.volley_imageloader_demo.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.fairyzoro.volley_imageloader_demo.app.adapters.PictureAdapter;

import java.util.LinkedList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 网络单例，创建RequestQueue 和 ImageLoader
        NetworkSingleton.createInstance(getApplicationContext());

        ListView listView = (ListView) findViewById(R.id.id_listView_pic);

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


            listView.setAdapter(new PictureAdapter(this,urls));
        }

    }

    public void btnNetImgView(View view) {
    }
}
