package com.ibm.demo.test.demo.reftype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Goods> list=new ArrayList<Goods>();
		list.add(new Goods(2000,100,"老妈视频"));
		list.add(new Goods(2000,50,"老高视频"));
		list.add(new Goods(1000,1000,"老裴视频"));
		System.out.println("排序前输出："+list);
		Collections.sort(list, new GoodsPriceComp());
		
		System.out.println("排序后输出："+list);
		System.out.println("排序前输出："+list);
		Collections.sort(list, new GoodsFavComp());
		
		System.out.println("排序后输出："+list);
		
		
	}

}
