package com.panyutain.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.panyutianmusicplayer.R;
import com.panyutian.sqldao.Message;

public class RegisterPager extends Activity{
	EditText names,pwds;
	Button lo;
	String zname, zpwd;
	Message me;
	//protected void onCreate(android.os.Bundle savedInstanceState) {};
	//setContentView(R.layout.loginlayout);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.registerlayout);
		names=(EditText) findViewById(R.id.zname);
		pwds=(EditText) findViewById(R.id.zpwd);
		
		lo=(Button) findViewById(R.id.zlogin);
		lo.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				me=new Message(getApplicationContext());
				//Toast.makeText(getApplicationContext(), +"", 1).show();
				me.insert(names.getText().toString(), pwds.getText().toString());
				Intent intent=new Intent(RegisterPager.this, LoginPager.class);
				startActivity(intent);
			}
		});
		
		super.onCreate(savedInstanceState);
	}
}
