package com.example.picassoandglide;

import static com.example.picassoandglide.R.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

  Button bt1, bt2;
  ImageView ig;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }
  void init(){
    bt1 = (Button) findViewById(R.id.button);
    bt1.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Picasso.with(MainActivity.this)
            .load("http://08.imgmini.eastday.com//mobile//20170925//20170925150134_77ae353e7f15f1fecc294dec794238b3_3_mwpm_03200403.jpg")
//            .resize(50,50)
            //设置圆角  结合resize方法使用
//            .centerCrop()
            //下载过程中  显示的等待图片
            .placeholder(mipmap.ic_launcher_round)
            //下载错误提示图片
            .error(mipmap.ic_launcher)
//            .transform()
            .into(ig);
      }
    });

    bt2 = (Button) findViewById(R.id.button2);
//    bt2.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        Glide.with(MainActivity.this)
//            .load("http://08.imgmini.eastday.com//mobile//20170925//20170925150134_77ae353e7f15f1fecc294dec794238b3_3_mwpm_03200403.jpg")
//            //素描效果暂时无法使用
//            //参考网址http://www.cnblogs.com/qianyukun/p/6867436.html
//
//            .bitmapTransform(new InvertFilterTransformation(MainActivity.this,Glide.get(MainActivity.this).getBitmapPool()))
//            .placeholder(mipmap.ic_launcher_round)
//            .error(drawable.logo)
//            .into(ig);
//      }
//    });
    ig = (ImageView) findViewById(R.id.imageView);
  }
}
