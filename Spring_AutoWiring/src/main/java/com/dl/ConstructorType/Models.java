package com.dl.ConstructorType;

public class Models {
	
	private String models;
	private String type;
	
	
	public Models(String models, String type) {
		this.models = models;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Models [models=" + models + ", type=" + type + "]";
	}
	
}
