package com.dl.innerBeans.setterInjection;

public class HondaCars {
	
	private String carModels;

	public String getCarModels() {
		return carModels;
	}

	public void setCarModels(String carModels) {
		this.carModels = carModels;
	}

	@Override
	public String toString() {
		return "HondaCars [carModels=" + carModels + "]";
	}
	
	
}
