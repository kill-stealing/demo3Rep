package com.ibm.demo.test;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCalenderDemo {

	public static void main(String[] args) {
		System.out.println("请输入日期：（年月日，格式：2008-9-20）");
		Scanner scanner=new Scanner(System.in);
		String inputString=scanner.next();
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		/*
		int j=0;
		for (int i = 1; i <= 31; i++) {
			System.out.print(i+"\t");
			j++;
			if(j%7==0){
				System.out.println();
			}
		}*/
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d=dateFormat.parse(inputString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar c=new GregorianCalendar();
		c.setTime(d);
		
		int daysss=c.get(Calendar.DATE);
		
		c.set(Calendar.DATE,1);
		int dayOfWeek=c.get(Calendar.DAY_OF_WEEK);
		int days=c.getActualMaximum(Calendar.DATE);
		int dayString=c.get(Calendar.DAY_OF_MONTH);
		int j=dayOfWeek-1;
		for(int n=1;n<dayOfWeek;n++){
			System.out.print(" \t");
		}
		for (int i = 1; i <= days; i++) {
			if(i==daysss){
				System.out.print(i+"*\t");
			}else{
				System.out.print(i+"\t");
			}
			j++;
			if(j%7==0){
				System.out.println();
			}
		}
		
		File file=new File("C:/aa/bb/cc");
		file.mkdirs();
	}

}
