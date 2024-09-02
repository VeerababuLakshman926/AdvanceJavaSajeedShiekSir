package com.dl.innerBeans.constructorInjection;

public class HondaCars {
	
	private String carModels;

	
	public HondaCars(String carModels) {
		this.carModels = carModels;
	}

	@Override
	public String toString() {
		return "HondaCars [carModels=" + carModels + "]";
	}
	
	
}
