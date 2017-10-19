package com.panyutian.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyAdapter extends PagerAdapter{
private Context mcontext;
private ArrayList<ImageView> lists;
	
	public MyAdapter(Context context,ArrayList<ImageView> list){
	// TODO Auto-generated constructor stub
		mcontext=context;
		lists=list;
}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		System.out.println("getCount");
		return lists.size();
		
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
	System.out.println(position+"instan");
	 container.addView(lists.get(position));
		return lists.get(position);
	}
@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		//super.destroyItem(container, position, object);
		container.removeView(lists.get(position));
		System.out.println(position+"desx");
	}
}
