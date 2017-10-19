package com.panyutian.fragment;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;
import com.panyutian.adapter.KuLunbo;
import com.panyutian.adapter.MyGridBoadapter;
import com.panyutian.adapter.Threadadapter;
import com.panyutian.bean.Kulunbodata;
import com.panyutian.bean.MyGridDate;
import com.panyutian.sqldao.Message;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class SoFragment extends Fragment {
	GridView dgrid,tugrid,regrid;
	ViewPager og;
	Message me;
	TextView th;
	ImageView to;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=View.inflate(getActivity(), R.layout.solayout, null);
		dgrid=(GridView) view.findViewById(R.id.dgrid);
		regrid=(GridView) view.findViewById(R.id.regride);
		tugrid=(GridView) view.findViewById(R.id.tugride);
		to=(ImageView) view.findViewById(R.id.txto);
		
		og=(ViewPager) view.findViewById(R.id.paiew);
		
		int[] dlist=new MyGridDate().getdgridImages();
		String[] dname=new MyGridDate().getdgridData();
		dgrid.setAdapter(new Threadadapter(getActivity(), dlist,dname));
		
		int[] relist=new MyGridDate().getregridImages();
		String[] rename=new MyGridDate().getregridData();
		regrid.setAdapter(new MyGridBoadapter(getActivity(), relist,rename));
		int[] tulist=new MyGridDate().gettugridImages();
		String[] tuname=new MyGridDate().gettugridData();
		th=(TextView) view.findViewById(R.id.namee);
		tugrid.setAdapter(new MyGridBoadapter(getActivity(), tulist,tuname));
		ArrayList<ImageView> lists=Kulunbodata.getPagertwoDate(getActivity());
	    og.setAdapter(new KuLunbo(getActivity(),lists));
	    int m = Integer.MAX_VALUE/2%(lists.size());
	    og.setCurrentItem(Integer.MAX_VALUE/2-m);
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					SystemClock.sleep(1000);
	getActivity().runOnUiThread(new Runnable() {
						
						public void run() {
							// TODO Auto-generated method stub
							og.setCurrentItem(og.getCurrentItem()+1);
						}
					});
			}
			}
		}).start();
		return view;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		me=new Message(getActivity());
		if(me.loginselect()==null){
			th.setText("µã»÷µÇÂ¼");
			
		}else{
			th.setText(me.loginselect().get("name"));
			to.setBackgroundResource(R.drawable.toxiang1);
		}
		super.onResume();
	}
}
