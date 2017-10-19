package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.Getmenudate;
import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/20.
 */


public class MenuAdapter extends BaseAdapter {
    Context con;
    ArrayList<Getmenudate> list;

    public MenuAdapter(Context con,ArrayList<Getmenudate> lists) {
        this.con = con;
        this.list=lists;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         final  Holder holder;
        if(view==null){
            holder=new Holder();
            view=View.inflate(con, R.layout.menuchild,null);
            holder.img=view.findViewById(R.id.imageView);
            holder.tex=view.findViewById(R.id.textView);
           view.setTag(holder);
        }else{
            holder=(Holder)view.getTag();
        }
        holder.img.setBackgroundResource(list.get(i).img);
        holder.tex.setText(list.get(i).name);
        return view;
    }
    class Holder{
        private ImageView img;
        private TextView tex;
    }
}
