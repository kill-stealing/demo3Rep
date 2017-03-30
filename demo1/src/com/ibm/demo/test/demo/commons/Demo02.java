package com.ibm.demo.test.demo.commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.SwitchTransformer;

public class Demo02 {
	public static void main(String[] args) {
		System.out.println("自定义判断");
		//判别式
		Predicate isLowPredicate=new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				Employee employee=(Employee)obj;
				return employee.getSalary()<10000;
			}
		};
		
		Predicate isHigh=new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				Employee employee=(Employee)obj;
				return employee.getSalary()>10000;
			}
		};
		
		Predicate[] pres={isLowPredicate,isHigh};
		
		Transformer lowTran=new Transformer() {
			
			@Override
			public Level transform(Object obj) {
				Employee employee=(Employee)obj;
				return new Level(employee.getName(),"卖身中");
			}
		};
		
		Transformer highTran=new Transformer() {
			
			@Override
			public Level transform(Object obj) {
				Employee employee=(Employee)obj;
				return new Level(employee.getName(),"养身中");
			}
		};
		
		Transformer[] tranArr={lowTran,highTran};
		
		//二者进行了关联
		Transformer switchTrans=new SwitchTransformer(pres, tranArr, null);
		
		//容器
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee("老马",100000));
		list.add(new Employee("老裴",9999));
		
		Collection<Level> levelList=CollectionUtils.collect(list,switchTrans);
		
		//遍历容器
		Iterator<Level> levelIterator=levelList.iterator();
		while (levelIterator.hasNext()) {
			System.out.println(levelIterator.next());
		}
	}
	
	public static void transInternal(){

		System.out.println("内置类型转换 长整形时间日期，转成指定格式的字符串");
		//类型转换器
		Transformer trans=new Transformer() {
			@Override
			public Object transform(Object obj) {
				// TODO Auto-generated method stub
				return new SimpleDateFormat("yyyy年MM月dd日").format(obj);
			}
		};
		//容器
		List<Long> list=new ArrayList<Long>();
		list.add(999L);
		list.add(300000000L);
		//工具类 程序员出钱 农民工出力
		Collection<String> result=CollectionUtils.collect(list, trans);
		for(String time:result){
			System.out.println(time);
		}
	
	}
}
