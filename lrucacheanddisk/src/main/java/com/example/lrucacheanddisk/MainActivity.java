package com.example.lrucacheanddisk;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

import android.Manifest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.jakewharton.disklrucache.DiskLruCache;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

  Button bt;
  ImageView ig;
  LruCache<String,Bitmap> lruCache;
  DiskLruCache disk;
  DiskLruCache.Editor editor = null;
  DiskLruCache.Snapshot shot = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }

  void init() {
    int size = (int) (Runtime.getRuntime().maxMemory()/10);
    lruCache = new LruCache<String,Bitmap>(size){
      @Override
      protected int sizeOf(String key, Bitmap value) {
        return value.getByteCount();
      }
    };
    try {
      PackageManager manager = getPackageManager();
      PackageInfo info = manager.getPackageInfo(getPackageName(),0);
      int version = info.versionCode;
      //根据应用版本号设定缓存 弊端  当应用升级后 之前的缓存被清空
      disk = DiskLruCache.open(getExternalCacheDir(),version,1,1024*1024*10);

    } catch (Exception e) {
      e.printStackTrace();
    }
    bt = (Button) findViewById(R.id.button);
    setPermissions();
    bt.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {

//        Bitmap bitmap = lruCache.get("1");
//        if(bitmap!=null){
//          //直接显示缓存的图片
//          ig.setImageBitmap(bitmap);
//          Toast.makeText(MainActivity.this, "缓存的图片", Toast.LENGTH_SHORT).show();
//        }else{//没有缓存 联网获取图片
//          getImageFromNet();
//        }

        if(getImageFromDisk()){//如果缓存的数据不存在  shot在获取时为空
          Toast.makeText(MainActivity.this, "开始读取缓存", Toast.LENGTH_SHORT).show();
          //直接显示缓存的图片
          ig.setImageBitmap(BitmapFactory.decodeStream(shot.getInputStream(0)));

        }else{//没有缓存 联网获取图片
          Toast.makeText(MainActivity.this, "shot为null", Toast.LENGTH_SHORT).show();
          downImageToDisk();
        }
      }
    });
    ig = (ImageView) findViewById(R.id.imageView);
  }


  void getImageFromNet() {
    new Thread() {
      public void run() {
        try {
          URL url = new URL(
              "http://07.imgmini.eastday.com/mobile/20171011/20171011083247_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg");
          final HttpURLConnection con = (HttpURLConnection) url.openConnection();
          con.setRequestMethod("GET");
          con.setReadTimeout(10000);
          con.setConnectTimeout(10000);
          con.connect();
          if (con.getResponseCode() == 200) {
            final InputStream inputStream = con.getInputStream();
            final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            runOnUiThread(new Thread() {
              public void run() {
                try {
                  ig.setImageBitmap(bitmap);
                  //添加至缓存
                  lruCache.put("1",bitmap);
                  Toast.makeText(MainActivity.this, "联网下载图片", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                  e.printStackTrace();
                }
              }
            });
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }.start();
  }


  void downImageToDisk(){
    new Thread() {
      public void run() {
        try {
          URL url = new URL(
              "http://07.imgmini.eastday.com/mobile/20171011/20171011083247_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg");
          final HttpURLConnection con = (HttpURLConnection) url.openConnection();
          con.setRequestMethod("GET");
          con.setReadTimeout(10000);
          con.setConnectTimeout(10000);
          con.connect();
          if (con.getResponseCode() == 200) {
            //写入工具
            editor = disk.edit("url");
            OutputStream os = editor.newOutputStream(0);
            InputStream is = con.getInputStream();
            byte buffer[] = new byte[512];
            int length = 0;
            while((length = is.read(buffer))!=-1){
              os.write(buffer,0,length);
              Log.d("data","数据写入");
              os.flush();
            }
            os.close();
            editor.commit();
            is.close();
            shot = disk.get("url");
            final Bitmap bitmap = BitmapFactory.decodeStream(shot.getInputStream(0));
            runOnUiThread(new Thread(){
              @Override
              public void run() {
                ig.setImageBitmap(bitmap);
                Toast.makeText(MainActivity.this, "Disk网络加载图片", Toast.LENGTH_SHORT).show();
              }
            });
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }.start();
  }
  boolean getImageFromDisk(){
    try {
      shot = disk.get("url");
      if(shot == null){
        return false;
      }else{
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
  static final String[] PERMISSION = new String[]{
      Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
      Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
      Manifest.permission.INTERNET       //读取设备信息
  };

  //6.0以后要在代码中动态添加权限
  private void setPermissions() {
    if (ContextCompat.checkSelfPermission(MainActivity.this,
        PERMISSION[0]) != PackageManager.PERMISSION_GRANTED) {
      Log.d("data", "权限申请");
      Toast.makeText(this, "申请权限", Toast.LENGTH_SHORT).show();
      //Android 6.0申请权限
      ActivityCompat.requestPermissions(this, PERMISSION, 1);
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions,
      int[] grantResults) {
    if (requestCode == 1) {
      if (ContextCompat.checkSelfPermission(MainActivity.this,
          PERMISSION[0]) == PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(this, "写入申请成功", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "写入申请失败", Toast.LENGTH_SHORT).show();
      }
      if (ContextCompat.checkSelfPermission(MainActivity.this,
          PERMISSION[1]) == PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(this, "读取申请成功", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "读取申请失败", Toast.LENGTH_SHORT).show();
      }
      if (ContextCompat.checkSelfPermission(MainActivity.this,
          PERMISSION[2]) == PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(this, "联网申请成功", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "联网申请失败", Toast.LENGTH_SHORT).show();
      }
    }
  }



}
