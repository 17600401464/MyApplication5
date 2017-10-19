package com.example.myswiperefreshlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by wangye on 2017/9/21.
 */

public class MyAdapter extends BaseAdapter{
  ArrayList<String> arrayList = new ArrayList<>();
  Context c;
  public MyAdapter(ArrayList<String> arrayList,Context c){
    this.arrayList = arrayList;
    this.c = c;
  }

  @Override
  public int getCount() {
    return arrayList.size();
  }

  @Override
  public Object getItem(int i) {
    return arrayList.get(i);
  }

  @Override
  public long getItemId(int i) {
    return 321;
  }

  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    TextView tx = new TextView(c);
    tx.setTextColor(c.getResources().getColor(android.R.color.holo_green_light,c.getTheme()));
    tx.setTextSize(30);
    tx.setText(arrayList.get(i));
    return tx;
  }

  public void updateAdapter(ArrayList<String> arrayList){
    this.arrayList = arrayList;
    notifyDataSetChanged();
  }
}
