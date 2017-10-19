package com.panyutain.activity;


import java.util.ArrayList;
import java.util.HashMap;

import com.beicai.lib.SlidingMenu;
import com.beicai.lib.app.SlidingActivity;
import com.example.panyutianmusicplayer.R;

import com.panyutian.adapter.MyGridBoadapter;
import com.panyutian.adapter.Threadadapter;
import com.panyutian.bean.MyGridDate;
import com.panyutian.fragment.BoFragment;
import com.panyutian.fragment.MuFragment;
import com.panyutian.fragment.MyFragment;
import com.panyutian.fragment.SoFragment;
import com.panyutian.sqldao.Message;


import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class IndexPager extends SlidingActivity {
	
	FragmentManager fm;
	FragmentTransaction ft;
	MyFragment f1;
	MuFragment f2;
	SoFragment f3;
	BoFragment f4;
	Message me;
	TextView tv1,tv2,tv3,tv4,names,tui;
	SlidingMenu menu;
	String namee;
	ImageView ki;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);
		setBehindContentView(R.layout.behand);
		ki=(ImageView) findViewById(R.id.imgki);
		names=(TextView) findViewById(R.id.names);
		GridView gv=(GridView) findViewById(R.id.ligride);
		
		int[] list=new MyGridDate().getliImages();
		String[] name=new MyGridDate().getliTextData();
		gv.setAdapter(new Threadadapter(IndexPager.this, list,name));
		menu=getSlidingMenu();
		WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		// 通过窗口管理器对象获取显示对象
		Display dis = manager.getDefaultDisplay();
		// 通过构造方法获取属性对象
		DisplayMetrics met = new DisplayMetrics();
		// 把显示对象的属性传给属性对象
		dis.getMetrics(met);
		int width = met.widthPixels * 2 / 3;
		menu.setBehindWidth(width);
		// 设置在某个页面上的侧滑方式
		// 设置滑动在 上面的页面有效
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// 设置滑动在 下面的页面有效
		// menu.setTouchModeBehind(i);
		// 设置侧滑页出现的方向 滑动方向跟页面的出现方向相反
		menu.setMode(SlidingMenu.RIGHT);
		// 设置显示页面
		menu.showContent();
		
		f1=new MyFragment();
		f2=new MuFragment();
		f3=new SoFragment();
		f4=new BoFragment();
		
		fm=getFragmentManager();
		ft=fm.beginTransaction();
		tui=(TextView) findViewById(R.id.tui);
		tv1=(TextView) findViewById(R.id.btns1);
		tv2=(TextView) findViewById(R.id.btns2);
		tv3=(TextView) findViewById(R.id.btns3);
		tv4=(TextView) findViewById(R.id.btns4);
		ft.add(R.id.lo, f1);
		ft.add(R.id.lo, f2);
		ft.add(R.id.lo, f3);
		ft.add(R.id.lo, f4);
		ft.show(f1);
		ft.hide(f2);
		ft.hide(f3);
		ft.hide(f4);
		ft.commit();
		tui.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				me.delect(namee);
				Intent intent=new Intent(getApplicationContext(), IndexPager.class);
				startActivity(intent);
				Toast.makeText(getApplicationContext(), "为啥", 1).show();
			}
		});
		tv1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ft=fm.beginTransaction();
				ft.show(f1);
				ft.hide(f2);
				ft.hide(f3);
				ft.hide(f4);
				ft.commit();
			}
		});
		tv2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ft=fm.beginTransaction();
				ft.show(f2);
				ft.hide(f1);
				ft.hide(f3);
				ft.hide(f4);
				ft.commit();
			}
		});
	tv3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ft=fm.beginTransaction();
				ft.show(f4);
				ft.hide(f1);
				ft.hide(f3);
				ft.hide(f2);
				ft.commit();
			}
		});
	tv4.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ft=fm.beginTransaction();
			ft.show(f3);
			ft.hide(f1);
			ft.hide(f4);
			ft.hide(f2);
			ft.commit();
		}
	});
	
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		me=new Message(this);
		
		if(me.loginselect()==null){
			names.setText("点击登录");
			
		}else{
			namee=me.loginselect().get("name");
			names.setText(namee);
			ki.setBackgroundResource(R.drawable.toxiang1);
		}
		super.onResume();
	}
	

}

