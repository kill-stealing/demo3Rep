package com.ibm.demo.test.demo.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.ChainedClosure;
import org.apache.commons.collections.functors.IfClosure;
import org.apache.commons.collections.functors.WhileClosure;

/*
 * 函数式编程 closure 闭包 封装特定的业务功能
 * 1.Closure
 * 2.IfClosure ifClosure.ifClosure(断言，功能1，功能2)
 * 3.whileClosure WhileClosure.whileClosure(断言，功能1，标识)
 */
public class Demo03 {
	public static void main(String[] args) {
//		basic();
//		ifClosure();
		whileClosure();
//		chainClosure();
	}
	
	/*
	 * 折上减 先打折商品，进行打九折，否则满百减20
	 */
	public static void chainClosure(){
		List<Goods> list=new ArrayList<Goods>();
		list.add(new Goods("javase 视频",120,true));
		list.add(new Goods("javaee 视频",100,false));
		list.add(new Goods("高新技术视频",80,false));
		
		//满百减20
		Closure substract=new Closure() {
			@Override
			public void execute(Object obj) {
				Goods goods=(Goods)obj;
				if(goods.getPrice()>=100){
					goods.setPrice(goods.getPrice()-20);
				}
			}
		};
		
		//打折
		Closure discouClosure=new Closure() {
			@Override
			public void execute(Object obj) {
				Goods goods=(Goods)obj;
				if(goods.isDiscount()){
					goods.setPrice(goods.getPrice()*0.9);
				}
			}
		};
		//二选一
		Closure chainedClosure=ChainedClosure.getInstance(discouClosure,substract);
		CollectionUtils.forAllDo(list, chainedClosure);
		
		
		//查看操作后的数据
		Iterator<Goods> iterator=list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	/*
	 * 二选一 如果是打折商品，进行打九折，否则满百减20
	 */
	public static void ifClosure(){
		List<Goods> list=new ArrayList<Goods>();
		list.add(new Goods("javase 视频",120,true));
		list.add(new Goods("javaee 视频",100,false));
		list.add(new Goods("高新技术视频",80,false));
		
		//满百减20
		Closure substract=new Closure() {
			@Override
			public void execute(Object obj) {
				Goods goods=(Goods)obj;
				if(goods.getPrice()>=100){
					goods.setPrice(goods.getPrice()-20);
				}
			}
		};
		
		//打折
		Closure discouClosure=new Closure() {
			@Override
			public void execute(Object obj) {
				Goods goods=(Goods)obj;
				if(goods.isDiscount()){
					goods.setPrice(goods.getPrice()*0.9);
				}
			}
		};
		
		Predicate subPredicate=new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				Goods goods=(Goods)obj;
				return goods.isDiscount();
			}
		};
		
		//二选一
		Closure ifClosure=IfClosure.getInstance(subPredicate, discouClosure, substract);
		CollectionUtils.forAllDo(list, ifClosure);
		
		
		//查看操作后的数据
		Iterator<Goods> iterator=list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static void  basic(){
		//数据
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee("bjsxt",20000));
		list.add(new Employee("is",10000));
		list.add(new Employee("good",5000));
		
		//业务功能
		Closure colClosure=new Closure() {
			@Override
			public void execute(Object obj) {
				Employee employee=(Employee)obj;
				employee.setSalary(employee.getSalary()*1.2);
			}
		};
		//工具类
		CollectionUtils.forAllDo(list, colClosure);
		Iterator<Employee> emplt=list.iterator();
		while (emplt.hasNext()) {
			System.out.println(emplt.next());
		}
	}
	
	public static void  whileClosure(){
		//数据
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee("bjsxt",20000));
		list.add(new Employee("is",10000));
		list.add(new Employee("good",5000));
		
		//业务功能
		Closure colClosure=new Closure() {
			@Override
			public void execute(Object obj) {
				Employee employee=(Employee)obj;
				employee.setSalary(employee.getSalary()*1.2);
			}
		};
		
		//判断
		Predicate predicate=new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				Employee employee=(Employee)obj;
				return employee.getSalary()<10000;
			}
		};
		
		//false 表示while结构先判断后执行 true do while 先执行后判断
		Closure whileClosure=WhileClosure.getInstance(predicate, colClosure, true);
		
		//工具类
		CollectionUtils.forAllDo(list, whileClosure);
		Iterator<Employee> emplt=list.iterator();
		while (emplt.hasNext()) {
			System.out.println(emplt.next());
		}
	}

}
