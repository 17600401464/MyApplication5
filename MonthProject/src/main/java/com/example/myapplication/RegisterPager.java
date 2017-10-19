package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by lenovo on 2017/8/3.
 */
@ContentView(R.layout.registerpager)
public class RegisterPager extends Activity {
    EditText names,pwds;
    Button zuce;
    @ViewInject(R.id.zuce)

    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);


        names=(EditText) findViewById(R.id.zname);
        pwds=(EditText) findViewById(R.id.zpwd);

        zuce=findViewById(R.id.zuce);
            login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterPager.this,LoginPager.class);
                startActivity(intent);
            }
        });

    }
    @Event(type = View.OnClickListener.class,value = R.id.zuce)
    private void MyonClickListener(View v){
        sharedPreferences = getSharedPreferences("1611",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("name",names.getText().toString());
        editor.putString("pwd",pwds.getText().toString());
        editor.commit();
        Intent intent=new Intent(RegisterPager.this,LoginPager.class);
        startActivity(intent);
    }
}
