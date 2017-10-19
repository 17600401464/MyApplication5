package com.example.myasynchttp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

  Button bt1, bt2;
  TextView tx;
  ImageView ig;
  MyAsync myAsync;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }

  void init() {
    myAsync = MyAsync.instance(MainActivity.this);
    bt1 = (Button) findViewById(R.id.button);
    bt1.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
//        netWorkByAsyncHttp();
//        setPermissions();
        myAsync.storeData("我是cookie");
      }
    });
    bt2 = (Button) findViewById(R.id.button2);
    bt2.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
//        setPermissions();

//        myAsync.netWorkByJson(MainActivity.this,tx);
//        myAsync.netWorkDownFile(ig);
        myAsync.getDataByCookie(tx);
      }
    });
    tx = (TextView) findViewById(R.id.textView);
    ig = (ImageView) findViewById(R.id.imageView);
  }


  void netWorkByAsyncHttp(){
    //创建执行对象
    AsyncHttpClient client = new AsyncHttpClient();
    //get联网方式
    client.get(
        "http://v.juhe.cn/toutiao/index?type=&key=2ca3a5b1cb6edf55250bff550ac34325",
        new AsyncHttpResponseHandler() {
          @Override
          public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
              tx.setText("获取的数据："+new String(responseBody,0,responseBody.length));
          }

          @Override
          public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
              Throwable error) {

          }
        });
  }

  static final String[] PERMISSION = new String[]{
      Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
      Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
      Manifest.permission.INTERNET       //读取设备信息
  };
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
