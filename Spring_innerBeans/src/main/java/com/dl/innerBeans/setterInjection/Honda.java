package com.dl.innerBeans.setterInjection;

public class Honda {
	
	private HondaCars hondaCars;

	public HondaCars getHondaCars() {
		return hondaCars;
	}

	public void setHondaCars(HondaCars hondaCars) {
		this.hondaCars = hondaCars;
	}

	@Override
	public String toString() {
		return "Honda [hondaCars=" + hondaCars + "]";
	}
	
	
}
