package com.ibm.demo.test.demo.zijilianxi.commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.EqualPredicate;

public class PredicateDemo01 {

	public static void main(String[] args) {
		Predicate pre=new EqualPredicate("bjsxt");
		boolean aaa=pre.evaluate("gj");
		System.out.println(aaa);
		
		System.out.println("内置类型转换 长整形时间日期，转成指定格式的字符串");
		Transformer trans=new Transformer() {
			@Override
			public Object transform(Object obj) {
				return new SimpleDateFormat("yyyy-MM-dd").format((long)obj);
			}
		};
		//容器
		List<Long> list=new ArrayList<Long>();
		list.add(9999999999L);
		list.add(300000000L);
		//工具类 程序员出钱---开发商---农民工出力
		Collection<String> result=CollectionUtils.collect(list, trans);
		for(String time:result){
			System.out.println(time);
		}
	}

}
