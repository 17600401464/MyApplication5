package com.example.myimageloader;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.File;

public class MainActivity extends AppCompatActivity {

  Button bt;
  ImageView ig;
  ImageLoaderConfiguration configuration ;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }
  void init(){
    File file = new File(Environment.getExternalStorageDirectory()+"/mapp");
    //设置下载属性
    configuration = new ImageLoaderConfiguration.Builder(MainActivity.this)
        .diskCache(new UnlimitedDiskCache(file))
        .diskCacheSize(50 * 1024 * 1024) // 50 Mb sd卡(本地)缓存的最大值
        .diskCacheFileCount(100)  // 可以缓存的文件数量
        .build();
    //将属性传递给ImageLoader
    ImageLoader.getInstance().init(configuration);
    bt = (Button) findViewById(R.id.button);
    bt.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.log)
            .displayer(new RoundedBitmapDisplayer(30))
            .build();
        ImageLoader.getInstance().displayImage("http://07.imgmini.eastday.com/mobile/20171011/20171011083247_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg"
        ,ig,displayImageOptions);
      }
    });
    ig = (ImageView) findViewById(R.id.imageView);
  }
}
