package com.ibm.demo.test.demo.reftype;

import java.util.Comparator;


/*
 * 价格排序（降序）
 */
public class GoodsPriceComp implements Comparator<Goods>{

	@Override
	public int compare(Goods o1, Goods o2) {
		return -(o1.getPrice()-o2.getPrice()>0?1:(o1.getPrice()==o2.getPrice()?0:-1));
	}

}
