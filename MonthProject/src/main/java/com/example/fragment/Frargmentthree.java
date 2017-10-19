package com.example.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Created by lenovo on 2017/8/4.
 */

public class Frargmentthree extends Fragment {
    FragmentManager fm;
    FragmentTransaction ft;
    Fragmentthreeone fragmentthreeone;
    Fragmentthreetwo fragmentthreetwo;
    Fragmentthreethree fragmentthreethree;
    Button btn1;
    Button btn2;
    Button btn3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragmentthree,null);
        fragmentthreeone=new Fragmentthreeone();
        fragmentthreetwo=new Fragmentthreetwo();
        fragmentthreethree=new Fragmentthreethree();
        btn1=view.findViewById(R.id.button1);
        btn2=view.findViewById(R.id.button2);
        btn3=view.findViewById(R.id.button3);
        fm=getFragmentManager();
        ft=fm.beginTransaction();
        ft.add(R.id.liner,fragmentthreeone);
        ft.add(R.id.liner,fragmentthreetwo);
        ft.add(R.id.liner,fragmentthreethree);

        ft.show(fragmentthreeone);
ft.hide(fragmentthreetwo);
        ft.hide(fragmentthreethree);
        ft.commit();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // fragmentthreeone.init("http://nba.sports.sina.com.cn/league_order1.php?dpc=1");
                ft=fm.beginTransaction();
                ft.show(fragmentthreeone);
                ft.hide(fragmentthreetwo);
                ft.hide(fragmentthreethree);
                ft.commit();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentthreeone.init("http://nba.sports.sina.com.cn/players.php?dpc=1");
                ft=fm.beginTransaction();
                ft.hide(fragmentthreeone);
                ft.show(fragmentthreetwo);
                ft.hide(fragmentthreethree);
                ft.commit();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentthreeone.init("http://nba.sports.sina.com.cn/match_result.php?dpc=1");
                ft=fm.beginTransaction();
                ft.hide(fragmentthreeone);
                ft.hide(fragmentthreetwo);
                ft.show(fragmentthreethree);
                ft.commit();

            }
        });
        return view;
    }
}
