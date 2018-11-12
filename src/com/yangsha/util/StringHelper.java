package com.yangsha.util;

import java.util.Date;
import java.util.Random;

public class StringHelper {
	
	public static String getFileTempName(){
		  String val="";
		  
		  Date date=new Date();
		  Random rd=new Random();
		  int num=rd.nextInt(10000);
		  val=String.valueOf(date.getYear())+String.valueOf(date.getMonth())+String.valueOf(date.getDay())+date.getHours()+date.getMinutes()+date.getSeconds()+String.valueOf(num);
		  return val;
	}
}
