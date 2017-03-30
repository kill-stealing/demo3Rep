package com.ibm.demo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class Test {
	

	/*public static void main(String[] args) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyyHH:mm");
		Date date=new Date();
		String strCell="6/23/2016           14:30";
		strCell = strCell.replaceAll("\\s+"," "); 
		try {
			strCell=strCell.replace(" ", "");
			date = sdf1.parse(strCell);
			System.out.println(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	
	public static void main(String[] args){
		Character  a ='a';
		Character  b ='啊';
		System.out.println(a.toString().getBytes().length);
		System.out.println(b.toString().getBytes().length);
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
	}
	
}
