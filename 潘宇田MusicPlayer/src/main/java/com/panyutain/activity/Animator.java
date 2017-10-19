package com.panyutain.activity;

import com.example.panyutianmusicplayer.R;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import com.panyutian.sqldao.Message;
public class Animator extends Activity{
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
	Handler hand=new Handler();
	hand.postDelayed(new Thread(){
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			Message me=new Message(getApplicationContext());
			if (me.loginselect() == null) {
				
				Intent intent=new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);

			} else {
				Intent intent=new Intent(getApplicationContext(), IndexPager.class);
				startActivity(intent);
			}
			
		}
	}, 3000);
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.animator);
	ImageView img=(ImageView) findViewById(R.id.an);
	AnimationSet loadAnimation = (AnimationSet) AnimationUtils.loadAnimation(getApplicationContext(), R.anim.antor);
	img.startAnimation(loadAnimation);
}

}
