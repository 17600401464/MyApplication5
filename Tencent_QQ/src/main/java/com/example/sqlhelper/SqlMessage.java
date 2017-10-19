package com.example.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlMessage extends SQLiteOpenHelper{
public SQLiteDatabase db=getWritableDatabase();
	public SqlMessage(Context context) {
		super(context, "tencentqq.db", null,1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		//登录信息
	String sql="create table loginmessage(id integer primary key autoincrement,name text,pwd text)";
		//好友信息
		String sql2="create table frientmessage(id integer primary key autoincrement,name text,img text)";
//	String sql3="create table love(id integer primary key autoincrement,title text,duration text)";
//	String sql4="create table like(id integer primary key autoincrement,title text,duration text)";
	//db.execSQL(sql3);
	db.execSQL(sql2);
	//db.execSQL(sql4);
	
		db.execSQL(sql);
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
