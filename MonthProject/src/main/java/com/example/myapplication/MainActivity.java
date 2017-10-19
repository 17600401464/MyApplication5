package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class     MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout= (RelativeLayout) findViewById(R.id.bolang);
        relativeLayout.addView(new MySurfaceView(MainActivity.this));
        ImageView imageView= (ImageView) findViewById(R.id.an);
        AnimationSet loadAnimation = (AnimationSet) AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        imageView.startAnimation(loadAnimation);
        sharedPreferences = getSharedPreferences("1611",MODE_PRIVATE);
        new Thread(){
            public void run(){
                try {
                    sleep(4000);
                    if(sharedPreferences.getBoolean("isRun",false)){//true代表运行过
                        Intent i = new Intent(MainActivity.this,RegisterPager.class);

                        startActivity(i);
                        finish();
                    }else{
                        editor = sharedPreferences.edit();
                        editor.putBoolean("isRun",true);
                        editor.commit();
                        Intent i = new Intent(MainActivity.this,LeanPager.class);
                        startActivity(i);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
