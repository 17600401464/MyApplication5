package com.panyutian.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class KuLunbo extends PagerAdapter {
	private Context tex;
	private ArrayList<ImageView> lists;
		public KuLunbo(Context context,ArrayList<ImageView> list) {
			// TODO Auto-generated constructor stub
			tex=context;
			lists=list;
		}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}
@Override
public Object instantiateItem(ViewGroup container, int position) {
	// TODO Auto-generated method stub
	System.out.println(position);
	container.addView(lists.get(position%(lists.size())));
	return lists.get(position%(lists.size()));
	
}
@Override
public void destroyItem(ViewGroup container, int position, Object object) {
	// TODO Auto-generated method stub
	System.out.println(position);
	container.removeView(lists.get(position%(lists.size())));
}
	

}
