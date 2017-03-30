package com.ibm.demo.test.demo.iterator;

public abstract class Father<T1,T2> {
	T1 id;
	public abstract void getName(T2 name);
}

class Fruit{
	
}
class Apple extends Fruit{
	
}
class Pear extends Fruit{
	
}

class FujiApple extends Fruit{
	
}

