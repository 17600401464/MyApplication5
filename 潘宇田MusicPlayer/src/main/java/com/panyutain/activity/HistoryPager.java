package com.panyutain.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.panyutianmusicplayer.R;
import com.panyutian.adapter.Myladapter;
import com.panyutian.sqldao.Message;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class HistoryPager extends Activity {
	ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String,String>>();
	Message muc;
	Myladapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.musiclovefragment);
		ListView lv=(ListView) findViewById(R.id.lv);
		muc=new Message(getApplicationContext());
		alist=muc.select();
		adapter=new Myladapter(this,alist);
		lv.setAdapter(adapter);
	}

}
