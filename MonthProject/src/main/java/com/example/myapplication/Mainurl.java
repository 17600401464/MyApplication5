package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Created by lenovo on 2017/8/8.
 */

public class Mainurl extends Activity {
    LinearLayout linearLayout;

    ProgressBar progressBar;
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.mainurl);
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        String name=intent.getStringExtra("url");
        init(name);
    }
    void init(String path){
        Log.d("积极急急急急急急急急", "init: ");
        linearLayout = (LinearLayout)findViewById(R.id.linn);
//    imageView = (ImageView) findViewById(R.id.imageView2);
//    textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        webView = (WebView)findViewById(R.id.webview);
        //给WebView设置属性
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//是否支持HTML中的JS
        webSettings.setSupportZoom(true);//设置是否支持缩放
        webSettings.setBuiltInZoomControls(true);//设置是否支持缩放工具
        webSettings.setUseWideViewPort(true);//设置是否支持任意缩放大小
        webView.requestFocus();//WebView主动获取焦点
        //设置WebView默认页面
        webView.loadUrl(path);
        //设置两个工具对象
        webView.setWebViewClient(new WebViewClient() {
            @Override//用来处理当前链接和子链接   true表示当前页面用WebView加载  false用默认浏览器
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl(request.getUrl().toString());
                return false;
            }
            @Override//监听当前页面开始加载
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                linearLayout.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                progressBar.setMax(100);
            }
            @Override//监听当前页面加载完毕
            public void onPageFinished(WebView view, String url) {
                linearLayout.setVisibility(View.GONE);
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override//锦亭网页加载的进度变化
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }

            @Override//接收当前加载网页的标题
            public void onReceivedTitle(WebView view, String title) {
                // textView.setText(title);
            }

            @Override//接收当前加载网页的图标
            public void onReceivedIcon(WebView view, Bitmap icon) {
                // imageView.setImageBitmap(icon);
            }

            @Override//处理JS对话框
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
    }

}
