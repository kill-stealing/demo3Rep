package com.ibm.demo.test.demo.reftype;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class NewsItem implements Comparable<NewsItem>{
	private String title;
	private int hits;
	private Date pubTime;
	
	public NewsItem(){
		
	}
	
	public NewsItem(String title, int hits, Date pubTime) {
		super();
		this.title = title;
		this.hits = hits;
		this.pubTime = pubTime;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	//时间降序 点击量升序 标题降序
	@Override
	public int compareTo(NewsItem o) {
		// TODO Auto-generated method stub
		
		int result=0;
		//比较时间
		result=-this.pubTime.compareTo(o.pubTime);
		if(0==result){
			//
			result=this.hits-o.hits;
			System.out.println(result);
			if(0==result){
				result=-this.title.compareTo(o.title);
			}
		}else{
			return result;
		}
		return result;
	}
	
	public String toString(){
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("标题：").append(this.title);
		sBuilder.append(",时间：").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.pubTime));
		sBuilder.append(",点击量：").append(this.hits).append("\n");
		return sBuilder.toString();
	}
	
	
}
