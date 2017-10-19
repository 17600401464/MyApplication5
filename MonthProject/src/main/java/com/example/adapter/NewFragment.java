package com.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by lenovo on 2017/10/15.
 */

public class NewFragment extends  RecyclerView.Adapter<NewFragment.ViewHolder>{
    Beanone newsBean;
    Context activity;
    Beanone beanone;

    public NewFragment(Context activity, Beanone beanone) {
        this.activity = activity;
        this.beanone = beanone;
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(activity,R.layout.fragmentonechild,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.play1name.setText(newsBean.getResult().getList().get(1).getTr().get(position).getPlayer1());
        holder.play2name.setText(newsBean.getResult().getList().get(1).getTr().get(position).getPlayer2());
       //
        ImageLoader.getInstance().displayImage(
                newsBean.getResult().getList().get(1).getTr().get(position).getPlayer1logobig()
                ,holder.play1);
        ImageLoader.getInstance().displayImage(
                newsBean.getResult().getList().get(1).getTr().get(position).getPlayer2logobig()
                ,holder.play2);
        holder.score.setText(newsBean.getResult().getList().get(1).getTr().get(position).getScore());
        holder.music.setText("视频直播");
    }


    @Override
    public int getItemCount() {
        if(newsBean == null||newsBean.getResult()==null){
            return 0;
        }

        return newsBean.getResult().getList().get(1).getTr().size();
    }
    static class  ViewHolder extends RecyclerView.ViewHolder{
       public ImageView play1,play2;
        public TextView score,play2name,play1name,music;
        public ViewHolder(View view){
            super(view);
            play1 = view.findViewById(R.id.play1);
            play2 = view.findViewById(R.id.play2);
            score = view.findViewById(R.id.score);
            play1name = view.findViewById(R.id.play1name);
            play2name = view.findViewById(R.id.play2name);
            music=view.findViewById(R.id.music);

        }
    }
    public void updateAdapter(Beanone newsBean){
        this.newsBean = newsBean;
        notifyDataSetChanged();
        Log.d("ddd","刷新  刷新");
    }
}
