package com.panyutain.activity;

import com.example.panyutianmusicplayer.R;
import com.panyutian.sqldao.Message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPager extends Activity {
	EditText names,pwds;
	String name, pwd;
	Button lo ,zu;
	Message me;
	IndexPager id;


	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	setContentView(R.layout.loginlayout);
	names=(EditText) findViewById(R.id.name);
	pwds=(EditText) findViewById(R.id.pwd);
	lo=(Button) findViewById(R.id.login);
	zu=(Button) findViewById(R.id.zuce);
	id=new IndexPager();
	zu.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent =new Intent(getApplicationContext(), RegisterPager.class);
		startActivity(intent);
		}
	});
	lo.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			
			name=names.getText().toString();
			
			pwd=pwds.getText().toString();
			// TODO Auto-generated method stub
			me=new Message(getApplicationContext());
			Toast.makeText(getApplicationContext(), name, 1).show();
			boolean on=me.select(name);
			if(on==true){
				me.logininsert(name,pwd);
				Intent intent=new Intent(getApplicationContext(), IndexPager.class);
				startActivity(intent);
				
				
				
				
				
			}else {
				Toast.makeText(getApplicationContext(), "’À∫≈¥ÌŒÛ£¨«Î‘Ÿ¥Œ ‰»Î", 1).show();			}
		}
	});
	
	
	
	
	super.onCreate(savedInstanceState);
}
}
