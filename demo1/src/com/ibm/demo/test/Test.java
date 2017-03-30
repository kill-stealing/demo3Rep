package com.ibm.demo.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		
		Properties p=new Properties();
		try {
			p.load(Test.class.getResourceAsStream("/com/ibm/demo/test/demo/pro/db.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(p.getProperty("user","1111"));;
		Map map=new HashMap();
		map.put("gaoqi", new Wife("a1"));
		map.put("b1", new Wife("a2"));
		
		Set<Entry<String, Wife>> entries=map.entrySet();
		Iterator<Entry<String, Wife>> it1=entries.iterator();
		while(it1.hasNext()){
			Entry<String, Wife> e=it1.next();
			System.out.println(e.getKey()+"-->"+e.getValue().getName());
		}
		map.remove("gaoqi");
		Wife w=(Wife)map.get("gaoqi");
		System.out.println(map.get("gaoqi"));
		
		List list=new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		for(Iterator it2=list.iterator();it2.hasNext();){
			String str=(String)it2.next();
			System.out.println(str);
			if(str.equals("aaa")){
				it2.remove();
			}
		}
		
		System.out.println(list.size());
		System.out.println(Arrays.toString(list.toArray()));
		
		Set set=new HashSet();
		set.add("高1");
		set.add("高2");
		set.add("高3");
		set.add("高4");
		/*Iterator it=set.iterator();
		while(it.hasNext()){
			String str=(String)it.next();
			System.out.println(str);
		}*/
		
		for(Iterator it=set.iterator();it.hasNext();){
			String str=(String)it.next();
			System.out.println(str);
		}
		
		/*int[] a={1,2,3,4,5};
		int[] b={1,5,6,7,8,9};
		a=b;
		System.out.println(Arrays.toString(a));
		
		List<String> list=new ArrayList<String>(10);
		list.add(null);
		list.remove("dd");*/
		
        /*Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("EST"));   
	    String utcTime =simpleDateFormat.format(calendar.getTime());
	    try {
			Date d=simpleDateFormat.parse(utcTime);
			System.out.println("utcTime "+d);
			System.out.println("utcTime "+utcTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        /*Date d=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sf.setTimeZone(TimeZone.getTimeZone("EST"));
        String utfTime=sf.format(new Date());
	    System.out.println(utfTime);*/
        
//        System.out.println(DateTransformer.dateTransformBetweenTimeZone(date, formatter, srcTimeZone, destTimeZone));  
		
		
		/*String pa1="@test1:nihao ";
		String name=pa1.substring(1,pa1.indexOf(":"));
		String content=pa1.substring(pa1.indexOf(":")+1);
		System.out.println(name+"---------"+content+"end");
		
		String s1= "ab" + "cd";  
		String s2= "abc" + "d"; 
		System.out.println(s1==s2);
		String a122=new String("aaaaaa");
		a122=new String("dffgsa");
		
		StringBuilder stra=new StringBuilder();
		
		int[] values={3,1,6,2,9,0,7,4,5,8};
		//冒泡排序
		int a=0;
		for(int i=0;i<values.length-1;i++){
			for(int j=i+1;j<values.length;j++){
				if(values[i]>values[j]){
					a=values[i];
					values[i]=values[j];
					values[j]=a;
				}
			}
		}
		System.out.println(Arrays.toString(values));
		
		System.out.println(Arrays.toString(args));
		
		Date date=new Date(3600*1000);
		System.out.println(date);
		System.out.println(date.getTime());
		
		DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date aDate=new Date(123213213123l);
		String string=dateFormat.format(aDate);
		System.out.println(string);
		
		DateFormat da1=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		String str1="2016/12/31 21:22:31";
		try {
			Date date2=da1.parse(str1);
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar c=new GregorianCalendar();
		c.set(Calendar.YEAR,2001);
		Date date2=c.getTime();
		System.out.println(date2);
		System.out.println(date2.toString());
		
		List list=new ArrayList();
		list.add(1);*/
		
	}
}

class Wife{
	String name;
	public void Wife() {
		// TODO Auto-generated method stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Wife(String name) {
		super();
		this.name = name;
	}
	
	
}
