package com.revature.classes;

import javax.xml.bind.annotation.XmlRootElement;

//Might be only tag need for XmlClass thanks to reflections
//Can programatically generate guess for tags, can guess names for methods
//if follow conventions.
@XmlRootElement(name="XmlClass")
public class XmlClass {
	private int i;
	private String s;
	private boolean b;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	
	
}
