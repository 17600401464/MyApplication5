package com.example.adapter;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;


import com.example.bean.Beanone;
import com.example.bean.Beantwo;
import com.example.fragment.NewFragment;
import com.example.myapplication.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by lenovo on 2017/9/7.
 */

public class Sideadapter extends BaseAdapter {
    Context de;
    Beanone di;
    public Sideadapter(Context com,Beanone beanon) {
        this.de=com;
        this.di=beanon;
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.ic_launcher)// 加载开始默认的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)     //url爲空會显示该图片，自己放在drawable里面的
                .showImageOnFail(R.mipmap.ic_launcher)                //加载图片出现问题，会显示该图片
                .cacheInMemory()                                               //缓存用
                .cacheOnDisc()                                                  //缓存用
                .displayer(new RoundedBitmapDisplayer(10))       //图片圆角显示，值为整数
                .build();

        ImageLoaderConfiguration config2 = new ImageLoaderConfiguration.Builder(com)
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
        if(di==null){
            return 0;
        }
        log.e("巍峨我感觉饿噶人呢啊让你备案及嗯呢办举办额济纳骄傲而你呢",di.toString());
        return di.getResult().getTeammatch().size();


    }

    @Override
    public Object getItem(int position) {
        return di.getResult().getTeammatch().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if(convertView==null){
            vh=new ViewHolder();
            //加载布局
            convertView= LayoutInflater.from(de).inflate(R.layout.item_custom_btne,null);
            //初始化控件
            vh.imgLogo=(ImageView) convertView.findViewById(R.id.img);
            vh.txtName=(TextView)convertView.findViewById(R.id.name);
            vh.btnClick=(TextView) convertView.findViewById(R.id.timee);

            //设置按钮点击监听
//            vh.btnClick.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Object o=v.getTag();
//
//                    if(o instanceof  Integer){
//                        Toast.makeText(de,"点击按钮"+((Integer)o),Toast.LENGTH_LONG).show();
//                    }
//                }
//            });

            convertView.setTag(vh);
        }else{
            vh=(ViewHolder)convertView.getTag();
        }

        //得到每一行的app相关信息
//        ApplicationInfo item=(ApplicationInfo)this.getItem(position);

        //设置控件
        vh.txtName.setText(di.getResult().getTeammatch().get(position).getName());
//        NewFragment newFragment=new NewFragment();
//        String ss=newFragment.getdate("huren").toString();
//        Log.d("eawgrwgargarg",ss);
        vh.imgLogo.setImageResource(R.drawable.qq);
        vh.btnClick.setText(position+"");

        return convertView;

    }
    public void updateAdapter(Beanone newsBean){
        this.di = newsBean;
        notifyDataSetChanged();
        Log.d("ddd","刷新  刷新");
    }
    private class ViewHolder{

        public ImageView imgLogo;
        public TextView txtName;
        public TextView btnClick;
    }

}
