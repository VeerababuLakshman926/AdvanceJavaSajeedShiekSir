package com.dl.ConstructorType;

public class Honda {
	
	private Models models;
	
	public Honda(Models models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Honda [models=" + models + "]";
	}
	
}
