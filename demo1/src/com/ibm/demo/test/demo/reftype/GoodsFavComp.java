package com.ibm.demo.test.demo.reftype;

import java.util.Comparator;

/*
 * 收藏量升序
 */
public class GoodsFavComp implements Comparator<Goods>{
	@Override
	public int compare(Goods o1, Goods o2) {
		return o1.getFav()-o2.getFav()>0?1:(o1.getFav()==o2.getFav()?0:-1);
	}
}
