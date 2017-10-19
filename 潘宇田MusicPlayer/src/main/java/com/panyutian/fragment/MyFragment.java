package com.panyutian.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.panyutianmusicplayer.R;
import com.panyutain.activity.HistoryPager;
import com.panyutain.activity.IndexPager;
import com.panyutain.activity.LikePager;
import com.panyutain.activity.LoginPager;
import com.panyutain.activity.Songactivity;
import com.panyutian.adapter.ExpandaMyAdapter;
import com.panyutian.adapter.MyGridadapter;
import com.panyutian.bean.MyGridDate;
import com.panyutian.bean.Myexpad;
import com.panyutian.sqldao.Message;

import android.app.Fragment;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment extends Fragment {
	TextView login;
	
	LoginPager lp;
	Message me;
	
	TextView form;
	TextView tianjia;
	ExpandaMyAdapter ex;
	Myexpad ad;
	ArrayList<String> list;
	TextView t1, t3, t4;
	View view;
	ImageView im;
	ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String, String>>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = View.inflate(getActivity(), R.layout.mylayout, null);
		login = (TextView) view.findViewById(R.id.tx1);
		t1 = (TextView) view.findViewById(R.id.ben);
		t3 = (TextView) view.findViewById(R.id.load);
		t4 = (TextView) view.findViewById(R.id.like);
		im=(ImageView) view.findViewById(R.id.toxiang1);
		GridView grid = (GridView) view.findViewById(R.id.grid);
		MyGridDate gride = new MyGridDate();
		int[] img = gride.getImages();
		String[] tex = gride.getTextData();

		grid.setAdapter(new MyGridadapter(getActivity(), img, tex));
		grid.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch (arg2) {
				case 0:
					Intent intent = new Intent(getActivity(),
							Songactivity.class);
					startActivity(intent);
					break;
				case 2:
					Intent intent2 = new Intent(getActivity(),
							HistoryPager.class);
					startActivity(intent2);
					break;
				case 3:
					Intent intent3 = new Intent(getActivity(), LikePager.class);
					startActivity(intent3);
					break;
				}
			}
		});

		
		init();
		final ExpandableListView lv = (ExpandableListView) view
				.findViewById(R.id.listview);
		ad = new Myexpad();
		list = ad.getgroup();
		lv.setAdapter(new ExpandaMyAdapter(getActivity(), list));
		form = (TextView) view.findViewById(R.id.form);
		tianjia = (TextView) view.findViewById(R.id.tianjia);

		form.setText("自建歌单（" + list.size() + ")");
		tianjia.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Builder build = new Builder(getActivity());
				final EditText ed = new EditText(getActivity());
				ed.setTextColor(TRIM_MEMORY_BACKGROUND);
				build.setTitle("输入歌单名");
				build.setView(ed);
				// build.setMessage("你没有删除权限");
				build.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								list.add(ed.getText().toString());
								form.setText("自建歌单（" + list.size() + ")");
								lv.setAdapter(new ExpandaMyAdapter(
										getActivity(), list));
								new ExpandaMyAdapter(getActivity(), list)
										.notifyDataSetChanged();
								dialog.cancel();

							}
						});
				build.show();
			}
		});
		return view;

	}

	public void init() {
		login.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "wd", 1).show();
				Intent intent = new Intent(getActivity(), LoginPager.class);
				startActivity(intent);
			}
		});
	}

	Fragmentload gi;

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "efefe", 1).show();
		me = new Message(getActivity());
		if (me.loginselect() == null) {
			login.setText("点击登录");
			

		} else {
			login.setText(me.loginselect().get("name"));
			im.setBackgroundResource(R.drawable.toxiang1);
		}
		
		t1.setText(getMusic() +"");

		t3.setText(me.select().size()+"");
		t4.setText(me.selectlike().size()+"");
		super.onResume();
	}
	public int  getMusic() {
		// TODO Auto-generated method stub
	
		ContentResolver cr = getActivity().getContentResolver();
		Cursor cursor = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
				null, null, null, null);
		int a=cursor.getCount();
		
		return a;
	}
	
}
