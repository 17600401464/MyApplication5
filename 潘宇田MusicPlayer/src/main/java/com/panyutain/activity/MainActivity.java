package com.panyutain.activity;

import java.util.ArrayList;

import com.example.panyutianmusicplayer.R;
import com.panyutian.adapter.MyAdapter;
import com.panyutian.bean.Mydata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
private Context context;
Button btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPager pg=(ViewPager) findViewById(R.id.viewPager);
		
	    context=this;
	    final ArrayList<ImageView> list=Mydata.getPagerDate(context);
	   btn1=(Button) findViewById(R.id.but1);
	    pg.setAdapter(new MyAdapter(context, list));
	    pg.setOnPageChangeListener(new OnPageChangeListener() {
			
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
				if (arg0 == list.size()-1) {
			
					btn1.setVisibility(View.VISIBLE);
					
				
					jump();
				}else{
					btn1.setVisibility(View.INVISIBLE);
				}
			}
			
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	private void jump(){
		btn1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
					Intent intent  = new Intent(context, IndexPager.class);
					startActivity(intent);
			}
		});
	    }
}

