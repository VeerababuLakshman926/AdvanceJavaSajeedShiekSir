package com.dl.innerBeans.constructorInjection;

public class Honda {
	
	private HondaCars hondaCars;

	
	public Honda(HondaCars hondaCars) {
		this.hondaCars = hondaCars;
	}


	@Override
	public String toString() {
		return "Honda [hondaCars=" + hondaCars + "]";
	}
	
	
}
