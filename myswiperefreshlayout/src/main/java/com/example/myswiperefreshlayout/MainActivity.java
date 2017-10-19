package com.example.myswiperefreshlayout;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
SwipeRefreshLayout swipeRefreshLayout;
  ListView listView;
  ArrayList<String> arrayList = new ArrayList<>();
  ArrayList<String> data = new ArrayList<>();
  MyAdapter adapter;
  int index;
  Handler hand = new Handler(){
    @Override
    public void handleMessage(Message msg) {
      if(msg.what == 0x111){
        adapter.updateAdapter(data);
        swipeRefreshLayout.setRefreshing(false);
      }
    }
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }
  void init(){
    swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
    //设置刷新控件的颜色变化
    swipeRefreshLayout.setColorSchemeColors(
        getResources().getColor(android.R.color.holo_blue_bright,null),
        getResources().getColor(android.R.color.holo_green_dark,null),
        getResources().getColor(android.R.color.holo_red_light,null),
        getResources().getColor(android.R.color.holo_orange_dark,null));
    //设置刷新控件的背景颜色
    swipeRefreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.colorAccent,null));
    //给刷新控件设置监听
    swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
      @Override
      public void onRefresh() {
        Toast.makeText(MainActivity.this, "正在刷新...", Toast.LENGTH_SHORT).show();
        hand.sendEmptyMessageDelayed(0X111,3000);
        //将新数据插入到集合的前面 显示到ListView的上方
        int i;
        int k = 0;
        for(i = index;i<index+20;i++){
            data.add(k,arrayList.get(i));
            k++;
        }
        index += 20;
      }
    });
    listView = (ListView) findViewById(R.id.listview);
    //封装全部要显示的数据
    for(int i = 0;i<100;i++){
      arrayList.add("我是数据"+i);
    }
    //获取单次要显示的前20条数据
    for(index = 0;index<20;index++){
     data.add(arrayList.get(index));
    }
    adapter = new MyAdapter(data,MainActivity.this);
    listView.setAdapter(adapter);

  }

}
