package com.fairyzoro.volley_imageloader_demo.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class VolleyJsonActivity extends ActionBarActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_json);

        // 因为下面按钮里打印日志要用，所以提取为成员变量
        textView = (TextView) findViewById(R.id.id_txView_json);
        
        
    }

    /**
     * 点击按钮，发起POST提交
     * @param view
     */
    public void btnPost(View view) {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://www.q.com",      // url根据自己的该
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText(error.getMessage());
                    }
                }
        ){
            // TODO 这个地方是，StringRequest 类的内部，相当于内部类
            // 需要重写特定的方法才可以实现POST提交真实的数据
            /**
             * Ctrl + o 里面可以找到这个方法，避免写错
             * 返回POST请求提交的数据，key=value的形式
             * @return
             * @throws AuthFailureError
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
//                return super.getParams();
                HashMap<String,String> ret = new HashMap<String, String>();
                
                ret.put("name","abc");
                ret.put("pass", "123");
                
                return ret;
            }
        };
        
        //RequestQueue
        RequestQueue  requestQueue = NetworkSingleton.getInstance().getRequestQueue();
        requestQueue.add(request);
    }

    /**
     * Volley POST
     * @param view
     */
    public void btnPostBytes(View view) {
        StringRequest request =
                new StringRequest(
                        Request.Method.POST,
                        "http://10.0.175.103:8080/post",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                textView.setText(error.getMessage());
                            }
                        }
                ){
                    // TODO 这个地方是，StringRequest 类的内部，相当于内部类
                    // 需要重写特定的方法才可以实现POST提交真实的数据

                    // 字节数组用在上传头像，上传图片之类的
                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        return "I love Android".getBytes();
//                        return super.getBody();
                    }

                    /**
                     * 在提交POST的时候，指定这个信息，来通知服务器
                     * 上传的内容是什么
                     * @return
                     */
                    @Override
                    public String getBodyContentType() {
                        return "text/plain";
//                        return "application/json";
                    }
                };

        //RequestQueue
        RequestQueue requestQueue = NetworkSingleton.getInstance().getRequestQueue();
        
        requestQueue.add(request);

    }

    public void btnPostJson(View view) {

        // TODO 提交JSON

        JSONObject json = new JSONObject();

        try {
            json.put("name","abc");
            json.put("pass","123");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request =
                new JsonObjectRequest(
                        "http://10.0.175.103:8080/post",
                        json,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                textView.setText(""+response.toString());
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                textView.setText(""+error.getMessage());

                            }
                        }
                );

        RequestQueue requestQueue = NetworkSingleton.getInstance().getRequestQueue();

        requestQueue.add(request);
    }
}
