package com.panyutian.bean;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;

import android.content.Context;
import android.widget.ImageView;

public class Mydata {
public static ArrayList<ImageView> getPagerDate(Context context) {
	// TODO Auto-generated method stub
int[] img=new int[]{
		R.drawable.img_1024476,
		R.drawable.img_1024496,
		R.drawable.img_1024500,
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
