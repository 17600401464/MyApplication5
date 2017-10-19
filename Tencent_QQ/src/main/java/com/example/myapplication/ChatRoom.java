package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bean.Tongxin;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by lenovo on 2017/10/11.
 */

public class ChatRoom extends Activity {
    Toolbar toolbar;
    EditText editText;
    Button button;
    Tongxin tongxin;
    ArrayList<Tongxin> lists=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cateroom);
        toolbar=findViewById(R.id.toolbar_tops);
        editText=findViewById(R.id.edit);
        button=findViewById(R.id.sent);
        Logger.setDebug(true);
        NoHttp.initialize(ChatRoom.this);
        setPermissions();

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        tongxin=new Tongxin();
        tongxin.setImg(R.drawable.tou);
        tongxin.setInformation(editText.getText().toString());
        lists.add(tongxin);
        try {
            String ss = URLEncoder.encode(editText.getText().toString(), "UTF-8");
            Log.e("我们个个金融办高级人机",ss);
            netWorkByNoHttpToString("http://op.juhe.cn/robot/index&info=+"+ss+"+&dtype=&loc=&userid=&key=f5d2667dff1bfc58786a06c04c8429af");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
});


    }
    public void netWorkByNoHttpToString(String path){
//        String url="http://v.juhe.cn/toutiao/index";
        //创建请求对象 设置泛型
        Request<String> request = NoHttp.createStringRequest(path,
                RequestMethod.POST);
        request.add("type","");
        request.add("key","2ca3a5b1cb6edf55250bff550ac34325");
        request.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
        //创建请求队列，添加到队列中
        RequestQueue requestQueue = NoHttp.newRequestQueue();
        requestQueue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {

            }

            @Override
            public void onFailed(int what, Response<String> response) {

            }

            @Override
            public void onFinish(int what) {

            }
        });

    }
    private void setPermissions() {
        if (ContextCompat.checkSelfPermission(ChatRoom.this,
                PERMISSION[0]) != PackageManager.PERMISSION_GRANTED) {
            Log.d("data", "权限申请");
            Toast.makeText(this, "申请权限", Toast.LENGTH_SHORT).show();
            //Android 6.0申请权限
            ActivityCompat.requestPermissions(this, PERMISSION, 1);
        }
    }
    static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
            Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
            Manifest.permission.INTERNET   ,    //读取设备信息
            Manifest.permission.ACCESS_NETWORK_STATE,//接入网络状态
            Manifest.permission.ACCESS_WIFI_STATE//接入WIFI状态
    };
}
