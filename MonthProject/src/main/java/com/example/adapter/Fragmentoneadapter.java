package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.Beanone;
import com.example.myapplication.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by lenovo on 2017/8/4.
 */

public class Fragmentoneadapter extends BaseAdapter {
    Beanone newsBean;
    Context activity;
    Beanone beanone;


    public Fragmentoneadapter(Context activity, Beanone beanone) {
        this.activity = activity;
        this.beanone = beanone;
        DisplayImageOptions  options = new DisplayImageOptions.Builder()
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
        if(newsBean == null||newsBean.getResult()==null){
            return 0;
        }
        Log.e("积极改机改基尼急急急1",newsBean.getError_code()+"");
            return newsBean.getResult().getList().get(1).getTr().size();

    }

    @Override
    public Object getItem(int i) {
        return newsBean.getResult().getList().get(1).getTr().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      //  Log.d("ewagegwegaw", newsBean.getResult().getList().get(1).getTr().get(i).getPlayer1().toString()); ;
        final ViewHolder holder;
        if(view == null){
            view = View.inflate(activity,R.layout.fragmentonechild,null);
            holder = new ViewHolder();
            holder.play1 = view.findViewById(R.id.play1);
            holder.play2 = view.findViewById(R.id.play2);
            holder.score = view.findViewById(R.id.score);
            holder.play1name = view.findViewById(R.id.play1name);
            holder.play2name = view.findViewById(R.id.play2name);
            holder.music=view.findViewById(R.id.music);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.play1name.setText(newsBean.getResult().getList().get(1).getTr().get(i).getPlayer1());
        holder.play2name.setText(newsBean.getResult().getList().get(1).getTr().get(i).getPlayer2());
        holder.score.setText(newsBean.getResult().getList().get(1).getTr().get(i).getScore());
        holder.music.setText("视频直播");
        ImageLoader.getInstance().displayImage(
                newsBean.getResult().getList().get(1).getTr().get(i).getPlayer1logobig()
                ,holder.play1);
        ImageLoader.getInstance().displayImage(
                newsBean.getResult().getList().get(1).getTr().get(i).getPlayer2logobig()
                ,holder.play2);
        return view;
    }
    class ViewHolder{
        ImageView play1,play2;
        TextView score,play2name,play1name,music;


    }
    public void updateAdapter(Beanone newsBean){
        this.newsBean = newsBean;
        notifyDataSetChanged();
        Log.d("ddd","刷新  刷新");
    }
//     void getlistData(){
//         newsBean
//
//
//     }

}
