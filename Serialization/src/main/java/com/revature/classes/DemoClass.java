package com.revature.classes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DemoClass")
public class DemoClass {
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
	public boolean equals(DemoClass demo) {
		boolean result =false;
		if(this.i == demo.i && this.s.equals(demo.s) && this.b == demo.b) {
			result = true;
		}
		return result;
	}
}
