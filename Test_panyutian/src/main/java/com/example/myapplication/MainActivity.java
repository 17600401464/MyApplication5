package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
Beantwo beanone;
    ListView list;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPermissions();
        Logger.setDebug(true);

        NoHttp.initialize(this);

        adapter=new Adapter(MainActivity.this,beanone);
        list= (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        netWorkByNoHttpToString();
    }
    static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
            Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
            Manifest.permission.INTERNET   ,    //读取设备信息
            Manifest.permission.ACCESS_NETWORK_STATE,//接入网络状态
            Manifest.permission.ACCESS_WIFI_STATE//接入WIFI状态
    };

    private void setPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                PERMISSION[0]) != PackageManager.PERMISSION_GRANTED) {
            Log.d("data", "权限申请");
            Toast.makeText(this, "申请权限", Toast.LENGTH_SHORT).show();
            //Android 6.0申请权限
            ActivityCompat.requestPermissions(this, PERMISSION, 1);
        }


    }
    String sss;
    public void netWorkByNoHttpToString() {
        try {
            String ss = URLEncoder.encode("湖人", "UTF-8");
            sss=ss;
//            String url = "http://op.juhe.cn/onebox/basketball/nba";
//            //创建请求对象 设置泛型
//            Request<String> request = NoHttp.createStringRequest(url,
//                    RequestMethod.POST);
//            request.add("type", "");
//            request.add("key", "2879274f89775de8809e836220c8eff4");

            String url = "http://op.juhe.cn/onebox/basketball/team";

            Request<String> request = NoHttp.createStringRequest(url,
                    RequestMethod.POST);
            request.add("type","");
            request.add("team",sss);
            request.add("key","2879274f89775de8809e836220c8eff4");

            request.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);

            RequestQueue requestQueue = NoHttp.newRequestQueue();
        requestQueue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                Gson gson = new Gson();

                Log.e("ahhahahahahhahahha", sss);
                beanone = gson.fromJson(response.get(), Beantwo.class);
                if(beanone.getResult()==null) {
                    Gson gsons = new Gson();
                    beanone = gsons.fromJson(getdate("huren").toString(), Beantwo.class);
                }




                adapter.update(beanone);



            }
            @Override
            public void onFailed(int what, Response<String> response) {

            }

            @Override
            public void onFinish(int what) {

            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    ByteArrayOutputStream bsss;
    public ByteArrayOutputStream getdate(String pa) {
        try {
            bsss=new ByteArrayOutputStream();

            InputStream inputStreams = this.getAssets().open(pa);

            ByteArrayOutputStream bss = new ByteArrayOutputStream();
            byte[] buffers = new byte[512];
            int lengths;
            while ((lengths = inputStreams.read(buffers)) != -1) {
                bss.write(buffers, 0, lengths);
                bss.flush();
            }
            this.bsss=bss;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return bsss;
    }
}
