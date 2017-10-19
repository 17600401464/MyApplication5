package com.panyutian.fragment;

import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;

import com.example.panyutianmusicplayer.R;
import com.panyutain.activity.IndexPager;
import com.panyutian.adapter.KuLunbo;
import com.panyutian.adapter.Listkuadapter;
import com.panyutian.adapter.MyGridKuadapter;
import com.panyutian.bean.Kulunbodata;
import com.panyutian.bean.List2data;
import com.panyutian.bean.MyGridDate;
import com.panyutian.bean.Newitem;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MuFragment extends Fragment  {
	
	private Context mcontext;
	ViewPager pageview;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View view=View.inflate(getActivity(), R.layout.kulayout, null);
	pageview=(ViewPager)view. findViewById(R.id.pageview);
    mcontext=getActivity();
    ArrayList<ImageView> lists=Kulunbodata.getPagerDate(mcontext);
    pageview.setAdapter(new KuLunbo(mcontext,lists));
    int m = Integer.MAX_VALUE/2%(lists.size());
	pageview.setCurrentItem(Integer.MAX_VALUE/2-m);
	new Thread(new Runnable() {
		
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				SystemClock.sleep(1000);
getActivity().runOnUiThread(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						pageview.setCurrentItem(pageview.getCurrentItem()+1);
					}
				});
		}
		}
	}).start();
	GridView grid=(GridView) view.findViewById(R.id.gride);
	int[] list=new MyGridDate().getKuimgData();
	grid.setAdapter(new MyGridKuadapter(getActivity(), list));
	ListView lis=(ListView) view.findViewById(R.id.lists);
	ArrayList<Newitem> listss=List2data.getNewsdata();
	lis.setAdapter(new Listkuadapter(getActivity(), listss));
	return view;
	
}




}


