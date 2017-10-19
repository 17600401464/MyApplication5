package com.example.myokhttp;

import android.Manifest.permission;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Manifest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements OnClickListener{

  Button btGet, btPost, btDown;
  TextView textView;
  ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
    setPermissions();
  }
  void init(){
    btGet = (Button) findViewById(R.id.button);
    btGet.setOnClickListener(this);
    btPost = (Button) findViewById(R.id.button2);
    btPost.setOnClickListener(this);
    btDown = (Button) findViewById(R.id.button3);
    btDown.setOnClickListener(this);
    textView = (TextView) findViewById(R.id.textView);
    imageView = (ImageView) findViewById(R.id.imageView);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.button:
        new Thread(){
          public void run(){
            doGet();
          }
        }.start();

        break;
      case R.id.button2:
        new Thread(){
          public void run(){
//            doPost();
            doPostString();
          }

        }.start();
        break;
      case R.id.button3:
        doDown();
        break;
    }
  }

  public void doGet(){
    //第一步  创建OkHttpClient对象
    OkHttpClient okHttpClient = new OkHttpClient();
    //第二步  创建Request.Builder
    Request.Builder builder = new Request.Builder();
    //第三步  通过内部类Builder对象创建外部类Request对象
    Request request = builder.get()
        .url("http://v.juhe.cn/toutiao/index?type=&key=2ca3a5b1cb6edf55250bff550ac34325")
        .build();
    //第四步 创建执行对象Call
    Call call = okHttpClient.newCall(request);
    //第五步 执行联网  获取数据并处理

    //同步联网方式
//    try {
//      Response response = call.execute();
//      final String data = response.body().string();
//      runOnUiThread(new Thread(){
//        public void run(){
//          textView.setText(data);
//        }
//      });
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

    //异步联网方式
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
      final String data = response.body().string();
      runOnUiThread(new Thread(){
        public void run(){
          textView.setText("异步：\n"+data);
        }
      });
      }
    });

  }
  public void doPost(){
    //第一步 创建OkHttpClient对象
    OkHttpClient okHttpClient = new OkHttpClient();
    //第二步 创建封装请求参数的RequestBody对象
    FormBody.Builder builder = new FormBody.Builder();
    RequestBody requestBody = builder.add("type","")
        .add("key","2ca3a5b1cb6edf55250bff550ac34325").build();
    //第三步 创建Request对象
    Request.Builder builder1 = new Request.Builder();
    Request request = builder1.post(requestBody).url("http://v.juhe.cn/toutiao/index").build();
    //第四步 创建Call执行对象
    Call call = okHttpClient.newCall(request);
    //第五步   执行联网（同步）
    try {
      Response response = call.execute();
      final String data = response.body().string();
      runOnUiThread(new Thread(){
        public void run(){
          textView.setText(data);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void doPostString(){
    //相比较post，构造RequestBody的方法有变化
    OkHttpClient okHttpClient = new OkHttpClient();
    RequestBody requestBody = RequestBody.create(MediaType.parse("text/xml; charset=utf-8"),
            "");
    //3.构造Request
    Request.Builder builder = new Request.Builder();
    Request request = builder.post(requestBody).url("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getDatabaseInfo?").build();
    Call call = okHttpClient.newCall(request);
    try {
      Response response = call.execute();
      final String data = response.body().string();
      runOnUiThread(new Thread(){
        public void run(){
          textView.setText(data);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void doDown(){
    OkHttpClient okHttpClient = new OkHttpClient();
    Request.Builder builder = new Request.Builder();
    Request request = builder.get().url("http://08.imgmini.eastday.com//mobile//20170925//20170925150134_77ae353e7f15f1fecc294dec794238b3_3_mwpm_03200403.jpg")
        .build();
    Call call = okHttpClient.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }
      @Override
      public void onResponse(Call call, Response response) throws IOException {
        //下载文件
       //创建输入流对象 获取File内容
//        InputStream inputStream = response.body().byteStream();
//        File file = new File(Environment.getExternalStorageDirectory()+"/myimg.jpg");
//        FileOutputStream os = new FileOutputStream(file);
//        int length  = 0;
//        byte buffer[] = new byte[512];
//        while( ( length = inputStream.read(buffer) ) != -1 ){
//          os.write(buffer,0,length);
//          os.flush();
//        }
//        inputStream.close();
//        os.close();

        //显示从网络上读取的图片
        InputStream inputStream = response.body().byteStream();
        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        runOnUiThread(new Thread(){
          public void run(){
            imageView.setImageBitmap(bitmap);
          }
        });
      }
    });
  }

  //6.0以后要在代码中动态添加权限
  private void setPermissions() {
    if (ContextCompat.checkSelfPermission(MainActivity.this,
        permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//      Log.d("data", "权限申请");
      Toast.makeText(this, "申请权限", Toast.LENGTH_SHORT).show();
      //Android 6.0申请权限
      ActivityCompat.requestPermissions(this, new String[]{permission.WRITE_EXTERNAL_STORAGE}, 1);
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions,
      int[] grantResults) {
    if (requestCode == 1) {
      if (ContextCompat.checkSelfPermission(MainActivity.this,
          permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(this, "写入申请成功", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "写入申请失败", Toast.LENGTH_SHORT).show();
      }

    }
  }
}
