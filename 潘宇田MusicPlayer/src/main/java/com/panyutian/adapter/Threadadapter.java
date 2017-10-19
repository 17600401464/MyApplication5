package com.panyutian.adapter;

import com.example.panyutianmusicplayer.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Threadadapter extends BaseAdapter {
	private Context Con;
	private int[] list;
	private String[] name;
public Threadadapter(Context con,int[] list,String[] name) {
	// TODO Auto-generated constructor stub
	this.Con=con;
	this.list=list;
	this.name=name;
}
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view=View.inflate(Con, R.layout.threadgridlayout, null);
		ImageView iv=(ImageView) view.findViewById(R.id.iee);
		TextView te=(TextView) view.findViewById(R.id.txx);
		iv.setBackgroundResource(list[position]);
		te.setText(name[position]);
		return view;
	}

}
