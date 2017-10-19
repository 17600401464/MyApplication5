package com.panyutian.bean;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;

import android.content.Context;
import android.widget.ImageView;

public class Kulunbodata {
	public static ArrayList<ImageView> getPagerDate(Context context) {
		// TODO Auto-generated method stub
	int[] img=new int[]{
			R.drawable.slun4,
			R.drawable.slun1,
			R.drawable.bolun2,
			R.drawable.bolun4,
			R.drawable.slun1
	};

	ArrayList<ImageView> list=new ArrayList<ImageView>();
	for(int i=0;i<img.length;i++){
		ImageView iv=new ImageView(context);
		iv.setBackgroundResource(img[i]);
		list.add(i, iv);
	}
	return list;
	}
	public static ArrayList<ImageView> getPagertwoDate(Context context) {
		// TODO Auto-generated method stub
	int[] img=new int[]{
			R.drawable.slun1,
			R.drawable.slun2,
			
			R.drawable.bolun2,
			R.drawable.bolun1
	};

	ArrayList<ImageView> list=new ArrayList<ImageView>();
	for(int i=0;i<img.length;i++){
		ImageView iv=new ImageView(context);
		iv.setBackgroundResource(img[i]);
		list.add(i, iv);
	}
	return list;
	}
}
