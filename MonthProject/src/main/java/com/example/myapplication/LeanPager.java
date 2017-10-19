package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/3.
 */

public class LeanPager extends Activity {
    ViewPager viewPager;
    Button btn1;
    ArrayList<ImageView> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leanpager);
        viewPager=findViewById(R.id.viewpager);
        btn1=findViewById(R.id.but1);
        int [] images = {R.mipmap.png4,R.mipmap.tupian2,R.mipmap.tupian3};
        for (int i=0;i<3;i++){
            ImageView img=new ImageView(LeanPager.this);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            img.setImageResource(images[i]);
            arrayList.add(img);
        }
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(arrayList.get(position));
                return arrayList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(arrayList.get(position));
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == arrayList.size()-1) {

                    btn1.setVisibility(View.VISIBLE);


                    jump();
                }else{
                    btn1.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void jump(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LeanPager.this,RegisterPager.class);
                startActivity(intent);
            }
        });
    }
}
