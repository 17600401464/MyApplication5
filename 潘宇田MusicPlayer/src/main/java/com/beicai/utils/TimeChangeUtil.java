package com.beicai.utils;

public class TimeChangeUtil {

	
	public static String changeTime(String data){
		//���ַ���ת���ɻ����������� ͨ�������������͵ķ�װ����ö�Ӧ��parseXXX()����
		long time = Long.parseLong(data);
		if(time >= (60 * 60 * 1000)){//ʱ����  1:1:10  3600000---3612345
			//  ����/  ������ӷ�ĸ�������� ���Ҳ������ û����������
			//������ӷ�ĸ��һ���Ǹ�������  ��ô���Ҳ�Ǹ�����
			int hour = (int) (  time / (60 * 60 * 1000) );
			int minute = (int) (time % (60 * 60 * 1000)  /  (60 * 1000)) ;
			int second = (int) (time % (60 * 1000)  / 1000);
			return hour+":"+minute+":"+second;
		}else if(time < (60 * 60 * 1000)  &&   time >=(60 * 1000)){//����  10:11
			int minute = (int) (time   /  (60 * 1000)) ;
			int second = (int) (time % (60 * 1000)  / 1000);
			return minute+":"+second;
		}else if(  time< (60 * 1000) && time >=1000 ){//��   3��
			int second = (int) (time / 1000);
			return second+"��";
		}
		return null;
	}
}
