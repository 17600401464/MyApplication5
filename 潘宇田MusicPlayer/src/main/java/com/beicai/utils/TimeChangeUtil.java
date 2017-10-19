package com.beicai.utils;

public class TimeChangeUtil {

	
	public static String changeTime(String data){
		//把字符串转换成基本数据类型 通过基本数据类型的封装类调用对应的parseXXX()方法
		long time = Long.parseLong(data);
		if(time >= (60 * 60 * 1000)){//时分秒  1:1:10  3600000---3612345
			//  除号/  如果分子分母都是整数 结果也是整数 没有四舍五入
			//如果分子分母有一个是浮点型数  那么结果也是浮点型
			int hour = (int) (  time / (60 * 60 * 1000) );
			int minute = (int) (time % (60 * 60 * 1000)  /  (60 * 1000)) ;
			int second = (int) (time % (60 * 1000)  / 1000);
			return hour+":"+minute+":"+second;
		}else if(time < (60 * 60 * 1000)  &&   time >=(60 * 1000)){//分秒  10:11
			int minute = (int) (time   /  (60 * 1000)) ;
			int second = (int) (time % (60 * 1000)  / 1000);
			return minute+":"+second;
		}else if(  time< (60 * 1000) && time >=1000 ){//秒   3秒
			int second = (int) (time / 1000);
			return second+"秒";
		}
		return null;
	}
}
