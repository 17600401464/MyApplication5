package com.panyutain.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.beicai.lib.SlidingMenu;
import com.beicai.utils.TimeChangeUtil;
import com.example.panyutianmusicplayer.R;
import com.panyutian.fragment.Fragmentload;
import com.panyutian.fragment.Fragmentlove;

public class Songactivity extends Activity {
	FragmentManager fm;
	FragmentTransaction ft;
	SlidingMenu menu;
	Fragmentload load;
	boolean isTouch = false;//标记用户是否开始滑动SeekBar
    int time = 0;//统计当前歌曲播放的时间进度
	Fragmentlove love;
	String mode[] = {"列表循环","随机模式","单曲循环"};
	int index=0;
	SeekBar sk;
	 TextView txTitle,txDuration,txNow;
	 
	 Handler hand = new Handler(){
	    	public void handleMessage(Message msg) {
	    		if(msg.what == 0x111){
	    			  
	    			if(!isTouch){//当用户没有手动滑动时 通知系统更新SeekBar
	    				hand.sendEmptyMessage(0x112);
	    			}
	    			hand.postDelayed(t, 50);
	    		}
	    		
	    		if(msg.what == 0x112){//系统更新SeekBar
	    			sk.setProgress(time);
	    			
	    		}
	    	};
	    };
	    Thread t = new Thread(){
	    	public void run(){
	    		hand.sendEmptyMessage(0x111);
	    	}
	    };
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
				fm = getFragmentManager();
		ft = fm.beginTransaction();
		load=new Fragmentload();
		love=new Fragmentlove();
		ft.add(R.id.lin, load);
		ft.add(R.id.lin, love);
		ft.show(load);
		ft.hide(love);
		ft.commit();
		Button btn1=(Button) findViewById(R.id.bt_musiclist);
		Button btn2=(Button) findViewById(R.id.bt_musicrecord);
		txTitle = (TextView) findViewById(R.id.text_activity_title);
		txDuration = (TextView) findViewById(R.id.text_activity_duration);
		txNow = (TextView) findViewById(R.id.tx_now);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ft = fm.beginTransaction();
				ft.show(load);
				ft.hide(love);
				ft.commit();
				
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ft = fm.beginTransaction();
				ft.show(love);
				ft.hide(load);
				ft.commit();
				Toast.makeText(getApplicationContext(), "我们", 1).show();
			}
		});
		
		final Button btMode=(Button) findViewById(R.id.bt_mode);
		btMode.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(btMode.getText().toString().equals("列表循环")){
					index = 1;
					btMode.setText(mode[index]);
				}else if(btMode.getText().toString().equals("随机模式")){
					index = 2;
					btMode.setText(mode[index]);
				}else if(btMode.getText().toString().equals("单曲循环")){
					index = 0;
					btMode.setText(mode[index]);
				}
			}
		});
		sk = (SeekBar) findViewById(R.id.seekBar1);
		sk.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				time = sk.getProgress();//获取当前进度
				media.seekTo(time);
				isTouch = false;
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				isTouch=true;
			}
			
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	
	 MediaPlayer media= new MediaPlayer();
	int frist = -1;
	ArrayList<HashMap<String, String>> lists;
	public void musicplay(ArrayList<HashMap<String, String>> list, int arg) {
		// TODO Auto-generated method stub
		this.lists=list;
		if (frist == -1) {
			try {
				media.setDataSource(list.get(arg).get("path"));
				media.prepare();
				media.start();
				hand.postDelayed(t, 50);
				changeController(arg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (arg != frist) {
				System.out.println("我们是好人");
				hand.removeCallbacks(t);
				media.stop();
				media.reset();
				try {
					media.setDataSource(list.get(arg).get("path"));
					media.prepare();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				media.start();
				hand.postDelayed(t, 50);
				changeController(arg);
				time = 0;//

			} else if (arg == frist) {
				if (media.isPlaying()) {// 判断当前是否处于播放状态
					media.pause();
					 hand.removeCallbacks(t);
				} else {
					media.start();
					 hand.postDelayed(t, 50);
				}
			}
		}

		this.frist = arg;

	}
	public void getDataFrom1To2(){
		love.getDatatoChangeUI();
	}
	
	public void changeController(int position){
		txTitle.setText(lists.get(position).get("title"));
		txDuration.setText(TimeChangeUtil.changeTime(lists.get(position).get("duration")));
		sk.setMax(Integer.parseInt(lists.get(position).get("duration")));
		sk.setProgress(0);
		txNow.setText("0:0");
	}
	
	
	
	
	
@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
	media.stop();
	media.release();
	
	hand.removeCallbacks(t);
}

}
