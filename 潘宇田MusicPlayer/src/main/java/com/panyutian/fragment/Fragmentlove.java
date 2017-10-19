package com.panyutian.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.panyutianmusicplayer.R;
import com.panyutian.sqldao.Message;
import com.panyutian.adapter.Myladapter;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragmentlove extends Fragment{
	ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String,String>>();
	Message mdo;
	Myladapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mdo=new Message(getActivity());
		View view=View.inflate(getActivity(), R.layout.musiclovefragment, null);
		ListView lv=(ListView) view.findViewById(R.id.lv);
		alist=mdo.select();
		adapter=new Myladapter(getActivity(),alist);
		lv.setAdapter(adapter);
		return view;
	}
	public void getDatatoChangeUI(){
		alist = mdo.select();
		adapter.updateAdapter(alist);
	}
}
