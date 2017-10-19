package com.panyutian.adapter;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;
import com.panyutian.bean.Newitem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Listkuadapter extends BaseAdapter {
	private Context con;
	private ArrayList<Newitem> list;
public Listkuadapter(Context con,ArrayList<Newitem> list) {
	this.con=con;
	this.list=list;
	// TODO Auto-generated constructor stub
}
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
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
		View view=View.inflate(con, R.layout.listkulatout, null);
		ImageView im=(ImageView) view.findViewById(R.id.iw1);
		TextView tv1=(TextView) view.findViewById(R.id.tw1);
		TextView tv2=(TextView) view.findViewById(R.id.tw2);
		im.setBackgroundResource(list.get(position).staricon);
		tv1.setText(list.get(position).starname);
		tv2.setText(list.get(position).stardes);
		return view;
	}

}
