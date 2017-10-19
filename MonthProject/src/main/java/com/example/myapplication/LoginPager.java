package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by lenovo on 2017/8/3.
 */
@ContentView(R.layout.registerpager)
public class LoginPager extends Activity {
    EditText names,pwds;
    @ViewInject(R.id.login)

    Button login;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);


        names=(EditText) findViewById(R.id.zname);
        pwds=(EditText) findViewById(R.id.zpwd);
        Button zuce=findViewById(R.id.zuce);
        zuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginPager.this,RegisterPager.class);
                startActivity(intent);
            }
        });
        login=findViewById(R.id.login);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sharedPreferences=getSharedPreferences("1611",MODE_PRIVATE);
//               String anme=sharedPreferences.getString("name","账号错误");
//               String pwd=sharedPreferences.getString("pwd","密码错误");
//                if(names.getText().toString().equals(anme)&&pwds.getText().toString().equals(pwd)){
//                    Intent intent =new Intent(LoginPager.this,MyActivity.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(LoginPager.this,"密码或账号不存在"+pwd+pwds.getText().toString(),Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }
    @Event(type = View.OnClickListener.class,value = R.id.login)
    private void MyonClickListener(View v){
        sharedPreferences=getSharedPreferences("1611",MODE_PRIVATE);
               String anme=sharedPreferences.getString("name","账号错误");
               String pwd=sharedPreferences.getString("pwd","密码错误");
                if(names.getText().toString().equals(anme)&&pwds.getText().toString().equals(pwd)){
                    Intent intent =new Intent(LoginPager.this,MyActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginPager.this,"密码或账号不存在"+pwd+pwds.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }
    }

