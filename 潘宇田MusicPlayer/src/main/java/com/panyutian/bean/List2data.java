package com.panyutian.bean;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;

public class List2data {
	public static ArrayList<Newitem> getNewsdata() {
		ArrayList<Newitem> list = new ArrayList<Newitem>();
		for (int i = 0; i < 10; i++) {
			Newitem it1 = new Newitem();
			it1.staricon = R.drawable.touxiang;
			it1.starname = "Ѧ֮ǫ";
			it1.stardes = "�������������߹�ǧɽ��ˮ";
			list.add(it1);
			Newitem it2 = new Newitem();
			it2.staricon = R.drawable.touxiang;
			it2.starname = "���»�";
			it2.stardes = "����������ʵ������";
			list.add(it2);
			Newitem it3 = new Newitem();
			it3.staricon = R.drawable.touxiang;
			it3.starname = "������";
			it3.stardes = "���ź���������";
			list.add(it3);
			Newitem it4 = new Newitem();
			it4.staricon = R.drawable.touxiang;
			it4.starname = "����֥";
			it4.stardes = "������������͵������������ĸ�";
			list.add(it4);
			Newitem it5 = new Newitem();
			it5.staricon = R.drawable.touxiang;
			it5.starname = "����";
			it5.stardes = "Ը����ֻ������";
			list.add(it5);
		}
		return list;
	}
}
