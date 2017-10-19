package com.panyutian.adapter;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandaMyAdapter extends BaseExpandableListAdapter{
	Context mcontext;
	ArrayList<String> list;
	public ExpandaMyAdapter(Context context,ArrayList<String> lists) {
		// TODO Auto-generated constructor stub
		mcontext=context;
		list=lists;
	}
	
	String[][] childimg=new String[][]{
			{"一万个舍不得","好好过"},
			{"我好想你"},
			{"别爱","我知道你不爱我","小幸运"},
			{"夜"}

	};
	String childname[][]=new String[][]{
			{"潘宇田","潘金莲"},
			{"潘长江"},
			{"潘仁美","潘雨桐","潘安"},
			{"潘大炮"}
	};

	
	
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view=View.inflate(mcontext, R.layout.exchild, null);
		TextView iv=(TextView) view.findViewById(R.id.texiew1);
		TextView tv=(TextView) view.findViewById(R.id.texiew2);
		iv.setText(childimg[groupPosition][childPosition]);
		tv.setText(childname[groupPosition][childPosition]);
		return view;
	}
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return childimg[groupPosition].length;
	}
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view=View.inflate(mcontext, R.layout.group, null);
		ImageView iv=(ImageView) view.findViewById(R.id.imgview1);
		TextView tv=(TextView) view.findViewById(R.id.textview1);
		iv.setImageResource(R.drawable.touxiang);
		tv.setText(list.get(groupPosition));
		return view;
	}
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
}
