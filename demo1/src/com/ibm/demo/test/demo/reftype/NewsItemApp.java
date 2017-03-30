package com.ibm.demo.test.demo.reftype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsItemApp {
	public static void main(String[] args) {
		List<NewsItem> newsItems=new ArrayList<NewsItem>();
		newsItems.add(new NewsItem("美国后怕了，逃跑了悲剧了",50,new Date(System.currentTimeMillis())));
		newsItems.add(new NewsItem("中国登上钓鱼岛了，全国欢呼了",100,new Date()));
		
		newsItems.add(new NewsItem("小日本终于听话了，泪流满面笑了",60,new Date(System.currentTimeMillis()+1000)));
		System.out.println("排序前 "+newsItems);
		
		//排序
		Collections.sort(newsItems);
		System.out.println("排序后"+newsItems);
	}
}
