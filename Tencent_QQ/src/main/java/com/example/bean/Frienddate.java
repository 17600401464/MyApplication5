package com.example.bean;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/21.
 */

public class Frienddate {
    int[] img=new int[]{R.drawable.friend1,R.drawable.friend2,R.drawable.friend3,R.drawable.friend4,R.drawable.friend5,R.drawable.friend6,R.drawable.friend7,R.drawable.friend8,R.drawable.friend9,R.drawable.friend10,R.drawable.friend11,R.drawable.friend14,R.drawable.friend15};
    String[] name=new String[]{"爸爸","妈妈","爸爸","妈妈","爸爸","妈妈","爸爸","妈妈","爸爸","妈妈","爸爸","妈妈","爸爸"};
    String[] time=new String[]{"16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00","16:20:00"};
    ArrayList<Frintdateclass> list = new ArrayList<>();
    Frintdateclass frintdateclass;
    public  ArrayList<Frintdateclass> getfrindate(){
        for(int i=0;i<img.length;i++){
            frintdateclass = new Frintdateclass();
            frintdateclass.img = img[i];
            frintdateclass.name=name[i];
            frintdateclass.time=time[i];
            list.add(frintdateclass);

        }
        return list;
    }
}
