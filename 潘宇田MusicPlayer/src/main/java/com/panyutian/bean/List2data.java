package com.panyutian.bean;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;

public class List2data {
	public static ArrayList<Newitem> getNewsdata() {
		ArrayList<Newitem> list = new ArrayList<Newitem>();
		for (int i = 0; i < 10; i++) {
			Newitem it1 = new Newitem();
			it1.staricon = R.drawable.touxiang;
			it1.starname = "薛之谦";
			it1.stardes = "他想是想陪你走过千山万水";
			list.add(it1);
			Newitem it2 = new Newitem();
			it2.staricon = R.drawable.touxiang;
			it2.starname = "刘德华";
			it2.stardes = "心中名副其实的天王";
			list.add(it2);
			Newitem it3 = new Newitem();
			it3.staricon = R.drawable.touxiang;
			it3.starname = "邓丽君";
			it3.stardes = "很遗憾，我想你";
			list.add(it3);
			Newitem it4 = new Newitem();
			it4.staricon = R.drawable.touxiang;
			it4.starname = "金文芝";
			it4.stardes = "他不是岁月神偷，他是最好听的歌";
			list.add(it4);
			Newitem it5 = new Newitem();
			it5.staricon = R.drawable.touxiang;
			it5.starname = "王菲";
			it5.stardes = "愿世人只听经典";
			list.add(it5);
		}
		return list;
	}
}
