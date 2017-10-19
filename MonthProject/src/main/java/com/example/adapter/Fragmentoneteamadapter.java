package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bean.Beanone;
import com.example.bean.Beantwo;
import com.example.fragment.Fragmentone;
import com.example.myapplication.Mainurl;
import com.example.myapplication.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;



/**
 * Created by lenovo on 2017/8/4.
 */

public class Fragmentoneteamadapter extends BaseAdapter {
    Context activity;
    Beanone beanone;
    Beantwo beantwo;
    String ss;

Fragmentone fragmentone;
    public Fragmentoneteamadapter(Context activity, Beanone beanone, Beantwo beantwo) {
        this.activity = activity;
        this.beanone = beanone;
this.beantwo=beantwo;
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.ic_launcher)// 加载开始默认的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)     //url爲空會显示该图片，自己放在drawable里面的
                .showImageOnFail(R.mipmap.ic_launcher)                //加载图片出现问题，会显示该图片
                .cacheInMemory()                                               //缓存用
                .cacheOnDisc()                                                  //缓存用
                .displayer(new RoundedBitmapDisplayer(10))       //图片圆角显示，值为整数
                .build();

        ImageLoaderConfiguration config2 = new ImageLoaderConfiguration.Builder(activity)
                .defaultDisplayImageOptions(options)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .enableLogging() //  1.8.6,把这句删除
                .build();
        ImageLoader.getInstance().init(config2);
    }

    @Override
    public int getCount() {
        if(beanone == null||beanone.getResult()==null){

            return 0;

        }
        return beanone.getResult().getTeammatch().size();
    }

    @Override
    public Object getItem(int i) {

        return beanone.getResult().getTeammatch().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
int ii;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
this.ii=i;
        final HolderView holder;
        if (view == null) {
            view = View.inflate(activity, R.layout.fragmentoneteamchild, null);
            holder = new HolderView();
            holder.team = view.findViewById(R.id.team);
            holder.teamimg = view.findViewById(R.id.teamimg);
            holder.teamshi=view.findViewById(R.id.tx);
            view.setTag(holder);
        } else {
            holder = (HolderView) view.getTag();
        }

        holder.team.setText(beanone.getResult().getTeammatch().get(i).getName());

        try {
             ss=URLEncoder.encode(holder.team.getText().toString(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        fragmentone=new Fragmentone();
        String sss="http://op.juhe.cn/onebox/basketball/team?dtype=&team="+ss+"&key=2879274f89775de8809e836220c8eff4";

        //Toast.makeText(activity,sss,Toast.LENGTH_LONG).show();
       // fragmentone.getteamid(ss,beanone);

//        if(beantwo!=null) {
//
//            ImageLoader.getInstance().displayImage(
//                    beantwo.getResult().getList().get(2).getPlayer2logo()
//                    , holder.teamimg);
//        }else{

            holder.teamimg.setBackgroundResource(R.mipmap.ic_launcher);
//        }


        return view;
    }

    class HolderView {
        private TextView team;
        private ImageView teamimg;
        private TextView teamshi;
    }

    public void updateAdapter(Beantwo newsBean, Beanone beanone){
        this.beantwo = newsBean;
        this.beanone=beanone;
        notifyDataSetChanged();

    }
    public void updateAdaptertwo(Beantwo newsBean){
        this.beantwo = newsBean;
        //this.beanone=beanone;
        notifyDataSetChanged();

    }


}
