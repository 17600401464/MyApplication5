package com.example.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.MenuAdapter;
import com.example.bean.Getmenudate;
import com.example.fragment.XFragindex;
import com.example.lib.SlidingMenu;
import com.example.lib.app.SlidingActivity;

import java.util.ArrayList;

public class MainActivity extends SlidingActivity {
    CircularImage circularImage;
    ImageView xiaoxi,lianxi,dongtai;
    TextView txiao,tlianxi,tdongtai;
    ListView list;
    FragmentManager fm;
    FragmentTransaction ft;
    Getmenudate getmenudate;
    Toolbar toolbar;
    private SlidingMenu menu;
    XFragindex xFragindex;
    ArrayList<Getmenudate> lists;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.behind);
        lists=getmenudates();
        list= (ListView) findViewById(R.id.list);
        list.setAdapter(new MenuAdapter(MainActivity.this,lists));
        circularImage= (CircularImage) findViewById(R.id.cover_user_photo);
        circularImage.setImageResource(R.drawable.lintou);
        settoobar();
        setfragment();
        LeftSlide();

    }
    void settoobar(){
        toolbar= (Toolbar) findViewById(R.id.toolbar_top);
        toolbar.setPopupTheme(R.style.PopupMenu);
        toolbar.inflateMenu(R.menu.menu_main);

//        toolbar.setMinimumWidth(2000);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_item1:
                        //drawerLayout.openDrawer(Gravity.RIGHT);
                }
                return false;
            }
        });
    }
    void setfragment(){
        xiaoxi= (ImageView) findViewById(R.id.xiaoxi);
        lianxi= (ImageView) findViewById(R.id.lianxi);
        dongtai= (ImageView) findViewById(R.id.dongtai);
        txiao= (TextView) findViewById(R.id.txaioxi);
        tlianxi= (TextView) findViewById(R.id.tlianxi);
        tdongtai= (TextView) findViewById(R.id.tdongtai);
        xiaoxi.setBackgroundResource(R.drawable.xiaoxil);
        txiao.setTextColor(Color.BLUE);
        lianxi.setBackgroundResource(R.drawable.lianxi);
        tlianxi.setTextColor(Color.BLACK);
        dongtai.setBackgroundResource(R.drawable.dongtai);
        tdongtai.setTextColor(Color.BLACK);
        txiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xiaoxi.setBackgroundResource(R.drawable.xiaoxil);
                txiao.setTextColor(Color.BLUE);
                lianxi.setBackgroundResource(R.drawable.lianxi);
                tlianxi.setTextColor(Color.BLACK);
                dongtai.setBackgroundResource(R.drawable.dongtai);
                tdongtai.setTextColor(Color.BLACK);
            }
        });
        tlianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lianxi.setBackgroundResource(R.drawable.lianxil);
                tlianxi.setTextColor(Color.BLUE);
                xiaoxi.setBackgroundResource(R.drawable.xiaoxi);
                txiao.setTextColor(Color.BLACK);
                dongtai.setBackgroundResource(R.drawable.dongtai);
                tdongtai.setTextColor(Color.BLACK);
            }
        });
        tdongtai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dongtai.setBackgroundResource(R.drawable.dongtail);
                tdongtai.setTextColor(Color.BLUE);
                xiaoxi.setBackgroundResource(R.drawable.xiaoxi);
                txiao.setTextColor(Color.BLACK);
                lianxi.setBackgroundResource(R.drawable.lianxi);
                tlianxi.setTextColor(Color.BLACK);
            }
        });
        fragment();
    }
    void fragment(){
        xFragindex=new XFragindex();
        fm=getFragmentManager();
        ft=fm.beginTransaction();
        ft.add(R.id.fragment,xFragindex);
        ft.show(xFragindex);
        ft.commit();

    }
ArrayList<Getmenudate> getmenudates(){
    lists=new ArrayList<Getmenudate>();
    String[] name=new String[]{"了解会员特权","QQ钱包","个性装扮","我的收藏","我的相册","我的文件","我的名片夹"};
   int[] img=new int[]{R.drawable.dongtai,R.drawable.dongtai,R.drawable.dongtai,R.drawable.dongtai,R.drawable.dongtai,R.drawable.dongtai,R.drawable.dongtai};

    for(int i=0;i<name.length;i++){
        getmenudate=new Getmenudate();
        getmenudate.img=img[i];
        getmenudate.name=name[i];
        lists.add(getmenudate);

    }
    return lists;
}
void LeftSlide(){
    menu = getSlidingMenu();
    WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
    Display display = windowManager.getDefaultDisplay();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    display.getMetrics(displayMetrics);

    int width = displayMetrics.widthPixels;

    int height = displayMetrics.heightPixels;
    menu.setBehindWidth(width/3*2);
    menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    menu.setMode(SlidingMenu.LEFT);
    circularImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            menu.showMenu();
        }
    });
    circularImage= (CircularImage) findViewById(R.id.cover_user_photo2);
    circularImage.setImageResource(R.drawable.lintou);

}
}
