package com.panyutian.sqldao;

import java.util.ArrayList;
import java.util.HashMap;

import com.panyutian.sqlhelper.SqlMessage;

import android.content.Context;
import android.database.Cursor;

public class Message {
	Context con;
	SqlMessage sme;
	ArrayList<HashMap<String, String>> alist=new ArrayList<HashMap<String, String>>();
	HashMap<String, String> list=new HashMap<String, String>();
	public Message(Context context) {
	// TODO Auto-generated constructor stub
	this.con=context;
	sme=new SqlMessage(con);
}
public void insert(String name,String pwd) {
	// TODO Auto-generated method stub
String sql="insert into message(name,pwd) values (?,?)";
sme.db.execSQL(sql, new String []{name,pwd});
}
public boolean select(String name){
	String sql="select * from message where name=?";
	Cursor cu=sme.db.rawQuery(sql, new String[]{name});
	if(cu.getCount()!=0){
		return true;
	}else{
	return false;
	}
}
public void logininsert(String name,String pwd) {
	// TODO Auto-generated method stub
String sql="insert into loginmessage(name,pwd) values (?,?)";
sme.db.execSQL(sql, new String []{name,pwd});
}

public HashMap<String, String> loginselect(){
	String sql="select * from loginmessage";
	Cursor cu=sme.db.rawQuery(sql,null);
	cu.moveToPrevious();
	if(cu.getCount()!=0){
	while(cu.moveToNext()){
		String name=cu.getString(cu.getColumnIndex("name"));
		list.put("name",name);
	}
	return list;
	}else{
	return null;
	}
}
public void delect(String name){
	String sql="delete from  loginmessage where name=?";
	sme.db.execSQL(sql,new String[]{name});
}



public  void inserlt(String title,String duration) {
	// TODO Auto-generated method stub
	String sql="insert into love (title,duration) values (?,?)";
	sme.db.execSQL(sql, new Object[]{title,duration});

}
public boolean selectmusic(String title) {
	String sql="select * from love where title=?";
	Cursor cu=sme.db.rawQuery(sql, new String[]{title});
	if(cu.getCount()!=0){
		return false;
	}else {
	return true;
	}
	// TODO Auto-generated method stub
	
}
public ArrayList<HashMap<String, String>> select(){
	 ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String,String>>();
	String sql="select * from love";
	Cursor cu=sme.db.rawQuery(sql, null);
	cu.moveToPrevious();
	while(cu.moveToNext()){
	String title=cu.getString(cu.getColumnIndex("title"));
	String duration=cu.getString(cu.getColumnIndex("duration"));
	HashMap<String,String> li=new HashMap<String, String>();
	li.put("title", title);
	li.put("duration",duration);
	alist.add(li);
	}
	return alist;
}
public  void inserltlike(String title,String duration) {
	// TODO Auto-generated method stub
	String sql="insert into like (title,duration) values (?,?)";
	sme.db.execSQL(sql, new Object[]{title,duration});

}
public ArrayList<HashMap<String, String>> selectlike(){
	 ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String,String>>();
	String sql="select * from like";
	Cursor cu=sme.db.rawQuery(sql, null);
	cu.moveToPrevious();
	while(cu.moveToNext()){
	String title=cu.getString(cu.getColumnIndex("title"));
	String duration=cu.getString(cu.getColumnIndex("duration"));
	HashMap<String,String> li=new HashMap<String, String>();
	li.put("title", title);
	li.put("duration",duration);
	alist.add(li);
	}
	return alist;
}
}
