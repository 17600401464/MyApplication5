  package com.panyutian.fragment;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;
import com.panyutian.adapter.KuLunbo;
import com.panyutian.adapter.MyGridBoadapter;
import com.panyutian.bean.Kulunbodata;
import com.panyutian.bean.MyGridDate;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

public class BoFragment extends Fragment {
	ViewPager vp;
	GridView gv;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=View.inflate(getActivity(), R.layout.bolayout, null);
		vp=(ViewPager) view.findViewById(R.id.paview);
		gv=(GridView) view.findViewById(R.id.grides);
		ArrayList<ImageView> lists=Kulunbodata.getPagertwoDate(getActivity());
	    vp.setAdapter(new KuLunbo(getActivity(),lists));
	    int m = Integer.MAX_VALUE/2%(lists.size());
	    vp.setCurrentItem(Integer.MAX_VALUE/2-m);
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					SystemClock.sleep(1000);
	getActivity().runOnUiThread(new Runnable() {
						
						public void run() {
							// TODO Auto-generated method stub
							vp.setCurrentItem(vp.getCurrentItem()+1);
						}
					});
			}
			}
		}).start();
		
		int[] list=new MyGridDate().gettwoImages();
		String[] name=new MyGridDate().gettwoTextData();
		gv.setAdapter(new MyGridBoadapter(getActivity(), list,name));
		return view;
	}
}
