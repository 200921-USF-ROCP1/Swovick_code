package com.revature.genericinterface;

public class ImplementsGI implements GenericInterface<Integer>{
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	/*@Override
	public Object add(Object a, Object b) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
