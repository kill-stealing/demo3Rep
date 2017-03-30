package com.ibm.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDataType {
	public static void main(String[] args) {
		byte b=127;
		float a=5.66F;
		double c=2.13221321312312321321321321;
		float aa=0.1f;
		double cc=1.0/10;
		System.out.println(aa==cc);
		
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
		Date date=new Date();
		String aString=sp.format(date);
		System.out.println(aString);
		
		//1479109487006
		//1479109495937
		String aa1="2015-12-1 12:22:43";
		try {
			date=sp.parse(aa1);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long t=System.currentTimeMillis();
		System.out.println(t);
	}
}
