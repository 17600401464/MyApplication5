package com.panyutian.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.beicai.utils.TimeChangeUtil;
import com.example.panyutianmusicplayer.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Myladapter extends BaseAdapter {
	ArrayList<HashMap<String, String>> list;
	Context con;
	public Myladapter(Context activity,
			ArrayList<HashMap<String, String>> alist) {
		// TODO Auto-generated constructor stub
		con=activity;
		list=alist;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(arg1 ==null){
			arg1 = View.inflate(con, R.layout.child, null);
			holder = new ViewHolder();
			holder.txTitle = (TextView) arg1.findViewById(R.id.View1);
			holder.txTime = (TextView) arg1.findViewById(R.id.View2);
			//holder.txArtist = (TextView) arg1.findViewById(R.id.text_artist);
			arg1.setTag(holder);
		}else{
			holder = (ViewHolder) arg1.getTag();
		}
		
		
		holder.txTitle.setText(list.get(arg0).get("title"));
		holder.txTime.setText(TimeChangeUtil.changeTime(list.get(arg0).get("duration")));
		//holder.txArtist.setText(list.get(arg0).get("artist"));
		return arg1;
	}
	class ViewHolder{
		private TextView txTitle,txTime;
	}
	public void updateAdapter(ArrayList<HashMap<String, String>> alist){
		this.list = alist;
		notifyDataSetChanged();
	}
	}


