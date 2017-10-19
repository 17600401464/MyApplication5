package com.panyutian.adapter;

import com.example.panyutianmusicplayer.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridadapter extends BaseAdapter {
	private int[] imgs;
	private String[] texs;
	private Context content;
		public MyGridadapter(Context contet, int[] img, String[] tex) {
			// TODO Auto-generated constructor stub
			imgs=img;
			texs=tex;
			content=contet;
		}
		public int getCount() {
			// TODO Auto-generated method stub
			return imgs.length;
		}
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view=View.inflate(content, R.layout.gridchild, null);
			ImageView vi=(ImageView) view.findViewById(R.id.imageView1);
			TextView tv=(TextView) view.findViewById(R.id.tx2);
			vi.setImageResource(imgs[position]);
			tv.setText(texs[position]);
	
			
			return view;
			
		}

		

		

}
