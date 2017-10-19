package com.panyutian.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.panyutianmusicplayer.R;
import com.panyutain.activity.IndexPager;
import com.panyutain.activity.MainActivity;
import com.panyutain.activity.Songactivity;
import com.panyutian.adapter.Myfadapter;
import com.panyutian.sqldao.Message;

import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Fragmentload extends Fragment{
	ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String,String>>();
	Message muc;
	@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View view=View.inflate(getActivity(), R.layout.musiclistfragment, null);
	ListView lv=(ListView) view.findViewById(R.id.list1);
	alist=getMusic();
	lv.setAdapter(new Myfadapter(getActivity(),alist));
	
	lv.setOnItemClickListener(new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
			muc=new Message(getActivity());
			
			boolean bo=muc.selectmusic(alist.get(arg2).get("title"));
			if(bo==false){
				Toast.makeText(getActivity(), "已存在", 1).show();
				
			}else{
				muc.inserlt(alist.get(arg2).get("title"), alist.get(arg2).get("duration"));
				Toast.makeText(getActivity(), "插入成功", 1).show();
				((Songactivity) getActivity()).getDataFrom1To2();
			}
			((Songactivity) getActivity()).musicplay(alist,arg2);
		}
	});
	lv.setOnItemLongClickListener(new OnItemLongClickListener() {

		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				final int arg2, long arg3) {
			// TODO Auto-generated method stub
			Builder build=new Builder(getActivity());
			build.setMessage("确定加入我喜欢列表");
			build.setPositiveButton("确定", new OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					muc.inserltlike(alist.get(arg2).get("title"), alist.get(arg2).get("duration"));
				dialog.dismiss();
				}
			});
			build.show();
			return false;
		}
	});
	return view;
}
	
	public ArrayList<HashMap<String, String>> getMusic() {
		// TODO Auto-generated method stub
	
		ContentResolver cr = getActivity().getContentResolver();
		Cursor cursor = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
				null, null, null, null);
		cursor.moveToPrevious();
		while (cursor.moveToNext()) {
			HashMap<String, String> map = new HashMap<String, String>();
			String title = cursor.getString(cursor
					.getColumnIndex(MediaStore.Audio.Media.TITLE));
			String path = cursor.getString(cursor
					.getColumnIndex(MediaStore.Audio.Media.DATA));
			String duration = cursor.getString(cursor
					.getColumnIndex(MediaStore.Audio.Media.DURATION));
			String artist = cursor.getString(cursor
					.getColumnIndex(MediaStore.Audio.Media.ARTIST));
			map.put("title", title);
			map.put("path", path);
			map.put("duration", duration);
			map.put("artist", artist);
			alist.add(map);
		}
		return alist;
	}








}
