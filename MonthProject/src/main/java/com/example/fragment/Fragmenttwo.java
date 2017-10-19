package com.example.fragment;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/4.
 */

public class Fragmenttwo extends Fragment {
    private float mCurrentCheckedRadioLeft;//当前被选中的RadioButton距离左侧的距离
    private HorizontalScrollView mHorizontalScrollView;//上面的水平滚动控件
    private RadioGroup myRadioGroup;
    private LinearLayout layout,titleLayout;
    FragmentManager fm;
    FragmentTransaction ft;
    ImageView mImageView;
    NewFragment newFragment;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view =View.inflate(getActivity(), R.layout.fragmenttwo,null);

        getTitleInfo();
        initGroup();
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        newFragment=new NewFragment();
        ft.add(R.id.content,newFragment);
        ft.show(newFragment);
        ft.commit();
        return view;
    }

    private List<Map<String, Object>> titleList = new ArrayList<Map<String,Object>>();
    private void getTitleInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", 0);
        map.put("title", "湖人");
        titleList.add(map);
        map = new HashMap<>();
        map.put("id", 1);
        map.put("title", "雷霆");
        titleList.add(map);

        map = new HashMap<>();
        map.put("id", 2);
        map.put("title", "骑士");
        titleList.add(map);

        map = new HashMap<>();
        map.put("id", 3);
        map.put("title", "勇士");
        titleList.add(map);

        map = new HashMap<>();
        map.put("id", 4);
        map.put("title", "公牛");
        titleList.add(map);

        map = new HashMap<>();
        map.put("id", 5);
        map.put("title", "凯尔特");
        titleList.add(map);

        map = new HashMap<>();
        map.put("id", 6);
        map.put("title", "热火");
        titleList.add(map);

        map = new HashMap<>();
        map.put("id", 7);
        map.put("title", "快船");
        titleList.add(map);

        map = new HashMap<>();
        map.put("id", 8);
        map.put("title", "火箭");
        titleList.add(map);
        map = new HashMap<>();
        map.put("id", 9);
        map.put("title", "小牛");
        titleList.add(map);
    }
    int _id = 1000;
    private void initGroup(){
        titleLayout =  view.findViewById(R.id.title_lay);
        layout =  view.findViewById(R.id.lay);

        //mImageView = new ImageView(this);

        mImageView = view.findViewById(R.id.img1);
        mHorizontalScrollView = view.findViewById(R.id.horizontalScrollView);


        myRadioGroup = new RadioGroup(getActivity());
        myRadioGroup.setLayoutParams( new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        myRadioGroup.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(myRadioGroup);
        for (int i = 0; i <titleList.size(); i++) {
            Map<String, Object> map = titleList.get(i);
            RadioButton radio = new RadioButton(getActivity());

            radio.setBackgroundResource(R.drawable.radiobtn_selector);
            radio.setButtonDrawable(android.R.color.transparent);
            LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
            radio.setLayoutParams(l);
            radio.setGravity(Gravity.CENTER);
            radio.setPadding(60, 15, 60, 15);
            radio.setId(_id+i);
            //radio.setPadding(left, top, right, bottom)
            radio.setText(map.get("title")+"");
            radio.setTextColor(Color.WHITE);
            radio.setTag(map);
            if (i == 0) {
                radio.setChecked(true);
                int itemWidth = (int) radio.getPaint().measureText(map.get("title")+"");
                mImageView.setLayoutParams(new  LinearLayout.LayoutParams(itemWidth+radio.getPaddingLeft()+radio.getPaddingRight(),4));
            }
            myRadioGroup.addView(radio);
        }
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case 1000:

                        new Thread(){
                            public void run(){
                                try {

                                    newFragment.getData("湖人");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        }.start();

                        break;
                    case 1001:
                        new Thread(){
                            public void run(){
                                try {


                                newFragment.getData("雷霆");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        }.start();
                        break;
                    case 1002:
                        new Thread(){
                            public void run(){
                                try {

                                newFragment.getData("骑士");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 1003:
                        new Thread(){
                            public void run(){
                                try {


                                newFragment.getData("勇士");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                }
                        }.start();
                        break;
                    case 1004:
                        new Thread(){
                            public void run(){
                                try {

                                newFragment.getData("公牛");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 1005:
                        new Thread(){
                            public void run(){
                                try {


                                newFragment.getData("凯尔特人");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 1006:
                        new Thread(){
                            public void run(){
                                try {
//                                    String ss = URLEncoder.encode("热火", "UTF-8");


                                newFragment.getData("热火");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 1007:
                        new Thread(){
                            public void run(){
                                try {
//                                    String ss = URLEncoder.encode("快船", "UTF-8");

                                newFragment.getData("快船");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 1008:
                        new Thread(){
                            public void run(){
                                try {
//                                    String ss = URLEncoder.encode("火箭", "UTF-8");

                                newFragment.getData("火箭");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                    case 1009:
                        new Thread(){
                            public void run(){
                                try {
//                                    String ss = URLEncoder.encode("小牛", "UTF-8");

                                newFragment.getData("小牛");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        break;
                }
                //Map<String, Object> map = (Map<String, Object>) group.getChildAt(checkedId).getTag();
                int radioButtonId = group.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = view.findViewById(radioButtonId);

                AnimationSet animationSet = new AnimationSet(true);
                TranslateAnimation translateAnimation;
                translateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, rb.getLeft(), 0f, 0f);
                animationSet.addAnimation(translateAnimation);
                animationSet.setFillBefore(true);
                animationSet.setFillAfter(true);
                animationSet.setDuration(300);

                mImageView.startAnimation(animationSet);//开始上面蓝色横条图片的动画切换
                mCurrentCheckedRadioLeft = rb.getLeft();//更新当前蓝色横条距离左边的距离
                mHorizontalScrollView.smoothScrollTo((int)mCurrentCheckedRadioLeft-(int)getResources().getDimension(R.dimen.rdo2), 0);

                mImageView.setLayoutParams(new  LinearLayout.LayoutParams(rb.getRight()-rb.getLeft(),4));

            }
        });
   }
}
