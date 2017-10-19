package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.button)
    Button bt1;
    Callback.Cancelable cancelable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);


    }
    @Event(type = View.OnClickListener.class,value = R.id.button)
    private void ClickListener(View v){
        String url = "http://v.juhe.cn/toutiao/index";


        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("type","");
        params.addQueryStringParameter("key","2ca3a5b1cb6edf55250bff550ac34325");
        //NetWorkonMainThread
        cancelable = x.http().get(params ,new Callback.CommonCallback<String>(){
            @Override
            public void onSuccess(String result) {
                Log.d("data",result);
                Log.d("data","1");

            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("data","3");
            }

            @Override
            public void onFinished() {
                bt1.setText("获取结束");
                Log.d("data","2");
            }
        });
    }

}
