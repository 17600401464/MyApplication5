package com.example.myasynchttp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.cookie.BasicClientCookie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by wangye on 2017/10/10.
 */

public class MyAsync {
  //单例模式   此对象在内存中只允许存在一个
  public  static MyAsync myAsync = null;
  private static AsyncHttpClient client = null;
  private static PersistentCookieStore cookieStore;
  public  static  MyAsync instance(Context c){
    if(myAsync == null){
      myAsync = new MyAsync();
      client = new AsyncHttpClient();
      cookieStore = new PersistentCookieStore(c);
    }
    return  myAsync;
  }
  private MyAsync(){

  }

  public void netWorkByPost(Context context,  TextView tx){
    final TextView textView = tx;
    RequestParams params = new RequestParams();
    params.put("key","2ca3a5b1cb6edf55250bff550ac34325");
    params.put("type","");
    client.post(context, "http://v.juhe.cn/toutiao/index", params, new TextHttpResponseHandler() {
      @Override
      public void onFailure(int statusCode, Header[] headers, String responseString,
          Throwable throwable) {
      }
      @Override
      public void onSuccess(int statusCode, Header[] headers, String responseString) {
        textView.setText("post接收的数据："+responseString);
      }
    });
  }

  public void netWorkByJson(Context context,TextView tx){
    final TextView textView = tx;
    try {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("key","2ca3a5b1cb6edf55250bff550ac34325");
      jsonObject.put("type","");
      StringEntity stringEntity = new StringEntity(jsonObject.toString());
      client.post(context, "http://v.juhe.cn/toutiao/index?type=&key=2ca3a5b1cb6edf55250bff550ac34325", null, "application/json",
          new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
              super.onSuccess(statusCode, headers, response);
              textView.setText(response.toString());
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void netWorkDownFile(ImageView imageView){
    final  ImageView ig = imageView;
    client.get(
        "http://02.imgmini.eastday.com//mobile//20171010//20171010_4e08c2bec2b27c8b80b6fbb5a6f0bdc4_mwpm_03200403.jpg"
        , new BinaryHttpResponseHandler() {
          @Override
          public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
            File file = new File(Environment.getExternalStorageDirectory()+"/my.jpeg");
//            File file = new File(Environment.getExternalStorageDirectory(),"my.jpeg");
            try {
              FileOutputStream fileOutputStream = new FileOutputStream(file);
              fileOutputStream.write(binaryData);
              fileOutputStream.flush();
              fileOutputStream.close();
              ig.setImageBitmap(BitmapFactory.decodeFile(String.valueOf(file)));
//              ig.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
            } catch (Exception e) {
              e.printStackTrace();
            }
          }

          @Override
          public void onFailure(int statusCode, Header[] headers, byte[] binaryData,
              Throwable error) {

          }
        });
  }


  public void storeData(String data){
    BasicClientCookie newCookie = new BasicClientCookie("name", "value");
    newCookie.setVersion(1);
    newCookie.setDomain(Environment.getExternalStorageDirectory().toString());
    newCookie.setValue(data);
    cookieStore.addCookie(newCookie);
  }
  public void getDataByCookie(TextView tx){
    final  TextView textView = tx;
    Cookie newCookie = cookieStore.getCookies().get(0);
    //字符串截取  subString()
    textView.setText("获取的cookie数据："+newCookie.getValue());
  }
}
