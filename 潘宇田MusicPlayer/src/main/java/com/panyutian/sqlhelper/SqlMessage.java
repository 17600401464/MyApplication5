package com.panyutian.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlMessage extends SQLiteOpenHelper{
public SQLiteDatabase db=getWritableDatabase();
	public SqlMessage(Context context) {
		super(context, "kwmusic.db", null, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	String sql="create table message(id integer primary key autoincrement,name text,pwd text)";
	String sql2="create table loginmessage(id integer primary key autoincrement,name text,pwd text)";
	String sql3="create table love(id integer primary key autoincrement,title text,duration text)";
	String sql4="create table like(id integer primary key autoincrement,title text,duration text)";
	db.execSQL(sql3);
	db.execSQL(sql2);
	db.execSQL(sql4);
	
		db.execSQL(sql);
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
