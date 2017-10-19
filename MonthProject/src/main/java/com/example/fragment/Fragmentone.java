package com.example.fragment;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.Fragmentoneadapter;
import com.example.adapter.Fragmentoneteamadapter;
import com.example.bean.Beanone;
import com.example.bean.Beantwo;
import com.example.myapplication.Mainurl;
import com.example.myapplication.R;
import com.google.gson.Gson;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by lenovo on 2017/8/4.
 */

public class Fragmentone extends Fragment {
    ImageView play1, play2;
    TextView score, play2name, play1name, music;
    ListView  lv;
    ListView listView;
   // com.example.adapter.NewFragment newFragmentadapter;
    Beanone beanone = null;
    Beantwo beantwo =null;
    Fragmentoneadapter adapter;
    Fragmentoneteamadapter adapterteam;
    String ss;
    String pathe;
    LinearLayoutManager laymanager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragmentone, null);
        setPermissions();
        Logger.setDebug(true);

        NoHttp.initialize(getActivity());

        lv = view.findViewById(R.id.lv2);
        //newFragmentadapter = new com.example.adapter.NewFragment(getActivity(),beanone);
        adapter=new Fragmentoneadapter(getActivity(),beanone);
//        setListViewHeightBasedOnChildren(listView);


        adapterteam = new Fragmentoneteamadapter(getActivity(), beanone, beantwo);
        lv.setAdapter(adapterteam);
        lv.addHeaderView(View.inflate(getActivity(),R.layout.hend,null));


        final  LinearLayout inviss =view.findViewById(R.id.heds);


        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i>=1) {
                    inviss.setVisibility(View.VISIBLE);

                } else {
                    inviss.setVisibility(View.GONE);
                }

            }
        });
        listView = view.findViewById(R.id.my_recycler_view);
        listView = (ListView) view.findViewById(R.id.my_recycler_view);
//创建默认的线性LayoutManager
        laymanager=new LinearLayoutManager(getActivity());
//        listView.setLayoutManager(laymanager);
////如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        listView.setHasFixedSize(true);
////创建并设置Adapter
//       // mAdapter = newMyAdapter(getDummyDatas());
        listView.setAdapter(adapter);
        //listView.setAdapter(adapter);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);
        //setListViewHeightBasedOnChildrentwo(lv);
//        setListViewHeightBasedOnChildren(lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String url = beanone.getResult().getTeammatch().get(i).getUrl();
                Intent intent = new Intent(getActivity(), Mainurl.class);
                intent.putExtra("url", url);
                startActivity(intent);

            }
        });





        new Thread() {
            @Override
            public void run() {
//                getData("http://op.juhe.cn/onebox/basketball/nba?dtype=&=&key=2879274f89775de8809e836220c8eff4");
                netWorkByNoHttpToString();
            }
        }.start();



        play1 = view.findViewById(R.id.play1);
        play2 = view.findViewById(R.id.play2);
        play1name = view.findViewById(R.id.play1name);
        play2name = view.findViewById(R.id.play2name);
        score = view.findViewById(R.id.score);
        music = view.findViewById(R.id.music);

        return view;

    }
    public void netWorkByNoHttpToString() {
        String url = "http://op.juhe.cn/onebox/basketball/nba";
        //创建请求对象 设置泛型
        Request<String> request = NoHttp.createStringRequest(url,
                RequestMethod.POST);
        request.add("type", "");
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
                Log.e("ahhahahahahhahahha", response.get());
                beanone = gson.fromJson(response.get(), Beanone.class);

                try {
                if (beanone.getResult() == null) {

                    InputStream inputStreams = null;

                        inputStreams = getActivity().getAssets().open("zk_new_json.txt");

                    ByteArrayOutputStream bss = new ByteArrayOutputStream();
                    byte[] buffers = new byte[512];
                    int lengths;
                    while ((lengths = inputStreams.read(buffers)) != -1) {
                        bss.write(buffers, 0, lengths);
                        bss.flush();
                    }

                    beanone = gson.fromJson(bss.toString(), Beanone.class);

                }
                    adapter.updateAdapter(beanone);

                    adapterteam.updateAdapter(beantwo, beanone);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {

            }

            @Override
            public void onFinish(int what) {

            }
        });
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
//    void getData(String path) {
//        try {
//            URL url = new URL(path);
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//            con.setRequestMethod("GET");
//
//            con.setReadTimeout(100000);
//            con.setConnectTimeout(100000);
//            con.connect();
//            if (con.getResponseCode() == 200) {
//                InputStream inputStream = con.getInputStream();
//                ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                byte buffer[] = new byte[512];
//                int length;
//                while ((length = inputStream.read(buffer)) != -1) {
//                    bs.write(buffer, 0, length);
//                    bs.flush();
//                }
//                Gson gson = new Gson();
//                beanone = gson.fromJson(bs.toString(), Beanone.class);
//                Log.e("ahhahahahahhahahha", "getData: ");
//                if (beanone.getResult() == null) {
//
//                    InputStream inputStreams = getActivity().getAssets().open("zk_new_json.txt");
//                    ByteArrayOutputStream bss = new ByteArrayOutputStream();
//                    byte[] buffers = new byte[512];
//                    int lengths;
//                    while ((lengths = inputStreams.read(buffers)) != -1) {
//                        bss.write(buffers, 0, lengths);
//                        bss.flush();
//                    }
//                    beanone = gson.fromJson(bss.toString(), Beanone.class);
//                }
//                    getActivity().runOnUiThread(new Thread() {
//                        public void run() {
//
//                            adapter.updateAdapter(beanone);
//
//                            adapterteam.updateAdapter(beantwo, beanone);
//
//                        }
//                    });
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    public void getDatateam( String path,Beanone beanone) {
//        try {
//this.pathe=path;
//            URL url = new URL("http://op.juhe.cn/onebox/basketball/team?dtype=&team=%E6%B9%96%E4%BA%BA&key=2879274f89775de8809e836220c8eff4");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            con.setReadTimeout(10000);
//            con.setConnectTimeout(10000);
//            con.connect();
//            if (con.getResponseCode() == 200) {
//
//                InputStream inputStream = con.getInputStream();
//                ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                byte buffer[] = new byte[512];
//                int length;
//                while ((length = inputStream.read(buffer)) != -1) {
//                    bs.write(buffer, 0, length);
//                    bs.flush();
//                }
//
//                Message msg = hand.obtainMessage();
//
//                msg.what = 0x111;
//                //msg.obj=beanone;
//                msg.obj =bs;
//                hand.sendMessage(msg);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//}
//public void getteamid(String sss, final Beanone beanone){
//this.ss=sss;
//
//    new Thread(){
//        @Override
//        public void run() {
//            getDatateam(ss,beanone);
//        }
//    }.start();
//}
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        Fragmentoneadapter listAdapter = (Fragmentoneadapter) listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
    public void setListViewHeightBasedOnChildrentwo(ListView listView) {
        // 获取ListView对应的Adapter
        Fragmentoneteamadapter listAdapter = (Fragmentoneteamadapter) listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }


}
