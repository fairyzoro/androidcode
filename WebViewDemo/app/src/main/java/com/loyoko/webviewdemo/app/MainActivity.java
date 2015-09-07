package com.loyoko.webviewdemo.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webView = (WebView) findViewById(R.id.id_webview);
        webView.loadUrl("http://www.baidu.com/");

        //------------------------------------------------
        // 下面不写就是新开浏览器
        webView.setWebViewClient(new WebViewClient() {
                                     @Override
                                 public boolean shouldOverrideUrlLoading(WebView view, String url) {

                                         // 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                                         view.loadUrl(url);
                                         return true;
//                                     return super.shouldOverrideUrlLoading(view, url);
                                     }
                             }
        );
        //-----------------------------------------------------

    }


}
