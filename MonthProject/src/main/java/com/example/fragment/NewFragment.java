package com.example.fragment;

import android.Manifest;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.FragmentAdapter;
import com.example.bean.Beanone;
import com.example.bean.Beantwo;
import com.example.myapplication.R;
import com.example.myapplication.SuperSwipeRefreshLayout;
import com.google.gson.Gson;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by lenovo on 2017/8/7.
 */

public class NewFragment extends Fragment {
    ListView listView;
    Beantwo newsBean = null;
    FragmentAdapter adapter;
    String ss;
    String paths;
    private SuperSwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
     View view=View.inflate(getActivity(), R.layout.newfragment,null);
        setPermissions();
        Logger.setDebug(true);

        NoHttp.initialize(getActivity());
        listView = view.findViewById(R.id.listview);
        adapter = new FragmentAdapter(getActivity(), newsBean);
        listView.setAdapter(adapter);
        swipeRefreshLayout = (SuperSwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout
                .setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {

                    @Override
                    public void onRefresh() {
                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        }, 2000);
                    }

                    @Override
                    public void onPullDistance(int distance) {
                        System.out.println("debug:distance = " + distance);
                        // myAdapter.updateHeaderHeight(distance);
                    }

                    @Override
                    public void onPullEnable(boolean enable) {
                    }
                });



        new Thread() {
            public void run() {
                getData("湖人");

            }
        }.start();
        return view;
    }
    static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
            Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
            Manifest.permission.INTERNET   ,    //读取设备信息
            Manifest.permission.ACCESS_NETWORK_STATE,//接入网络状态
            Manifest.permission.ACCESS_WIFI_STATE//接入WIFI状态
    };

    private void setPermissions() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                PERMISSION[0]) != PackageManager.PERMISSION_GRANTED) {
            Log.d("data", "权限申请");
            Toast.makeText(getActivity(), "申请权限", Toast.LENGTH_SHORT).show();
            //Android 6.0申请权限
            ActivityCompat.requestPermissions(getActivity(), PERMISSION, 1);
        }
    }
    public void getData(String path) {
        try {
            this.paths = path;
            String ss = URLEncoder.encode(path, "UTF-8");

            String url = "http://op.juhe.cn/onebox/basketball/team";
            //创建请求对象 设置泛型
            Request<String> request = NoHttp.createStringRequest(url,
                    RequestMethod.GET);
            request.add("type", "");
            request.add("team", ss);
            request.add("key", "2879274f89775de8809e836220c8eff4");
            request.setCacheMode(CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
            //创建请求队列，添加到队列中
            RequestQueue requestQueue = NoHttp.newRequestQueue();
            requestQueue.add(0, request, new OnResponseListener<String>() {
                @Override
                public void onStart(int what) {

                }

                @Override
                public void onSucceed(int what, Response<String> response) {
                    Gson gson = new Gson();
                    newsBean = gson.fromJson(response.get(), Beantwo.class);
                    Log.e("ahhahahahahhahahha", response.get());
//                    getActivity().runOnUiThread(new Thread() {
//                        public void run() {
                            if(newsBean.getResult()==null){
                                Gson gsons = new Gson();
                                switch (paths){
                                    case "湖人":

                                        newsBean = gsons.fromJson(getdate("huren").toString(), Beantwo.class);
                                        Log.d("哈哈哈哈", "woshihuren");
                                        break;
                                    case "雷霆":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("leiting").toString(), Beantwo.class);
                                        break;
                                    case "骑士":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("qishi").toString(), Beantwo.class);
                                        break;
                                    case "勇士":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("yongshi").toString(), Beantwo.class);
                                        break;
                                    case "公牛":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("gonfniu").toString(), Beantwo.class);
                                        break;
                                    case "凯尔特人":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("kaierteren").toString(), Beantwo.class);
                                        break;
                                    case "热火":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("rehuo").toString(), Beantwo.class);
                                        break;
                                    case "快船":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("taiyang").toString(), Beantwo.class);
                                        break;
                                    case "火箭":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("huojian").toString(), Beantwo.class);
                                        break;
                                    case "小牛":
//                                    Gson gson = new Gson();
                                        newsBean = gsons.fromJson(getdate("moshu").toString(), Beantwo.class);
                                        break;



                                }
                            }
                            adapter.updateAdapter(newsBean);
//                        }
//                    });


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

            InputStream inputStreams = getActivity().getAssets().open(pa);

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
