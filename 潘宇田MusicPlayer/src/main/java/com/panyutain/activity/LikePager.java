package com.panyutain.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.panyutianmusicplayer.R;
import com.panyutian.adapter.Myladapter;
import com.panyutian.sqldao.Message;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class LikePager  extends Activity{
	ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String,String>>();
	Message muc;
	Myladapter adapter;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	setContentView(R.layout.musiclovefragment);
	muc=new Message(getApplicationContext());
	ListView lv=(ListView) findViewById(R.id.lv);
	alist=muc.selectlike();
	adapter=new Myladapter(this,alist);
	lv.setAdapter(adapter);
	super.onCreate(savedInstanceState);
}
}
